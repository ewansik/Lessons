/**
 * Класс ParserFactory. Реализует Factory pattern.
 */
package factory;

import constants.MyConstants;
import helpers.HelperJsonGson;
import helpers.HelperJsonSimple;
import helpers.HelperXml;
import thread.MyThread;

public class ParserFactory {
	
	/**
	 * Статический метод getParser().
	 * @param typeOfParsing
	 * @return
	 */
	public static MyThread getParser(String typeOfParsing)
	{
		//В зависимости от полученного параметра создает необходимый экземпляр класса.
		if(typeOfParsing.equals("1"))
		{
			System.out.println();
			System.out.println("Вы выбрали XML парсер.");
			return new HelperXml(MyConstants.XML_URL);
		}
		else if(typeOfParsing.equals("2"))
		{
			System.out.println();
			System.out.println("Вы выбрали Json Simple парсер.");
			return new HelperJsonSimple(MyConstants.JSON_URL);
		}
		else if(typeOfParsing.equals("3"))
		{
			System.out.println();
			System.out.println("Вы выбрали Json Gson парсер.");
			return new HelperJsonGson(MyConstants.JSON_URL);
		}
		
		return null;
	}
}
