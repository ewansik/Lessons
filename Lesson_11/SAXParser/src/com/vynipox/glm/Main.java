/**
 * Main class.
 */
package com.vynipox.glm;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import manager.SAXPars;
import model.People;

public class Main {

	public static void main(String[] args) {
		
		//Variables declaration.
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXPars sax = new SAXPars();
		
		try {
			
			SAXParser parser = factory.newSAXParser();
			parser.parse(new File("test.xml"), sax);
			
		} catch (ParserConfigurationException | SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
		List<People> list = sax.getList();
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("People objects:");
		for (People people : list) {
			System.out.println(people.toString());
		}
	}
}
