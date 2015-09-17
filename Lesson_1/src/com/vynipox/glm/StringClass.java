/**
 * Task 2. This example demonstrates creating an string and splitting it into the two substring.
 */

package com.vynipox.glm;

public class StringClass {

	public static void main(String[] args) {
		
		//Declaring Variables
		String mainString   = new String("What is the best practice to declare a java file having only constant?");
		String firstString  = new String();
		String secondString = new String();

		firstString  = mainString.substring(0, mainString.length() / 2);
		secondString = mainString.substring(mainString.length() / 2, mainString.length());

		//Outputting strings in the console.
		System.out.printf("Quantity of symbols: %d%n", mainString.length());
		System.out.printf("First string:%s%n", firstString);
		System.out.printf("Second string:%s",secondString);
	}
}
