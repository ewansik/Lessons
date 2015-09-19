/**
 * Class to simulate the work registry.
 */

package com.vynipox.glm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Registry {

	/**
	 * Static method that matches the patient and the doctor. 
	 */
	public static void matchPatienDoctor()
	{
		//Declaring collections for doctors and patients.
		Map<Integer, String> mapPatient = new HashMap<Integer, String>();
		Map<Integer, String> mapDoctor  = new HashMap<Integer, String>();
		
		//Get collections.
		mapPatient = Patient.getMap();
		mapDoctor  = Doctor.getMap();
		
		//The cycle for the selection of doctors and patients.
		for( Entry<Integer, String> entryPatient : mapPatient.entrySet() ){
			for( Entry<Integer,String> entryDoctor : mapDoctor.entrySet())
			{
				if(entryDoctor.getValue().equals(entryPatient.getValue()))
				{
					System.out.println("--------------------------------------------------------------------");
					System.out.printf("The patient[%s] may apply to [%s].\n",Patient.getMapParameters(entryPatient.getKey()),Doctor.getMapParameters(entryDoctor.getKey()));
				}
			}
		}
	}
}
