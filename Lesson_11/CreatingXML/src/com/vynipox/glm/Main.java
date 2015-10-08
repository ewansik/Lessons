/**
 * Main class.
 */
package com.vynipox.glm;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

	public static void main(String[] args) {
		
		//Variable declaration.
		DocumentBuilderFactory builderFactory =  DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document =  builder.newDocument();
			
			//Creating new elements in document.
			Element root = document.createElement("Hospital");
			document.appendChild(root);
			
			Element hospitalName = document.createElement("HospitalName");
			hospitalName.setTextContent("Hello!");
			root.appendChild(hospitalName);
			
			Element patient = document.createElement("Patient");
			root.appendChild(patient);
			
			Element age = document.createElement("Age");
			age.setTextContent("10");
			patient.appendChild(age);
			
			Element name = document.createElement("Name");
			name.setTextContent("Igor");
			patient.appendChild(name);
			
			Element surname = document.createElement("Surname");
			surname.setTextContent("Flagov");
			patient.appendChild(surname);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("file.xml"));

			//Create new document.
			transformer.transform(source, result);

			System.out.println("File saved!");
			
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
	}
}
