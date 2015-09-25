/**
 * Class hospital.
 */

package Manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Doctor;
import model.Patient;
import model.Personal;

public class Hospital {

	private Random random;
	
	//Declaring lists for doctors, personals and patients.
	private List<Patient> patients;
	private List<Doctor> doctors;
	private List<Personal> personals;
		
	//Declaring arrays for random values.
	private final String[] diagnosisFor = {"Lohr","Surgeon","Beautician","Cardiologist","Therapist"};
	private final String[] names 	    = {"Stive","Erik","Bret","Benjamin","Greg","Patrik","Elie"};
	private final String[] lastNames 	= {"Jobs","Hanson","Kornet","Brezenk","Litle","Layout","Bah"};
	private final String[] positions    = {"Nurse", "Head nurse"};
	
	/**
	 * Class constructor.
	 */
	public Hospital()
	{
		patients    = new ArrayList<Patient>();
		doctors     = new ArrayList<Doctor>();
		personals   = new ArrayList<Personal>();
		
		random = new Random();
	}
	
	/**
	 * Method of creating personals.
	 * @param name
	 * @param lastName
	 * @param position
	 */
	public void createPersonal(String name, String lastName, String position)
	{
		Personal personal = new Personal(name, lastName, position);
		
		personals.add(personal);
	}
	
	/**
	 * Method of creating random patients.
	 */
	public void createRandomPersonal()
	{
		this.createPersonal(this.randomizeString(names), this.randomizeString(lastNames), this.randomizeString(positions));	
	}
	
	/**
	 * Method of outputting patients.
	 */
	public void outputPersonal()
	{
		Personal personal;
		Iterator<Personal> intItr = personals.iterator();
		
		System.out.print(" personals:");
		while(intItr.hasNext())  {
			personal = intItr.next();
			   System.out.printf("Name - %s, Last Name - %s, Position - %s\n", personal.getName(),personal.getLastName(),personal.getPosition());
			}
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
	 * Method of creating doctors. 
	 * @param name
	 * @param lastName
	 * @param cabinet
	 * @param specialization
	 */
	public void createDoctor(String name, String lastName, int cabinet, String specialization, Calendar calendar)
	{
		Doctor doctor = new Doctor(name, lastName, cabinet, specialization, calendar);
		
		doctors.add(doctor);
	}
	
	/**
	 * Method of creating random doctors. 
	 */
	public void createRandomDoctor()
	{
		this.createDoctor(this.randomizeString(names),this.randomizeString(lastNames),random.nextInt(100),this.randomizeString(diagnosisFor), this.createRandomDate());
	}
	
	/**
	 * Method of creating random date.
	 * @return
	 */
	public Calendar createRandomDate()
	{
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();
		
		int startYear = 1950; 
		int endYear   = 2015;
		
	    calendar.set(startYear + (int)Math.round(Math.random() * (endYear - startYear)),random.nextInt(11),random.nextInt(31) + 1,random.nextInt(24), random.nextInt(60));
		return calendar;
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
			System.out.printf("Name - %s, Last Name - %s, Cabinet - %d, Specialization - %s", doctor.getName(),doctor.getLastName(),doctor.getCabinet(),doctor.getSpecialization());
			this.outputDoctorDates(doctor);
			}
	}
	
	
	public void outputAverageDate()
	{
		int count = 0;
		Iterator<Doctor> intItr = doctors.iterator();
		
		Calendar doctorsBirthday = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		Calendar average = Calendar.getInstance();
		Calendar currentDate;
	
		while(intItr.hasNext())  
		{
			currentDate = intItr.next().getCalendar();
			
			if(count == 0)
			{
				doctorsBirthday.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
				doctorsBirthday.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
				doctorsBirthday.set(Calendar.DAY_OF_MONTH, currentDate.get(Calendar.DAY_OF_MONTH));
				doctorsBirthday.set(Calendar.HOUR_OF_DAY, currentDate.get(Calendar.HOUR_OF_DAY));
				doctorsBirthday.set(Calendar.MINUTE, currentDate.get(Calendar.MINUTE));
			}
			else
			{
				doctorsBirthday.add(Calendar.YEAR, currentDate.get(Calendar.YEAR));
				doctorsBirthday.add(Calendar.MONTH, currentDate.get(Calendar.MONTH));
				doctorsBirthday.add(Calendar.DAY_OF_MONTH, currentDate.get(Calendar.DAY_OF_MONTH));
				doctorsBirthday.add(Calendar.HOUR_OF_DAY, currentDate.get(Calendar.HOUR_OF_DAY));
				doctorsBirthday.add(Calendar.MINUTE, currentDate.get(Calendar.MINUTE));
			}
			count++;
		}
		
		average.set(Calendar.YEAR, doctorsBirthday.get(Calendar.YEAR)/count);
		average.set(Calendar.MONTH, doctorsBirthday.get(Calendar.MONTH)/count);
		average.set(Calendar.DAY_OF_MONTH, doctorsBirthday.get(Calendar.DAY_OF_MONTH)/count);
		average.set(Calendar.HOUR_OF_DAY, doctorsBirthday.get(Calendar.HOUR_OF_DAY)/count);
		average.set(Calendar.MINUTE, doctorsBirthday.get(Calendar.MINUTE)/count);
		
		today.add(Calendar.YEAR, -doctorsBirthday.get(Calendar.YEAR)/count);
		today.add(Calendar.MONTH, -doctorsBirthday.get(Calendar.MONTH)/count);
		today.add(Calendar.DAY_OF_MONTH, -doctorsBirthday.get(Calendar.DAY_OF_MONTH)/count);
		today.add(Calendar.HOUR_OF_DAY, -doctorsBirthday.get(Calendar.HOUR_OF_DAY)/count);
		today.add(Calendar.MINUTE, -doctorsBirthday.get(Calendar.MINUTE)/count);
			
		System.out.printf("Average date: %d.%d.%d %d:%d\n",average.get(Calendar.YEAR), average.get(Calendar.MONTH), average.get(Calendar.DAY_OF_MONTH), average.get(Calendar.HOUR), average.get(Calendar.MINUTE));
		System.out.printf("Average age: %d.%d.%d %d:%d\n",today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.HOUR), today.get(Calendar.MINUTE));
	}
	
	
	/**
	 * Method of output doctor date.
	 */
	public void outputDoctorDates(Doctor doctor)
	{
		Calendar calendar = Calendar.getInstance();
		String aMpM = "";
		calendar = doctor.getCalendar();
		if(calendar.get(Calendar.AM_PM) == 0)
		{
			aMpM = "AM";
		}
		else
		{
			aMpM = "PM";
		}
		System.out.printf(", Date: %d.%d.%d %d:%d%s\n",calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), aMpM);
	}
}
