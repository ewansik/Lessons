/**
 * Main class.
 */

package com.vynipox.glm;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		//Variable declaration
		Scanner scanner = new Scanner(System.in);
		Pattern pattern = Pattern.compile("(.)+.txt$");
		Matcher matcher;
		String fileName = null, fileInput;
		
		boolean check = false;
		
		try {
			//Input text from the default file.
			System.out.print("Text in the first file:");
			InputOutput.read("task1.txt");
			System.out.println("-----------------------------------------------------------------------");
			
			while(!check)
			{
				System.out.print("Please, enter the file name:");
				
				fileName = scanner.nextLine();
				checkInput(fileName);
				matcher = pattern.matcher(fileName);
				
				if(matcher.find())
				{
					System.out.print("Please, enter the text:");
					fileInput = scanner.nextLine();
					checkInput(fileInput);
					
					//Write input text to the created file.
					InputOutput.write(fileName, fileInput);	
				}
				else
				{
					System.out.println("You have entered wrong data, please try again.");
				}
				
				//Read text from the created file.
				System.out.print("Text in created file:");
				InputOutput.read(fileName);
				System.out.println("-----------------------------------------------------------------------");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}
	
	public static void checkInput(String input)
	{
		if(input.toLowerCase().equals("exit"))
		{
			System.exit(-1);
		}
	}
}
