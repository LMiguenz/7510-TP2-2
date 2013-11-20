package unitTestFWK;

import java.io.File;

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

public class XMLResultHistory {
	private Document document;
	private Element rootElement;
	private String fileName;

	public XMLResultHistory(String fileName) {
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

	public void saveResults(Test test) {
		Element testElement = document.createElement("TestCase");
		testElement.setAttribute("name", test.getName());
		testElement.setAttribute("status", test.getResult().getCode());
		rootElement.appendChild(testElement);
	}

	public void generateDocument() throws TransformerException {
		// Write the content into xml file
		TransformerFactory transformerFactory =
				TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.document);
		StreamResult result = new StreamResult(new File(fileName));

		transformer.transform(source, result);
	}
}