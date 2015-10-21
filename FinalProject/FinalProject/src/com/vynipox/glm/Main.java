/**
 * Класс Main. Необходим для взаимодействия пользователя с системой.
 * Для завершение программы, необходимо ввести в консоль 'exit'.
 */

package com.vynipox.glm;

import java.util.Scanner;

import manager.Manager;

public class Main {
	
	//объявление глобальных статических переменных.
	private static Scanner scanner = new Scanner(System.in);
	private static Manager manager = Manager.getInstance();
	
	/**
	 * Метод main(). 
	 * @param args
	 */
	public static void main(String[] args) {
	
		System.out.println("Добро пожаловать в нашу больницу!\n");
		System.out.println("Для начала работы, вам необходимо получить информацию с файла.");
		
		choiceOfParsing();
		choiseOperation();
		
		scanner.close();
	}
			
	/**
	 * Статический метод choiseOperation(). Позволяет пользователю выбрать определенное действие, зависящее от параметра.
	 */
	public static void choiseOperation()
	{
		boolean check = false;
		
		System.out.println();
		System.out.println("Теперь вы можете использовать данные для личных целей.");
		
		//Запуск бесконечного цикла, для того, чтобы пользователь мог повторно выбрать действие.
		while(!check)
		{
			printMenu(4);
			
			String inputString = scanner.nextLine();
			checkInput(inputString);
			
			//Проверка на правильность ввода параметра пользователем.
			if(inputString.matches("^[1-5]$"))
			{
				switch(inputString)
				{
					//Вызов метода поиска данных о больнице.
					case "1":
						manager.findCoordinates();
						break;
						
					//Вызов метода просмотра докторов.
					case "2":
						manager.viewDoctors();
						break;
						
					//Вызов метода поиска доктора по специализации.
					case "3":
						printMenu(6);
						inputString = scanner.nextLine();
						checkInput(inputString);
						
						if(inputString.matches("^[a-zA-Z]{3,}$")){
							manager.findDoctor(inputString);
						}
						else{
							printMenu(1);
						}
						break;
					
					//Вызов метода сортировки докторов. Сортировки либо по имени, либо по опыту.
					case "4":
						printMenu(5);
						inputString = scanner.nextLine();
						checkInput(inputString);
						
						if(inputString.matches("^[1-2]$")){
							manager.comparator(inputString);
						}
						else{
							printMenu(1);	
						}
						break;
						
					case "5":
						printMenu(7);
						System.exit(-1);
						break;
						
					default:
						printMenu(1);
						break;
				}
			}
			else
			{
				printMenu(1);
			}
		}
	}
	
	/**
	 * Статический метод chjiseOfParsing() позволяет пользователю выбрать метод парсинга. 
	 */
	public static void choiceOfParsing()
	{
		boolean check = false;
		
		//Запуск бесконечного цикла, для того, чтобы пользователь мог повторно выбрать действие.
		while(!check)
		{
			printMenu(2);

			String inputString = scanner.nextLine();
			checkInput(inputString);
			
			//Проверка на правильность ввода параметра пользователем.
			if(inputString.matches("^[1-3]$")){
				
				//Вызов метода парсинга.
				manager.getParser(inputString);
				
				while(!check)
				{
					printMenu(3);
					inputString = scanner.nextLine();
					checkInput(inputString);
					
					if(inputString.equals("1")){
						break;
					}
					else if(inputString.equals("2")){
						check = true;
					}
					else{
						printMenu(1);
					}
				}
			}
			else
			{
				printMenu(1);
			}
		}
	}
	
	/**
	 * Статический метод printMenu() реализует вывод информации предназначенной для пользователя.
	 * @param menuNumber
	 */
	public static void printMenu(int menuNumber)
	{
		switch(menuNumber)
		{
			case 1:
				System.out.println();
				System.out.println("Вы ввели неверные данные, повторите попытку!");
				break;
				
			case 2:
				System.out.println();
				System.out.println("Пожалуйста, выберите тип парсера для получения информации:\n 1 - XML парсер. \n 2 - Json simple парсер. \n 3 - Json Gson парсер.");
				System.out.print("Введите цифру:");
				break;
				
			case 3:
				System.out.println();
				System.out.println("Вы хотите использовать парсер еще раз?\n 1 - Да. \n 2 - Нет.");
				System.out.print("Введите цифру:");
				break;
				
			case 4:
				System.out.println();
				System.out.println("Пожалуйста, выберите необходимую операцию:\n 1 - Поиск данных о больнице. \n 2 - Просмотр доступных докторов."
						+ " \n 3 - Поиск доктора по специализации. \n 4 - Сортировка докторов. \n 5 - Покинуть больницу.");
				System.out.print("Введите цифру:");
				break;
				
			case 5:
				System.out.println();
				System.out.println("Пожалуйста, выберите тип сортировки:\n 1 - Сортировка по опыту. \n 2 - Сортировка по имени.");
				System.out.print("Введите цифру:");
				break;
					
			case 6:
				System.out.println();
				System.out.print("Пожалуйста, введите искомую специализацию. Вы можете ввести три или более символа:");
				break;
				
			case 7:
				System.out.println();
				System.out.println("Вы покинули нашу больницу. Хорошего вам дня!");
				break;
		}
	}
	
	/**
	 * Статический метод, реализующий завершение программы.
	 * @param input
	 */
	public static void checkInput(String input)
	{
		if(input.toLowerCase().equals("exit"))
		{
			printMenu(7);
			System.exit(-1);
		}
	}
}
