/**
 * Main class.
 */
package com.vynipox.glm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		//Variable declaration.
		Scanner scanner = new Scanner(System.in);
		Matcher matcher;
		List<String> list = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("a");
		Pattern scannerPattern = Pattern.compile("^[a-zA-Z]+$");
		boolean check = false;
		String input = "";

		while(!check)
		{
			System.out.print("Please, enter the string:");
			input = scanner.nextLine();
			matcher = scannerPattern.matcher(input);
			
			if(input.toLowerCase().equals("stop"))
			{
				break;
			}
			else if(matcher.matches())
			{
				list.add(input);
			}
			else
			{
				System.out.println("You have entered wrong string. Please, enter again.");
			}
		}
		
		System.out.print("You have an array:");
		System.out.println(list);
		
		for (Iterator<String> iter = list.listIterator(); iter.hasNext(); ) {
			
		    String element = iter.next();
		    int index = list.indexOf(element);
		    
		    matcher = pattern.matcher(element);
		    
		    if(matcher.find())
		    {
		    	list.set(index,element.replaceAll(pattern.pattern(), ""));
		    }
		}
		
		System.out.print("Final array:");
		System.out.println(list);
		scanner.close();
	}
}
