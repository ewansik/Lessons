/**
 * Class Main.
 */

package com.vynipox.glm;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Circle;
import Model.Shape;
import Model.Square;
import Model.Triangle;
import Model.MyRectangle;

public class Main {

	public static void main(String[] args) {
		
		//Declaring variables.
		Pattern pattern = Pattern.compile("^[1-4]$");
		Scanner scanner = new Scanner(System.in);
		Random random   = new Random();
		
		Matcher matcher;
		Shape shape = null;
		
		String number = "";
		boolean check = false;
		String name = "";
		
		System.out.println("Enter the number: 1 - Square, 2 - Circle, 3 - Triangle, 4 - Rectangle");
		System.out.print("Number is:");
		
		//Cycle until the user selects the desired shape.
		while(!check)
		{
			number = scanner.nextLine();
			matcher = pattern.matcher(number);
			
			//If user enters "exit" then programm will terminated.
			if (number.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else if (matcher.matches())
			{
				check = true;
				
				switch((Integer.valueOf(number)))
				{
					case 1:
						shape = new Square((double)random.nextInt(30));
						name = "Square";
						break;
					
					case 2:
						shape = new Circle((double)random.nextInt(30));
						name = "Circle";
						break;
						
					case 3:
						shape = new Triangle((double)random.nextInt(30), (double)random.nextInt(30));
						name = "Triangle";
						break;
					
					case 4:
						shape = new MyRectangle((double)random.nextInt(30), (double)random.nextInt(30));
						name = "Rectangle";
						break;
				}
				
			} 
			else 
			{
				System.out.println("Wrong format. Please, try again.");
			}
		}
		
		//Call calculate area method.
		shape.calculateArea();
		
		System.out.printf("%s area is:%f",name,shape.getS());
		
		scanner.close();
	}
}
