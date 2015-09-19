/**
 * Class to simulate the database for doctors.
 */

package com.vynipox.glm;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Doctor {

	//Declaring arrays for names, last names and specializations.
	private final String[] names 	       = {"Stive","Erik","Bret","Benjamin","Greg","Patrik","Elie"};
	private final String[] lastNames 	   = {"Jobs","Hanson","Kornet","Brezenk","Litle","Layout","Bah"};
	private final String[] specializations = {"Lohr","Surgeon","Beautician","Cardiologist","Therapist"};
	
	//Declaring variables for doctor name, last name and specialization.	
	private String name;
	private String lastName;
	private String specialization;
	
	//Declaring variables for doctor cabinet and spezialNumber.
	private int cabinet;
	private int spezialNumber;

	//Declaring collections for doctors.
	private static int unicIndex = 0;
	private static Map<Integer, String> map = new HashMap<Integer, String>();
	private static Map<Integer, String> mapParameters = new HashMap<Integer, String>();
	
	private String list;
	
	/**
	 * Class constructor.
	 */
	public Doctor()
	{
		Random rand = new Random();

		//Auto-fill data.
		name 		   = names[rand.nextInt(7)];
		lastName 	   = lastNames[rand.nextInt(7)];
		specialization = specializations[rand.nextInt(5)];
		cabinet 	   = rand.nextInt(10) + 100;
		spezialNumber  = unicIndex;

		list = name + " " + lastName + " " + specialization + " " + cabinet;

		map.put(spezialNumber, specialization);
		mapParameters.put(spezialNumber, list);
		
		System.out.printf("Doctror:%s %s,Specialization - %s, Cabinet - %d\n",name,lastName,specialization,cabinet);

		unicIndex++;
	}
	
	/**
	 * Get method for the map collection.
	 * @return
	 */
	public static Map<Integer, String> getMap() {
		return map;
	}

	/**
	 * Set method for the map collection.
	 * @param map
	 */
	public static void setMap(Map<Integer, String> map) {
		Doctor.map = map;
	}
	
	/**
	 * Static method which returns information about the doctor.
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
}
