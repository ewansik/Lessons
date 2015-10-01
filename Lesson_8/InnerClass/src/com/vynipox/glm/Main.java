/**
 * Main class.
 */
package com.vynipox.glm;

import java.util.List;
import java.util.Scanner;

import com.vynipox.glm.City.Outer;

public class Main {

	public static void main(String[] args) {

		//Variable declaration.
		List<Outer> outer;
		Scanner scanner = new Scanner(System.in);
		City city = new City();
		StringBuilder builder = new StringBuilder();
		  
		System.out.print("Please, enter the city:");
		city.createOuterClass(scanner.nextLine());
		  
		System.out.print("Please, enter the state:");
		city.createOuterClass(scanner.nextLine());
		  
		System.out.print("Please, enter the ZipCode:");
		city.createOuterClass(scanner.nextLine());
		  
		outer = city.getList();
		  
		for (Outer outer2 : outer) {
			builder.append(outer2.getParameters() + " ");
		}
		 
		System.out.printf("You have entered is: %s",builder);
		  
		scanner.close();
	}
}
