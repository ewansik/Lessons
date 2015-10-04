package com.vynipox.glm;

import java.util.Scanner;
/**
 * Main class.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Manager.Manager;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		
		//Variable declaration
		Scanner scanner = new Scanner(System.in);
		Matcher matcher;
		Pattern pattern = Pattern.compile("^(man)|(woman)$");
		
		String input = "";
		boolean check = false;
		
		//Cycle of creating random clients.
		for(int i = 0;i < 3;i++)
		{
			manager.createRandomManClient();
			manager.createRandomWomanClient();
		}
		
		while(!check)
		{
			System.out.print("Please, select the man or woman:");
			input = scanner.nextLine().toLowerCase();
			
			matcher = pattern.matcher(input);
			
			if(input.toLowerCase().equals("exit"))
			{
				System.exit(-1);
			}
			else if(matcher.matches())
			{
				manager.getClients(input);
			}
			else
			{
				System.out.println("You have entered wrong argumentm please enter again.");
			}
		}
		
		scanner.close();
	}
}
