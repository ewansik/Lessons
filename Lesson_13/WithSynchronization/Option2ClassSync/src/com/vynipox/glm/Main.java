/**
 * Main class.
 */
package com.vynipox.glm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Variables declaration.
		Scanner scanner = new Scanner(System.in);
		String input = "";
		boolean check = false;
		
		MyThread myThread = new MyThread();
		MyThread myThread1 = new MyThread();
		
		System.out.println("Enter the start!");

		while(!check)
		{
			input = scanner.nextLine();
			
			if(input.toLowerCase().equals("exit"))
			{
				System.exit(-1);
			}
			else if(input.toLowerCase().equals("start"))
			{
					print(myThread);
					print(myThread1);
		
				try {
					myThread.join();
					myThread1.join();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				System.exit(-1);
			}
			else
			{
				System.out.println("Wrong arguments, try again!");
			}
		}
		
		scanner.close();
	}
	
	/**
	 * Print method.
	 * @param thread
	 */
	public static void print(MyThread thread)
	{
		thread.start();
	}
}
