package helpers;

import parsers.MyGsonParser;
import thread.MyThread;

public class HelperJsonGson extends MyThread{
	
	public HelperJsonGson(String url) {
		super(url);
	}

	@Override
	public void parsing() {
		this.setHospital(MyGsonParser.gsonParser(this.urlConnection()));
	}
}
