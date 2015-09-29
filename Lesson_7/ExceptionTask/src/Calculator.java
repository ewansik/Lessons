/**
 * Calculator class.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	//Declaring variables.
	private Scanner scanner;	
	private Pattern pattern = Pattern.compile("^[0-9]+[.]*[0-9]*$");

	/**
	 * Class constructor.
	 * @param scanner
	 */
	public Calculator(Scanner scanner)
	{
		this.setScanner(scanner);
	}
	
	/**
	 * Method to enter numbers.
	 * @return
	 * @throws Excep
	 */
	public double inputNumber () throws Excep
	{
		double a = 0;
		String input = "";
		Matcher matcherNumber;
		
		input = scanner.nextLine();
		matcherNumber = pattern.matcher(input);
		
		if(input.toLowerCase().equals("exit"))
		{
			System.exit(-1);
		}
		else if(input.equals("0"))
		{
			throw new Excep("You have entered is 0");
		}
		else if(matcherNumber.matches())
		{
			a = Double.valueOf(input);
		}
		else
		{
			throw new Excep("Wrong argument");
		}

		return a;
	}
	
	/**
	 * Method to calculate numbers.
	 * @param a
	 * @param b
	 * @return
	 * @throws Excep
	 */
	public double calculate(double a, double b) throws Excep
	{
		double rezult = 0;
	    int typeOfAction = 0;
	    String input = "";
	    Matcher matcher;
	    
	    input = scanner.nextLine();
	    
	    matcher = pattern.matcher(input);
	    if(!matcher.matches())
	    {
	    	throw new Excep("You have entered incorrect symbol, please use the numbers.");
	    }
	    else
	    {
	    	typeOfAction = Integer.valueOf(input);
	    }
	    
	    switch(typeOfAction)
		{
			case 1:
				rezult = a + b;
				break;
				
			case 2:
				rezult = a - b;
				break;
				
			case 3:
				rezult = a * b;
				break;
				
			case 4:
				rezult = a / b;
				break;
		}
	    
	    if(rezult < 1)
	    {
	    	throw new Excep("Rezult is less then 1.");
	    }
	    
	    return rezult;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
}
