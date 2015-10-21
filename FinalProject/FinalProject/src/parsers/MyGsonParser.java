/**
 * Класс MyGsonParser. Предназначен для парсинга Json файлов при помощи библиотеки Gson.
 */
package parsers;

import java.io.BufferedReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Hospital;

public class MyGsonParser {
	
	/**
	 * Статический метод gsonParser().
	 * @param bufferedReader
	 * @return
	 */
	public static Hospital gsonParser(BufferedReader bufferedReader)
	{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		return  gson.fromJson(bufferedReader, Hospital.class);
	}
}
