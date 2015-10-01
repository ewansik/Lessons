/**
 * RegExp class.
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		//Declaring variables.
		Scanner scanner = new Scanner(System.in);
		FileFormat fileFormat = new FileFormat();
		String input = "";

		System.out.print("Please, enter file name:");
		input = scanner.nextLine();
		
		System.out.printf("\nFile format: %s", fileFormat.getFormat(input));

		System.out.printf("\nIs correct format: %b\n",fileFormat.checkFormat(fileFormat.getFormat(input)));
		
		scanner.close();	
	}
}
