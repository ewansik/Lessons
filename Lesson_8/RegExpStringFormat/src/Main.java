/**
 * RegExp class.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args){

		//Declaring variables.
		Pattern pattern = Pattern.compile("(.)\\1{1,}");
		Scanner scanner = new Scanner(System.in);

		Matcher matcher;
		String input = "";
		StringBuffer newString = new StringBuffer();
		
		System.out.print("Please, enter the string:");
		input = scanner.nextLine();
		
		matcher = pattern.matcher(input.toLowerCase());
			
		while(matcher.find())
		{
			matcher.appendReplacement(newString,input.substring(matcher.start(), matcher.start() + 1) + (matcher.end() - matcher.start()));
		}
		
		matcher.appendTail(newString);
		
		System.out.printf("Original string: %s\n",input);
		System.out.printf("New string: %s",newString);
		
		scanner.close();	
	}
}
