/**
 * Task 3. This example demonstrates finding the minimum and maximum number of the array.
 */

package com.vynipox.glm;

import java.util.Random;

public class MinMaxValue {

	public static void main(String[] args) {
		
		//Declaring Variables
		Random rand    = new Random();
		Integer[] mass = new Integer[10];
		
		int min,max = 0;
		
		//Filling the array numbers randomly
		for(int i = 0;i < mass.length;i++)
		{
			mass[i] = rand.nextInt(30);
		}
		
		min = mass[0];
		max = mass[0];
		
		//Finding the minimum and maximum number of the array
		for (Integer values : mass) 
		{
			if(values < min)
			{
				min = values;	
			}
			
			if(values > max)
			{
				max = values; 
			}
		}
		
		//Outputting average value
		System.out.printf("Min value: %d%n",min);
		System.out.printf("Max value: %d",max);
	}
}
