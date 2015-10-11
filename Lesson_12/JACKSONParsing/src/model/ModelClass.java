/**
 * Model class.s
 */
package model;

import java.util.ArrayList;
import java.util.List;


public class ModelClass{
	//Variables declaration.
	private String name;
	private List<People> people = new ArrayList<People>();
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<People> getPeople() {
		return people;
	}
	public void setPeople(List<People> list) {
		this.people = list;
	}
	
	@Override
	public String toString() {
		return "ModelClass [name=" + name + ", list=" + people + "]";
	}
}
