package helpers;

import parsers.MyJsonSimpleParser;
import thread.MyThread;

public class HelperJsonSimple extends MyThread{

	public HelperJsonSimple(String url) {
		super(url);
	}

	@Override
	public void parsing() {
		this.setHospital(MyJsonSimpleParser.jsonParser(this.urlConnection()));
	}
}
