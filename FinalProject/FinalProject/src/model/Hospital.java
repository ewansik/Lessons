package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
	
	private String name;
	private String location;
	private List<Doctors> doctors;
	
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
