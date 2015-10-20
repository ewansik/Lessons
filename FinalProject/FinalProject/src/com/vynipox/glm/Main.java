/**
 * Main class. 
 */

package com.vynipox.glm;

import java.util.Scanner;

import manager.Manager;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Manager manager = Manager.getInstance();
	
	public static void main(String[] args) {
	
		System.out.println("Welcome to our hospital!");
		
		choiceOfParsing();
		choiseOperation();
		
		scanner.close();
	}
			
	public static void choiseOperation()
	{
		boolean check = false;
		
		while(!check)
		{
			printMenu(4);
			
			String inputString = scanner.nextLine();
			checkInput(inputString);
			
			if(inputString.matches("^[1-5]$"))
			{
				switch(inputString)
				{
					case "1":
						manager.findCoordinates();
						break;
						
					case "2":
						manager.viewDoctors();
						break;
						
					case "3":
						printMenu(6);
						inputString = scanner.nextLine();
						checkInput(inputString);
						
						if(inputString.matches("^[a-zA-Z]{3,}$")){
							manager.findDoctor(inputString);
						}
						else{
							printMenu(1);
						}
						break;
						
					case "4":
						printMenu(5);
						inputString = scanner.nextLine();
						checkInput(inputString);
						
						if(inputString.matches("^[1-2]$")){
							manager.comparator(inputString);
						}
						else{
							printMenu(1);	
						}
						break;
						
					default:
						printMenu(1);
						break;
				}
			}
			else
			{
				printMenu(1);
			}
		}
	}
	
	public static void choiceOfParsing()
	{
		boolean check = false;
		
		while(!check)
		{
			printMenu(2);

			String inputString = scanner.nextLine();
			checkInput(inputString);
			
			if(inputString.matches("^[1-3]$")){
				
				manager.getParser(inputString);
				
				while(!check)
				{
					printMenu(3);
					inputString = scanner.nextLine();
					checkInput(inputString);
					
					if(inputString.equals("1")){
						break;
					}
					else if(inputString.equals("2")){
						check = true;
					}
					else{
						printMenu(1);
					}
				}
			}
			else
			{
				printMenu(1);
			}
		}
	}
	
	public static void printMenu(int menuNumber)
	{
		switch(menuNumber)
		{
			case 1:
				System.out.println("Wrong data, please try again!");
				break;
				
			case 2:
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Please, select the type of parsing:\n 1 - XML parsing. \n 2 - Json simple parsing. \n 3 - Json Gson parsing.");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				break;
				
			case 3:
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Do you want to parse the file again?\n 1 - Yes. \n 2 - No.");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				break;
				
			case 4:
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Please, select the type of operation:\n 1 - Find the coordinates. \n 2 - View doctors."
						+ " \n 3 - Find doctors. \n 4 - Sort doctors.");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				break;
				
			case 5:
				System.out.print("Please, select the type of sorting:\n 1 - Sorting by expirience. \n 2 - Sorting by name.");
				break;
					
			case 6:
				System.out.print("Please, enter the doctor specialization. You can enter 3 or more symbols:");
				break;
		}
	}
	
	/**
	 * Check if user enter 'exit'.
	 * @param input
	 */
	public static void checkInput(String input)
	{
		if(input.toLowerCase().equals("exit"))
		{
			System.out.println("You have completed work the program. Have a nice day!");
			System.exit(-1);
		}
	}
}
