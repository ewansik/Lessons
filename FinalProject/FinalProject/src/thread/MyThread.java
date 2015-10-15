package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class MyThread extends Thread{

	private String urlDocument;
	
	public MyThread(String url)
	{
		this.setUrl(url);
	}
	
	public String getUrl() {
		return urlDocument;
	}

	public void setUrl(String url) {
		this.urlDocument = url;
	}

	public BufferedReader UrlConnection()
	{
		URL url;
		HttpURLConnection connection;
		BufferedReader in = null;
		
		try {
			url = new URL(urlDocument);
			connection = (HttpURLConnection)url.openConnection();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}	 
		
		return in;
	}
	
	public abstract void Parsing();
}
