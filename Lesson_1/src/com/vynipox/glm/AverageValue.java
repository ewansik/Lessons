/**
 * Task 1. This example demonstrates creating an float array with 10 variables and outputting of each element in the console.
 */

package com.vynipox.glm;

import java.util.Random;

public class AverageValue {

	public static void main(String[] args) {
		
		//Declaring Variables
		Float[] mass = new Float[10];
		Random rand  = new Random();
		Float summ   = new Float(0f);

		//Filling the array numbers randomly
		for(int i = 0;i < mass.length;i++)
		{
			mass[i] = rand.nextFloat();
		}
		
		//Outputting of all array elements
		System.out.print("Array:");
		for (Float values : mass) 
		{
			summ += values;
			
			System.out.printf("%f|",values);
		}
		
		//Outputting average value
		System.out.printf("%nAverage value: %f",summ/mass.length);
	}
}
