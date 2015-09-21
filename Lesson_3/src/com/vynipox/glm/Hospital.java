/**
 * Hospital class.
 */

package com.vynipox.glm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hospital {

	private Random random;
	
	//Declaring lists for doctors and patients.
	private List<Doctor> doctors;
	private List<Patient> patients;
	
	//Declaring arrays for random values.
	private final String[] diagnosisFor    = {"Lohr","Surgeon","Beautician","Cardiologist","Therapist"};
	private final String[] names 	       = {"Stive","Erik","Bret","Benjamin","Greg","Patrik","Elie"};
	private final String[] lastNames 	   = {"Jobs","Hanson","Kornet","Brezenk","Litle","Layout","Bah"};
	
	/**
	 * Class constructor.
	 */
	public Hospital()
	{
		doctors  = new ArrayList<Doctor>();
		patients = new ArrayList<Patient>();
		random   = new Random();
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	
	/**
	 * Method of creating patients. 
	 * @param name
	 * @param lastName
	 * @param age
	 * @param diagnosis
	 */
	public void createPatient(String name, String lastName, int age, String diagnosis)
	{
		Patient patient = new Patient(name, lastName, age, diagnosis);
		
		patients.add(patient);
	}
	
	/**
	 * Method of creating random patients. 
	 */
	public void createRandomPatient()
	{
		this.createPatient(this.randomizeString(names),this.randomizeString(lastNames),random.nextInt(100),this.randomizeString(diagnosisFor));
	}
	
	/**
	 * Method of creating custom patients. 
	 * @param scaner
	 */
	public void createCustomPatient(Scanner scaner)
	{	
		this.createPatient(this.inputString("Enter the name of the patient:",scaner),this.inputString("Enter the last name of the patient:",scaner),random.nextInt(100),this.randomizeString(diagnosisFor));
	}

	/**
	 * Method of creating doctors. 
	 * @param name
	 * @param lastName
	 * @param cabinet
	 * @param specialization
	 */
	public void createDoctor(String name, String lastName, int cabinet, String specialization)
	{
		Doctor doctor = new Doctor(name, lastName, cabinet, specialization);
		
		doctors.add(doctor);
	}
	
	/**
	 * Method of creating random doctors. 
	 */
	public void createRandomDoctor()
	{
		this.createDoctor(this.randomizeString(names),this.randomizeString(lastNames),random.nextInt(100),this.randomizeString(diagnosisFor));
	}

	/**
	 * Method of creating random values. 
	 * @param strings
	 * @return
	 */
	private String randomizeString(String[] strings)
	{
		String string;
		
		string = strings[random.nextInt(strings.length)];
	
		return string;
	}
	
	/**
	 * Method of matching doctors and patients. 
	 * @return
	 */
	public Map<Patient, List<Doctor>> getMatches()
	{
		Map<Patient, List<Doctor>> mapMatches = new HashMap<Patient, List<Doctor>>();
		Iterator<Patient> itrPatient = patients.iterator();
		
		Doctor doctor;
		Patient patient;
		
		while(itrPatient.hasNext())  
		{
			patient = itrPatient.next();
			
			List<Doctor> theseDoctors = new ArrayList<Doctor>();
			Iterator<Doctor>  itrDoctor  = doctors.iterator();
			
			while(itrDoctor.hasNext())
			{
				doctor = itrDoctor.next();
				
				if(patient.getDiagnosis().equals(doctor.getSpecialization()))
				{
					theseDoctors.add(doctor);
				}
			}	
			
			mapMatches.put(patient, theseDoctors);
		}

		return mapMatches;
	}
		
	/**
	 * Method of input values from console patients. 
	 * @param message
	 * @param scaner
	 * @return
	 */
	private String inputString(String message, Scanner scaner) {
		
		Matcher matcher;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		boolean check = false;
		String inputString = "";
		
		while (!check) 
		{
			System.out.printf("%s", message);
			
			inputString = scaner.nextLine();
			matcher = pattern.matcher(inputString);
			
			//If will be entered "exit" then program will be stopped.
			if (inputString.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else if (matcher.matches())
			{
				check = true;
			} 
			else 
			{
				System.out.println("Wrong format. Please, try again.");
			}
		}
		
		return inputString;
	}
	
	/**
	 * Method of output patients. 
	 */
	public void outputPatients()
	{
		Patient patient;
		Iterator<Patient> intItr = patients.iterator();
		
		System.out.println("Patients:");
		while(intItr.hasNext())  {
			patient = intItr.next();
			   System.out.printf("Name - %s, Last Name - %s, Age - %d, Diagnosis - %s \n", patient.getName(),patient.getLastName(),patient.getAge(),patient.getDiagnosis());
			}
	}
	
	/**
	 * Method of output doctors. 
	 */
	public void outputDoctors()
	{
		Doctor doctor;
		Iterator<Doctor> intItr = doctors.iterator();
		
		System.out.println("Doctors:");
		while(intItr.hasNext())  {
			doctor = intItr.next();
			   System.out.printf("Name - %s, Last Name - %s, Cabinet - %d, Specialization - %s \n", doctor.getName(),doctor.getLastName(),doctor.getCabinet(),doctor.getSpecialization());
			}
	}
}
