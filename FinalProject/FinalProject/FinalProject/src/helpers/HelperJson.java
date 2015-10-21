package helpers;

import parsers.MyGsonParser;
import thread.MyThread;

public class HelperJson extends MyThread{

	public HelperJson(String url) {
		super(url);
	}

	@Override
	public void Parsing() {
		this.setHospital(MyGsonParser.GsonParser(this.UrlConnection()));
	}
}
