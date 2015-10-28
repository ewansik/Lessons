package com.vynipox.glm;

import java.util.Scanner;

public class Main {

	

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		boolean check = false;
		boolean checkInput = false;
		int count;
		String inputString ="";
		int[] a = null;
		
		while(!check)
		{
			System.out.print("Введите размер массива от 1 до 99, число должно быть нечетным:");
			inputString = scanner.nextLine();
			if(Integer.valueOf(inputString) < 100 &&  Integer.valueOf(inputString) > 0 && Integer.valueOf(inputString)%2 != 0)
			{
				count = Integer.valueOf(inputString);
				a = new int[count];
				check = true;
			}	
			else
			{
				System.out.println("Укажите размер значения в цифрах, от 1 до 99");
			}
		}
		
		for(int i = 0; i<a.length;i++)
		{
			checkInput = false;
			System.out.printf("Введите %d - ый элемент массива:",i);	
			while(!checkInput)
			{
				inputString = scanner.nextLine();
				if(Integer.valueOf(inputString) < 100 &&  Integer.valueOf(inputString) > 0)
				{
					a[i] = Integer.valueOf(inputString);
					checkInput = true;
				}
				else
				{
					System.out.println("Вы ввели неверные данные, повторите попытку.");
				}
			}
		}
		
		
		int result = 0;
		
		for(int i = 0; i< a.length;i++)
		{
			result ^=a[i];
		}
		
		scanner.close();
		System.out.printf("Результат: %d",result);
	}
}
