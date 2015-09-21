/**
 * Main class.
 */
package com.vynipox.glm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Declaring variables.
		Scanner scaner = new Scanner(System.in);
		Patient patient;		
		Map<Patient, List<Doctor>> list = new HashMap<Patient, List<Doctor>>();
		boolean checkDoctors = false;
		
		Hospital hospital = new Hospital();
		
		System.out.println("Welcom to our hospital!");
		
		//Creating patients
		hospital.createCustomPatient(scaner);
		hospital.createCustomPatient(scaner);
		hospital.createCustomPatient(scaner);
		hospital.createRandomPatient();
		hospital.createRandomPatient();

		
		//Creating doctors
		hospital.createRandomDoctor();
		hospital.createRandomDoctor();
		hospital.createRandomDoctor();
		hospital.createRandomDoctor();
		hospital.createRandomDoctor();

		System.out.println("--------------------------------------------------------------------------");
		//Output doctors and patients.
		hospital.outputDoctors();
		System.out.println("--------------------------------------------------------------------------");
		hospital.outputPatients();
		System.out.println("--------------------------------------------------------------------------");
		
		list = hospital.getMatches();
		
		//Output matches.
		for (Entry<Patient, List<Doctor>> entry : list.entrySet() ) {
			patient = entry.getKey();
			
			System.out.print("Patient: ");
			System.out.printf("Name - %s, Last name - %s, Age - %d,Diagnosis - %s\n\n",patient.getName(),patient.getLastName(),patient.getAge(),patient.getDiagnosis());
			
			for (Doctor doctor : entry.getValue()) {
				checkDoctors = true;
				
				System.out.print("Doctor: ");
				System.out.printf("Name - %s, Last name - %s, Cabinet - %d,Diagnosis - %s\n",doctor.getName(),doctor.getLastName(),doctor.getCabinet(),doctor.getSpecialization());
			}
			
			if(!checkDoctors)
			{
				System.out.println("Doctors not found.");
			}
			
			checkDoctors = false;
			System.out.println("--------------------------------------------------------------------------");
		}
		
		scaner.close();
	}
}
