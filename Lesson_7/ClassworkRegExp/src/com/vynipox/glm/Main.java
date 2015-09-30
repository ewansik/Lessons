/**
 * Class Main.
 */

package com.vynipox.glm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("^[+]{0,1}(375)((29)|(33)|(44)|(25))[0-9]{3}[0-9]{2}[0-9]{2}$");
		Pattern pattern1 = Pattern.compile("^(8)(0)((29)|(33)|(44)|(25))[0-9]{3}[0-9]{2}[0-9]{2}$");
		
		Scanner scanner = new Scanner(System.in);
		Matcher matcher,matcher1;
		
		String string = "";
		
		System.out.print("Please, enter the mobile phone number:");
		string = scanner.nextLine();
		
		string = string.replaceAll("\\s+","");
		
		
		matcher = pattern.matcher(string);
		matcher1 = pattern1.matcher(string);
		
		if(matcher.matches())
		{
			if(string.charAt(0) != '+')
			{
				string = "+" + string;
			}
			System.out.printf("Your`s number is:%s", string);
		}
		else if(matcher1.matches())
		{
			System.out.printf("Your`s number is:%s", string);
		}	
		else
		{
			System.out.print("Wrong number");
		}
		
		scanner.close();
	}
}
