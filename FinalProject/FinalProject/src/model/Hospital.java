/**
 * Класс Hospital, предоставляющий собой модель данных.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	
	//Объявление переменных.
	private String name;
	private String location;
	private List<Doctors> doctors;
	
	/**
	 * Конструктор класса Hospital.
	 */
	public Hospital()
	{
		doctors = new ArrayList<Doctors>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Doctors> getList() {
		return doctors;
	}
	public void setList(Doctors doctor) {
		this.doctors.add(doctor);
	}
}
