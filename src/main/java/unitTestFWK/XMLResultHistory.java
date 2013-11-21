package unitTestFWK;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	
	//Convierte el XMLHistory en un HashSet
	public void restoreDocument(String fileName){
		HashSet<TagList> tags = new HashSet<TagList>();
		try{
			File xmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("TestsResults");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				 
				Node nNode = nList.item(temp);
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("NAME : " + eElement.getElementsByTagName("TestCase").item(1).getTextContent());
				}
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		//return tags;
		
	}
}