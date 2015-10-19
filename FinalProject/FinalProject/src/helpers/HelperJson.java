package helpers;

import parsers.MyGsonParser;
import parsers.MyJsonSimpleParser;
import thread.MyThread;

public class HelperJson extends MyThread{

	private String type;
	
	public HelperJson(String url, String type) {
		super(url);
		this.setType(type);
	}

	@Override
	public void parsing() {
		
		switch(type)
		{
			case "1":
				this.setHospital(MyGsonParser.gsonParser(this.urlConnection()));
				break;
				
			case "2":
				this.setHospital(MyJsonSimpleParser.jsonParser(this.urlConnection()));
				break;
		}
	}

	public void setType(String type) {
		this.type = type;
	}
}
