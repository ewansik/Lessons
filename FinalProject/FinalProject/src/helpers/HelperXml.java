package helpers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import parsers.MySAXParser;
import thread.MyThread;

public class HelperXml extends MyThread{
	
	public HelperXml(String url) {
		super(url);
	}

	@Override
	public void Parsing() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		MySAXParser mySAXParser = new MySAXParser();
		
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(this.getUrl(), mySAXParser);
			this.setHospital(mySAXParser.getHospital());
			
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
