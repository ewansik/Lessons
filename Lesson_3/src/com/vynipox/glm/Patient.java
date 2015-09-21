/**
 * Patient class. 
 */

package com.vynipox.glm;

public class Patient {

	//Declaring variables for patient name, last name ,age and diagnosis.	
	private String name;
	private String lastName;
	private int age;
	private String diagnosis;
	
	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 * @param age
	 * @param diagnosis
	 */
	public Patient(String name, String lastName, int age, String diagnosis)
	{
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setDiagnosis(diagnosis);
	}
	
	/*
	 * Getters and setters for patient variables.
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name.toLowerCase();
		name = Character.toString(name.charAt(0)).toUpperCase()+name.substring(1);
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		lastName.toLowerCase();
		lastName = Character.toString(lastName.charAt(0)).toUpperCase()+lastName.substring(1);
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
}
