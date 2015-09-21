/**
 * Doctor class.
 */

package com.vynipox.glm;

public class Doctor {
	//Declaring variables for doctor name, last name and specialization.	
	private String name;
	private String lastName;
	private String specialization;
	
	//Declaring variables for doctor cabinet.
	private int cabinet;
	
	/**
	 * Class constructor.
	 * @param name
	 * @param lastName
	 * @param cabinet
	 * @param specialization
	 */
	public Doctor(String name, String lastName, int cabinet, String specialization)
	{
		this.setName(name);
		this.setLastName(lastName);
		this.setCabinet(cabinet);
		this.setSpecialization(specialization);	
	}
	
	/*
	 * Getters and setters for doctor variables.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getCabinet() {
		return cabinet;
	}

	public void setCabinet(int cabinet) {
		this.cabinet = cabinet;
	}
}
