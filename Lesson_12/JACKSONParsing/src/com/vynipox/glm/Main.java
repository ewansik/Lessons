/**
 * Main class.
 */
package com.vynipox.glm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.ModelClass;
import model.People;

public class Main {

	public static void main(String[] args) {
		//Variables declaration.
		List<People> peopleList;
		ObjectMapper mapper = new ObjectMapper();
		People people;

		try {
			ModelClass model = mapper.readValue(new FileReader("test.json"), ModelClass.class);
			
			System.out.printf("Name: %s\n", model.getName());
			System.out.println("------------------------------------");
			peopleList = model.getPeople();
			
			Iterator<People> iter = peopleList.iterator();
			while(iter.hasNext())
			{
				people = iter.next();
				System.out.printf("Id: %d\n Name: %s\n Surname: %s\n Age: %d\n Degree: %b\n", people.getId(), people.getName(), people.getSurname(), people.getAge(),people.isDegree());
				System.out.println("------------------------------------");
			};
	        
	       
		} catch (JsonParseException e) {
			System.out.println(e.getMessage());;
		} catch (JsonMappingException e) {
			System.out.println(e.getMessage());;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());;
		} catch (IOException e) {
			System.out.println(e.getMessage());;
		}
	}
}
