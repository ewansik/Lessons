package parsers;

import java.io.BufferedReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Hospital;

public class MyGsonParser {
	
	public static Hospital GsonParser(BufferedReader bufferedReader)
	{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		return  gson.fromJson(bufferedReader, Hospital.class);
	}
}
