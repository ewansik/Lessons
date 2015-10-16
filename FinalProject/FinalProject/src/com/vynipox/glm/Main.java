package com.vynipox.glm;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constants.MyConstants;
import helpers.HelperJson;
import helpers.HelperXml;
import manager.Manager;

public class Main {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^(go)$");
		Matcher matcher;
		Scanner scanner = new Scanner(System.in);
		String inputString = "";
		
		inputString = scanner.nextLine();
		matcher = pattern.matcher(inputString);
		
		if(matcher.matches())
		{
			Manager managerTest = new Manager();
	
			HelperJson manager = new HelperJson(MyConstants.JSON_URL);
			managerTest.test(manager);
			
			HelperXml helperXml = new HelperXml(MyConstants.XML_URL);
			managerTest.test(helperXml);
		}
		else
		{
			System.out.println("dsa");
		}
		
		scanner.close();
	}
}
