/**
 * Class to simulate the database for patient.
 */

package com.vynipox.glm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class Patient {

	//Declaring variables for patient name, last name and diagnosis.	
	private String name;
	private String lastName;
	private String diagnosis;
	private String list;
	
	private int spezialNumber;
	
	//Declaring array for diagnosis.
	private static String[] diagnosisFor = {"Lohr","Surgeon","Beautician","Cardiologist","Therapist"};
	
	//Declaring collections for patients.
	private static Map<Integer,String> map = new HashMap<Integer,String>();
	private static Map<Integer, String> mapParameters = new HashMap<Integer, String>();
	
	private static int unicIndex;

	/**
	 * Class constructor.
	 */
	public Patient()
	{
		Random rand = new Random();

		//Auto-fill data.		
		diagnosis = diagnosisFor[rand.nextInt(5)];
	}

	/**
	 * Get method for last name.
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set method for last name.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		lastName.toLowerCase();
		lastName = Character.toString(lastName.charAt(0)).toUpperCase()+lastName.substring(1);
		this.lastName = lastName;
	}

	/**
	 * Get method for name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for name.
	 * @param name
	 */
	public void setName(String name) {
		name.toLowerCase();
		name = Character.toString(name.charAt(0)).toUpperCase()+name.substring(1);
		this.name = name;
	}
	
	/**
	 * The method of initialization parameters.
	 */
	public void setParameters()
	{
		spezialNumber = unicIndex;
		list = name + " " + lastName + " " + diagnosis;
		
		map.put(spezialNumber, diagnosis);
		mapParameters.put(spezialNumber, list);
		
		unicIndex++;
	}

	/**
	 * Get method for map collection.
	 * @return
	 */
	public static Map<Integer, String> getMap() {
		return map;
	}

	/**
	 * Set method for map collection.
	 * @param map
	 */
	public static void setMap(Map<Integer, String> map) {
		Patient.map = map;
	}
	
	/**
	 * Static method which returns information about the patient.
	 * @param i
	 * @return
	 */
	public static String getMapParameters(Integer i)
	{
		String value = "";
		
		for( Entry<Integer, String> entry : mapParameters.entrySet())
		{
			if(entry.getKey().equals(i))
			{
				value = entry.getValue();
				break;
			}
		}
		
		return value;
	}
	
	/**
	 * Static method for displaying information about patient.
	 */
	public static void outputPatient()
	{
		System.out.println("--------------------------------------------------------------------");
		
		for( Entry<Integer, String> entry : mapParameters.entrySet() ){
			System.out.println("Patient:" + entry.getValue() );
		}
	}
}
