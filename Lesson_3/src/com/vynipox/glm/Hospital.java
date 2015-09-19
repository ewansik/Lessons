/**
 * The program simulates the operation of the registry in hospital.
 */

package com.vynipox.glm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hospital {

	//Declaring static variables to check the name and last name input.
	private static boolean checkName = false;
	private static boolean checkLastName = false;
	
	private static Scanner scan = new Scanner(System.in);
	private static Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
	private static Matcher matcher;
	
	//Declaring static variables for patient name and last name.
	private static String inputName = "";
	private static String inputLastName = "";

	private static int count = 1;
	
	public static void main(String[] args) {

		System.out.println("Welcome to our hospital!\n");
		System.out.println("Today work:");
		System.out.println("--------------------------------------------------------------------");
		
		//Call the class constructor.
		new Doctor();
		new Doctor();
		new Doctor();
		new Doctor();
		new Doctor();

		//Create the new object Patient class.
		Patient pat  = new Patient();
		Patient pat2 = new Patient();
		Patient pat3 = new Patient();
		Patient pat4 = new Patient();
		Patient pat5 = new Patient();

		System.out.println("--------------------------------------------------------------------");		
		System.out.println("Please fill in the name  and last name of the patients.\n");

		//Specifies the name and last name and another parameters. 
		setParameters(pat);
		pat.setParameters();
		setParameters(pat2);
		pat2.setParameters();
		setParameters(pat3);
		pat3.setParameters();
		setParameters(pat4);
		pat4.setParameters();
		setParameters(pat5);
		pat5.setParameters();

		//Output data of the patient.
		Patient.outputPatient();
		
		//Compare and output patient and doctor.
		Registry.matchPatienDoctor();
		
		scan.close();
	}

	/**
	 * Initialization method name and last name.
	 * @param pat
	 */
	private static void setParameters(Patient pat) {
		
		//Until the name is entered correctly.
		while (!checkName) 
		{
			System.out.printf("Enter the name of the %d patient:", count);
			
			inputName = scan.nextLine();
			matcher = pattern.matcher(inputName);
			
			//If will be entered "exit" then program will be stopped.
			if (inputName.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else if (matcher.matches())
			{
				//Specifies the name of the patient.
				pat.setName(inputName);
				checkName = true;
			} 
			else 
			{
				System.out.println("Wrong format. Please, try again.");
			}
		}
		
		//Until the last name is entered correctly.
		while (!checkLastName)
		{
			System.out.printf("Enter the last name of the %d patient:", count);
			
			inputLastName = scan.nextLine();
			matcher = pattern.matcher(inputLastName);
			
			//If will be entered "exit" then program will be stopped.
			if (inputLastName.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else if (matcher.matches()) 
			{
				////Specifies the last name of the patient.
				pat.setLastName(inputLastName);
				checkLastName = true;
			} 
			else 
			{
				System.out.println("Wrong format. Please, try again.");
			}
		}

		count++;
		
		checkName = false;
		checkLastName = false;
	}
}
