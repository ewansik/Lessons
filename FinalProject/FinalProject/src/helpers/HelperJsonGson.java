/**
 * Класс HelperJsonGson, наследуемый от MyThread.
 */
package helpers;

import parsers.MyGsonParser;
import thread.MyThread;

public class HelperJsonGson extends MyThread{
	
	/**
	 * Конструктор класса HelperJsonGson.
	 * @param url
	 */
	public HelperJsonGson(String url) {
		super(url);
	}

	/**
	 * Переопределение метода parsing() класса MyThread.
	 */
	@Override
	public void parsing() {
		this.setHospital(MyGsonParser.gsonParser(this.urlConnection()));
	}
}
