/**
 * This example demonstrates the sort array.
 */

package com.vynipox.glm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortArray {

	//Declaring static variables
	public static Pattern paternFill   = Pattern.compile("^[0-9]+$");
	public static Pattern paternBubble = Pattern.compile("^[1-3]$");
	public static Matcher staticMatcher;
	
	public static void main(String[] args) {

		//Declaring variables
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String inputText = "";

		int[] mass = new int[10];

		System.out.println("If you want close the program, please enter the 'exit'!");
		System.out.println("Please, fill the array!");

		//Loop fill the array with the console
		for (int i = 0; i < mass.length; i++) 
		{
			System.out.printf("Array[%d]: ", i);

			inputText 	  = scan.nextLine();
			staticMatcher = paternFill.matcher(inputText);

			/*The user can fill the array any number. If he enters other symbol then array will be filled automatically.
			*If he enters "exit" then program will be stopped.
			*/
			if (staticMatcher.matches()) 
			{
				mass[i] = Integer.parseInt(inputText);
			} 
			else if (inputText.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else 
			{
				mass[i] = rand.nextInt(30);
				
				System.out.printf("Array will be filled automatically: %d\n", mass[i]);
			}
		}

		//Method call 
		outputFunction(sortArray(scan, mass));
		
		scan.close();
	}

	/**
	 * Method sort array. 1 - Selection sort, 2 - Bubble sort, 3- Arrays sort.
	 * @param scan
	 * @param mass
	 * @return
	 */
	public static int[] sortArray(Scanner scan, int[] mass) 
	{
		//Declaring variables
		String inputText = "";

		boolean check = false;
		int value = 0;
		
		System.out.println("------------------------------");
		System.out.print("Array:");

		//Outputting array
		for (int i : mass) 
		{
			System.out.printf("%d|", i);
		}
		
		System.out.println("\n------------------------------");
		System.out.print("Choice type of sortting array: 1 - Selection sort, 2 - Bubble sort, 3- Arrays sort\n");
		
		/*After selected type of sorting, array will be sorted.
		 * If user enters "exit" then program will be stopped.
		 */
		do
		{
			inputText = scan.nextLine();
			staticMatcher = paternBubble.matcher(inputText);
			
			if (staticMatcher.matches()) 
			{
				check = true;
				switch(Integer.parseInt(inputText))
				{
					case 1:
						for(int i = 0;i < mass.length;i++)
						{
							for(int j = 0;j < mass.length - 1 - i;j++)
							{
								if(mass[j + 1] < mass[j])
								{
									value = mass[j];
									mass[j] = mass[j + 1];
									mass[j + 1]   = value;
								}
							}	
						}
						break;
						
					case 2:
						for(int i = mass.length-1 ; i > 0 ; i--){
					        for(int j = 0 ; j < i ; j++){
					           
					            if( mass[j] > mass[j+1] )
					            {
					                value     = mass[j];
					                mass[j]   = mass[j+1];
					                mass[j+1] = value;
					            }
					        }
					    }
						break;
						
					case 3:
						Arrays.sort(mass);
						break;
						
					default:
						break;
				}
			} 
			else if (inputText.toLowerCase().equals("exit")) 
			{
				System.exit(-1);
			} 
			else 
			{
				System.out.println("You should do right choice sorting array.");
			}
		}
		while(!check);

		return mass;
	}

	/**
	 * Array output method and finding even numbers.
	 * @param mass
	 */
	public static void outputFunction(int[] mass)
	{
		System.out.printf("Sorted array:");
		
		//Outputting sorted array
		for (int i : mass) {
			
			System.out.printf("%d|", i);
		}
		
		System.out.print("\nEven numbers:");
		
		//Finding even numbers
		for (Integer minMax : mass) {
			if(minMax % 2 == 0)
			{
				System.out.printf("%d|",minMax);
			}
		}
	}
}
