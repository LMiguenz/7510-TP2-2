package main.java;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLResultPrinter extends ResultPrinter {

	private static XMLResultPrinter instance = null;
	
	private Document document;
	private Element rootElement;
	private String fileName = "file.xml";
	// List of element added to the document.
	private HashMap<Integer, Element> treeElements = new HashMap<Integer, Element>();
	private Integer level; // Index to reference the treeElements HashMap
	
	public XMLResultPrinter() throws ParserConfigurationException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// Root element
		this.document = docBuilder.newDocument();
		this.rootElement = document.createElement("UnitTest");
		document.appendChild(rootElement);
		this.level = 0;
		addElement(rootElement);
	}
	
	private void addElement(Element element) {
		treeElements.put(level, element);
		this.level++;
	}
	
	private Element getParentElement(Integer level) {
		// Loking for an element "testsuite" or "UnitTest"
		while ("testcase" == treeElements.get(level).getNodeName()) {
			level--;
		}
		return treeElements.get(level);
	}

	private Element getSuiteParentElement(Integer level) {
		boolean previousElementWasATest = false;
		
		// Check if previous element was a Test
		if ("testcase" == treeElements.get(level).getNodeName()) {
			// In this case, I have to decrease one more level to find the parent
			previousElementWasATest = true;
		}
		
		// Loking for an element "testsuite" or "UnitTest"
		while ("testcase" == treeElements.get(level).getNodeName()) {
			level--;
		}

		if (previousElementWasATest) {
			level--;
		}
		return treeElements.get(level);
	}

	
	public static XMLResultPrinter getInstance() throws ParserConfigurationException {
		if(instance == null) {
			instance = new XMLResultPrinter();
		}
		return instance;
	}

	public void printTest(Test test) {
		Element testElement = document.createElement("testcase");
		testElement.setAttribute("name", test.getName());
		Attr attr = document.createAttribute("result");
		attr.setValue(test.getResult().getCode());
		testElement.setAttributeNode(attr);

		Element executionTime = document.createElement("time");
		executionTime.appendChild(document.createTextNode(Long.toString(test.getTimeElapsed())  + " ms"));
		testElement.appendChild(executionTime);

		Integer level = this.level;
		level--;
		Element previousElement = getParentElement(level);
		previousElement.appendChild(testElement);
		addElement(testElement);
		test.getResult().updateMe(this);
	}
	
	@Override
	public void printSuite(TestSuite suite) {
		Element testSuiteElement = document.createElement("testsuite");
		testSuiteElement.setAttribute("name", suite.getName());

		Integer level = this.level;
		level--;
		Element previousElement = getSuiteParentElement(level);
		previousElement.appendChild(testSuiteElement);
		addElement(testSuiteElement);
	}

	@Override
	public void removeSuite(TestSuite suite) {
	}

	@Override
	public void printSummary() {
		addSummaryElement();
		try {
			generateDocument();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private void addSummaryElement() {
		int totalTests = okTests + failedTests + errorTests;
		
		Element testsPassed = document.createElement("passed");
		testsPassed.appendChild(document.createTextNode(Integer.toString(okTests)));
		
		Element testsFail = document.createElement("fail");
		testsFail.appendChild(document.createTextNode(Integer.toString(failedTests)));
		
		Element testsError = document.createElement("error");
		testsError.appendChild(document.createTextNode(Integer.toString(errorTests)));
		
		Element summary = document.createElement("summary");
		summary.setAttribute("total_tests", Integer.toString(totalTests));

		summary.appendChild(testsPassed);
		summary.appendChild(testsFail);
		summary.appendChild(testsError);
		
		// Get root element
		Element rootElement = treeElements.get(0);
		rootElement.appendChild(summary);
	}
	
	private void generateDocument() throws TransformerException {
		// Write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.document);
		StreamResult result = new StreamResult(new File(fileName));
 
 		transformer.transform(source, result);
	}
}
