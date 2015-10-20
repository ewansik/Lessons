package factory;

import constants.MyConstants;
import helpers.HelperJsonGson;
import helpers.HelperJsonSimple;
import helpers.HelperXml;
import thread.MyThread;

public class ParserFactory {
	
	public static MyThread getParser(String typeOfParsing)
	{
		if(typeOfParsing.equals("1"))
		{
			System.out.println("You have selected the XML parsing.");
			return new HelperXml(MyConstants.XML_URL);
		}
		else if(typeOfParsing.equals("2"))
		{
			System.out.println("You have selected the JSON simple parsing.");
			return new HelperJsonSimple(MyConstants.JSON_URL);
		}
		else if(typeOfParsing.equals("3"))
		{
			System.out.println("You have selected the JSON Gson parsing.");
			return new HelperJsonGson(MyConstants.JSON_URL);
		}
		
		return null;
	}
}
