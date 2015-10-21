/**
 * Абстрактный класс, наследуемый ок класса Thread. Реализует скачивание XML или JSON файлов.
 * Содержит абстрактный метод для реализации парсинга.
 */

package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import model.Hospital;

public abstract class MyThread extends Thread{

	//Объявление переменных.
	private Hospital hospital;
	private String urlDocument;
	
	public MyThread(String url)
	{
		this.setUrl(url);
	}
	
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getUrl() {
		return urlDocument;
	}

	public void setUrl(String url) {
		this.urlDocument = url;
	}
	
	/**
	 * Переопределение метода run() класса Thread.
	 */
	@Override
	public void run() {
		parsing();
	}

	/**
	 * Метод реализующий скачивание файла.
	 * @return
	 */
	public BufferedReader urlConnection()
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
	
	/**
	 * Абстрактный метод для парсинга файла.
	 */
	public abstract void parsing();
}
