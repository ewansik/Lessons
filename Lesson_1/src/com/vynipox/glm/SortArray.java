/**
 * Task 4. This example demonstrates the sort array.
 */

package com.vynipox.glm;

import java.util.Random;

public class SortArray {

	public static void main(String[] args) {
		//Declaring Variables
		Random rand    = new Random();
		Integer[] mass = new Integer[10];
		
		int value = 0;
		
		//Filling the array numbers randomly
		System.out.print("Array:");
		for(int i = 0;i < mass.length;i++)
		{
			mass[i] = rand.nextInt(30);
			System.out.printf("%d|",mass[i]);
		}
		
		//Sorting array
		for(int k = 0;k < mass.length;k++)
		{
			for(int j = 0;j < mass.length - 1 - k;j++)
			{
				if(mass[j + 1] < mass[j])
				{
					value = mass[j];
					mass[j] = mass[j + 1];
					mass[j + 1]   = value;
				}
			}	
		}

		//Outputting sorted array
		System.out.print("\nSort array:");
		for (Integer sortArray : mass) {
			System.out.printf("%d|",sortArray);
		}
		
		//Finding even numbers 
		System.out.print("\nEven numbers:");
		for (Integer minMax : mass) {
			if(minMax % 2 == 0)
			{
				System.out.printf("%d|",minMax);
			}
		}
	}
}
