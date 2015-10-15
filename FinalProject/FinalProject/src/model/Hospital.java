package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	
	private String name;
	private String location;
	private List<Doctor> doctors;
	
	public Hospital()
	{
		doctors = new ArrayList<Doctor>();
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
	public List<Doctor> getList() {
		return doctors;
	}
	public void setList(Doctor doctor) {
		this.doctors.add(doctor);
	}
}
