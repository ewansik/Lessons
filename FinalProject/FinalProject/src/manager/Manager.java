package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import factory.ParserFactory;
import model.Doctors;
import model.Hospital;
import thread.MyThread;

public class Manager {

	private Hospital hospital;
	
	private Manager(){}

	public void getParser(String typeOfParsing)
	{
		this.startParsing(ParserFactory.getParser(typeOfParsing));
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
	
	public void viewDoctors()
	{
		List<Doctors> list = hospital.getList();
		System.out.println("Today, you can refer to:");
		
		for (Doctors doctors : list) {
			System.out.println(doctors.toString());
		}
	}
	
	public void findCoordinates()
	{
		System.out.printf("Our hospital is located in %s. Name of hospital: %s.\n", hospital.getLocation(), hospital.getName());
	}
	
	public void findDoctor(String Specialization)
	{
		List<Doctors> list = hospital.getList();
		List<String> specializations = new ArrayList<String>();
		
		for (Doctors doctors : list) {
			
			specializations = doctors.getTypeList();
			for (String string : specializations) {
				if(string.toLowerCase().matches("^.*"+ Specialization.toLowerCase() +".*"))
				{
					System.out.println(doctors.toString());
				}
			}
		}
	}
	
	public void comparator(String type)
	{
		List<Doctors> doctors = hospital.getList();
		if(type.equals("1")){
			Collections.sort(doctors,new CompareExperience());
		}
		else if(type.equals("2")){
			Collections.sort(doctors,new CompareName());
		}
		
		for (Doctors doctor : doctors) {
			System.out.println(doctor.toString());
		}
	}
	
	static class CompareName implements Comparator<Doctors>
	{
		@Override
		public int compare(Doctors o1, Doctors o2) {
			String fullName1 = o1.getName();
			String fullName2 = o2.getName();
			String name1 = fullName1.substring(0, fullName1.indexOf(" "));
			String name2 = fullName2.substring(0, fullName2.indexOf(" "));
			
			if(name1.compareTo(name2) == 0)
			{
				String lastName1 = fullName1.substring(fullName1.indexOf(" "), fullName1.length());
				String lastName2 = fullName2.substring(fullName2.indexOf(" "), fullName2.length());
				
				return lastName1.compareTo(lastName2);
			}
			
			return name1.compareTo(name2);
		}
	}
	
	static class CompareExperience implements Comparator<Doctors>
	{
		@Override
		public int compare(Doctors o1, Doctors o2) {
			int experience1 = o1.getYearEperience();
			int experience2 = o2.getYearEperience();
			
			if(experience1 > experience2){
				return 1;
			}
			else if(experience1 == experience2){
				return 0;
			}
			else{
				return -1;
			}
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
