package unitTestFWK;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLStorage implements Storage {
	private Document document;
	private Element rootElement;
	private String fileName;

	public XMLStorage(String fileName) {
		this.fileName = fileName;
		try {
			DocumentBuilderFactory docFactory =
					DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root element
			this.document = docBuilder.newDocument();
			this.rootElement = document.createElement("TestsResults");
			document.appendChild(rootElement);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean storeSuiteResults(TestSuite suite) {
		Collection<Test> tests = suite.getTests();
		for (Test test : tests) {
			saveResults(test);
		}
		try {
			generateDocument();
		}
		catch (TransformerException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public HashMap<String, TestResult> restoreSuiteResults() {
		// TODO hacer
		return null;
	}

	private void saveResults(Test test) {
		Element testElement = document.createElement("TestCase");
		testElement.setAttribute("name", test.getName());
		testElement.setAttribute("status", test.getResult().getCode());
		rootElement.appendChild(testElement);
	}

	private void generateDocument() throws TransformerException {
		// Write the content into xml file
		TransformerFactory transformerFactory =
				TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.document);
		StreamResult result = new StreamResult(new File(fileName));

		transformer.transform(source, result);
	}

	// Convierte el XMLHistory en un HashSet
	private void restoreDocument(String fileName) {
		System.out.println("entro en el metodo restoreDocument");
		HashSet<TagList> tags = new HashSet<TagList>();
		try {
			File xmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory =
					DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("TestCase");
			int totalTests = nList.getLength();

			System.out.println("Número total de personas : " + totalTests);

			for (int temp = 1; temp < nList.getLength(); temp++) {

				Node testCaseNode = nList.item(temp);

				if (testCaseNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) testCaseNode;
					System.out.println("NAME : "
							+ getTagValue("name", eElement));
					System.out.println("STATUS : "
							+ getTagValue("status", eElement));
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("salio del metodo restoreDocument");
		// return tags;
	}

	private String getTagValue(String tag, Element elemento) {
		NodeList lista =
				elemento.getElementsByTagName(tag).item(0).getChildNodes();
		Node valor = (Node) lista.item(0);
		return valor.getNodeValue();
	}
}