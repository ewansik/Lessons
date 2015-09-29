package com.vynipox.glm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Pattern pattern = Pattern.compile("^[0-9]+[.]*[0-9]*$");
		Matcher matcherA, matcherB;
		
		String inputA = "";
		String inputB = "";
		
		boolean check = false;
		
		double a = 0;
		double b = 0;
		double rezult = 0;
	    int typeOfAction = 0;
	    
	    while(!check)
	    {
	    	System.out.print("Please, enter the first number:");
	    	inputA = scanner.nextLine();
	    	matcherA = pattern.matcher(inputA);
	    	
			if (inputA.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			
	    	System.out.print("Please, enter the second number:");	
	    	inputB = scanner.nextLine();
	    	matcherB = pattern.matcher(inputB);
	    	
			if (inputB.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			
	    	if(matcherA.matches() && matcherB.matches())
	    	{
	    		try
	    		{
	    			a = Double.valueOf(inputA);
	    			b = Double.valueOf(inputB);
	    			
	    			System.out.print("Please, select the type of action: 1: +, 2: -, 3: *, 4: /");
	    			typeOfAction = Integer.valueOf(scanner.nextLine());
	    			
	    			switch(typeOfAction)
	    			{
	    				case 1:
	    					rezult = a + b;
	    					break;
	    					
	    				case 2:
	    					rezult = a - b;
	    					break;
	    					
	    				case 3:
	    					rezult = a * b;
	    					break;
	    					
	    				case 4:
	    					rezult = a / b;
	    					break;
	    			}
	    		}
	    		catch(Exception e)
	    		{
	    			System.out.println("Wrong datatype");
	    		}    		
	    	}
	    	else
	    	{
	    		System.out.println("Please, enter the number again.");
	    	}

	    	System.out.printf("Rezult:%.3f\n", rezult);
	    	System.out.println("----------------------------------------------------------");
	    	rezult = 0;
	    }
	    
	    scanner.close();
	}
}
