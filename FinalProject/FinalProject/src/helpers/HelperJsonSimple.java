/**
 * Класс HelperJsonSimple, наследуемый от MyThread.
 */
package helpers;

import parsers.MyJsonSimpleParser;
import thread.MyThread;

public class HelperJsonSimple extends MyThread{

	/**
	 * Конструктор класса HelperJsonSimple.
	 * @param url
	 */
	public HelperJsonSimple(String url) {
		super(url);
	}

	/**
	 * Переопределение метода parsing() класса MyThread.
	 */
	@Override
	public void parsing() {
		this.setHospital(MyJsonSimpleParser.jsonParser(this.urlConnection()));
	}
}
