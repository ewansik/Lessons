package com.vynipox.glm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manager.Manager;



public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean check = false;
		
		Manager manager = Manager.getInstance();
		
		System.out.println("Welcome to our hospital!");
		
		
		while(!check)
		{
			System.out.println("Please, select the type of parsing: 1) - XML parsing, 2) - Json parsing.");
			choiceOfParsing(manager);
			System.out.println("Do you want to parse file again?");
		}
		scanner.close();
	}
	
	public static void choiceOfParsing(Manager manager)
	{
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher matcher;
		String inputString = "";
		inputString = scanner.nextLine();
		matcher = pattern.matcher(inputString);
		
		if(inputString.toLowerCase().equals("exit"))
		{
			System.exit(-1);
		}
		else if(matcher.matches())
		{
			switch(inputString)
			{
				case "1":
					manager.parseXML();
					break;
					
				case "2":
					System.out.print("Please, select json library: 1) - Gson, 2) - JSON simple.");
					
					inputString = scanner.nextLine();
					
					if(inputString.toLowerCase().equals("exit"))
					{
						System.exit(-1);
					}
					else if(inputString.matches("^[1-2]$"))
					{
						manager.parseJson(inputString);
					}
					else
					{
						System.out.println("wrong");
					}
					break;
					
					default:
						System.out.println("wrong");
						break;
			}
		}
		else
		{
			System.out.println("Wrong argument, please try again!");
		}
	}
}
