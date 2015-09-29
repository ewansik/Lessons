/**
 * Main class.
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Declaring variables.
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator(scanner);

		boolean check = false;
		
		double a = 0;
		double b = 0;
		
		while(!check)
		{
			
			try {
				System.out.print("Please, enter the first number:");
				a = calculator.inputNumber();
				
				System.out.print("Please, enter the second number:");
				b = calculator.inputNumber();
				
				System.out.print("Please, select the type of action: 1: +, 2: -, 3: *, 4: /");
				System.out.printf("Rezult:%.3f\n",calculator.calculate(a,b));
				
			} catch (Excep e) {
				
				System.err.println(e);
			}
			
			System.out.println("-----------------------------------------");
		}
		
		scanner.close();
	}
}
