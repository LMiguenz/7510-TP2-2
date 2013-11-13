package main.java;

import java.io.File;
import java.util.HashMap;

import javax.management.Attribute;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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
	private HashMap<Integer, Element> treeElements = new HashMap<Integer, Element>();
	private Integer level;
	
	public XMLResultPrinter() throws ParserConfigurationException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// Root element
		this.document = docBuilder.newDocument();
		this.rootElement = document.createElement("UnitTest");
		document.appendChild(rootElement);
		//this.previousElement = this.rootElement;
		this.level = 0;
		addElement(rootElement);
	}
	
	private void addElement(Element element) {
		treeElements.put(level, element);
		this.level++;
	}
	
	private Element getElement(Integer level) {
		while ("testcase" == treeElements.get(level).getNodeName()) {
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
		
		Integer level = this.level;
		level--;
		Element previousElement = getElement(level);
		previousElement.appendChild(testElement);
		addElement(testElement);
	}
	
	@Override
	public void printSuite(TestSuite suite) {
		Element testSuiteElement = document.createElement("testsuite");
		testSuiteElement.setAttribute("name", suite.getName());

		Integer level = this.level;
		level--;
		Element previousElement = getElement(level);
		previousElement.appendChild(testSuiteElement);
		addElement(testSuiteElement);
	}

	@Override
	public void removeSuite(TestSuite suite) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printSummary() {
		try {
			generateDocument();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private void generateDocument() throws TransformerException {
		// Write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.document);
		StreamResult result = new StreamResult(new File(fileName));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 		transformer.transform(source, result);
	}
}
