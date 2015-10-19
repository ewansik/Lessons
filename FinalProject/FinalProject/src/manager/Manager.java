package manager;

import constants.MyConstants;
import helpers.HelperJson;
import helpers.HelperXml;
import model.Hospital;
import thread.MyThread;

public class Manager {

	private Hospital hospital;
	
	private Manager()
	{	
	}

	public void parseJson(String typeOfLibrary)
	{
		HelperJson helperJson = new HelperJson(MyConstants.JSON_URL, typeOfLibrary);
		this.startParsing(helperJson);
	}
	
	public void parseXML()
	{
		HelperXml helperXml = new HelperXml(MyConstants.XML_URL);
		this.startParsing(helperXml);
	}
	
	public void startParsing(MyThread myThread)
	{
		myThread.start();
		System.out.println("Parsing run.");
		
		try {
			myThread.join();
			this.setHospital(myThread.getHospital());
			System.out.println("Parsing has been completed.");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}	
	
	public Hospital getHospital() {
		return hospital;
	}
	

	/**
	 * Singleton class.
	 * @author gleb.maliborsky
	 *
	 */
	private static class SingletonHolder
	{
		private final static Manager INSTANCE = new Manager();
	}
	
	/**
	 * Get instance method.
	 * @return
	 */
	public static Manager getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
}
