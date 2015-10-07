/**
 * Main class.
 */
package com.vynipox.glm;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	//Variables declaration.
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean check = false;
		
		String filesDir = null;
		
		filesDir = createDir();
		System.out.printf("You are in the '%s' folder.\n", filesDir);
		System.out.println("-----------------------------------------------------------");
		
		while(!check)
		{
			System.out.print("Please, select the type of operation. 1 - show files in folder, 2 - create file, 3 - view file, 4 - add new date, 5 - append date, 6 - delete file:");
			typeOfOperation(filesDir);
			System.out.println("-----------------------------------------------------------");
		}
		
		scanner.close();
	}
	
	/**
	 * Check if user enter 'exit'.
	 * @param input
	 */
	public static void checkInput(String input)
	{
		if(input.toLowerCase().equals("exit"))
		{
			System.exit(-1);
		}
	}
	
	/**
	 * Method for creating a folder.
	 */
	public static String createDir()
	{
		String directory = null;
		boolean checkDirectory = false;
		Pattern patternDirectory = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcherDirectory;
		
		while(!checkDirectory)
		{
			System.out.print("Please, enter the folder name:");
			directory = scanner.nextLine();
			checkInput(directory);
			matcherDirectory = patternDirectory.matcher(directory);
			
			if(matcherDirectory.matches())
			{
				try {
					InputOutput.createDir(directory);
					checkDirectory = true;
					
				} catch (IOException e) {
					e.getMessage();
				}
			}
			else
			{
				System.out.println("Wrong directory name, please try again.");
			}
		}
		
		return directory;
	}
	
	/**
	 * Method for selecting the operation type.
	 * @param filesDir
	 */
	public static void typeOfOperation(String filesDir)
	{
		Pattern pattern = Pattern.compile("(.)+.txt$");
		String type = null;
		String fileName = null;
		String inputText = null;
		Matcher matcher;		
		
		type = scanner.nextLine();
		checkInput(type);
		
		switch(type)
		{
			//Show file in folder.
			case "1":
				File[] files = new File(filesDir).listFiles();

				try
				{
					for (File file : files) {
					    if (file.isFile()) {
					        System.out.println(file.getName());
					    }
					}
				}
				catch(NullPointerException e)
				{
					e.getMessage();
				}
				
				break;
				
			//Create new file.
			case "2":
				System.out.print("Please, enter the file name:");
				
				fileName = scanner.nextLine();
				checkInput(type);
				matcher = pattern.matcher(fileName);
				
				if(matcher.find())
				{
					try {
						InputOutput.createFile(filesDir + "/" + fileName);
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
				else
				{
					System.out.println("Wrong file name.");
				}
				break;
				
			//View file.	
			case "3":
				System.out.print("Please, enter the file name:");
				
				fileName = scanner.nextLine();
				checkInput(type);
				
				try {
					System.out.print("Date in your file:");
					InputOutput.read(filesDir + "/" + fileName);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}	

				break;
			
			//Add date to the file.
			case "4":
				System.out.print("Please, enter the file name:");
				
				fileName = scanner.nextLine();
				checkInput(type);
				
				System.out.print("Please, enter the input text:");
				inputText = scanner.nextLine();
				checkInput(type);

				try {
					InputOutput.appendFile(filesDir + "/" + fileName, inputText, false);
					System.out.printf("You have added new date to the '%s' file.\n", fileName);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

				break;
				
			//Append date to the file.
			case "5":
				System.out.print("Please, enter the file name:");
				
				fileName = scanner.nextLine();
				checkInput(type);
				
				System.out.print("Please, enter the input text:");
				inputText = scanner.nextLine();
				checkInput(type);

				try {
					InputOutput.appendFile(filesDir + "/" + fileName, inputText, true);
					System.out.printf("You have appended date to the '%s' file.\n", fileName);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			//Delete the existing file.
			case "6":
				System.out.print("Please, enter the file name:");
				fileName = scanner.nextLine();
				checkInput(type);
				
				try {
					InputOutput.deleteFile(filesDir + "/" + fileName);
					System.out.printf("You have deleted '%s' file.\n", fileName);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				break;
		}
	}
}
