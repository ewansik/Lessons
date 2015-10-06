/**
 * InputOutput class.
 */
package com.vynipox.glm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutput {

	/**
	 * Static method used to read the file.
	 * @param path
	 * @throws IOException
	 */
	public static void read(String path) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		String input;
	
		while((input = bufferedReader.readLine()) != null)
		{
			System.out.println(String.valueOf(input));
		}
		
		bufferedReader.close();
	}
	
	/**
	 * Static method used to write the file.
	 * @param path
	 * @param inputText
	 * @throws IOException
	 */
	public static void write(String path, String inputText) throws IOException
	{
		File file = new File(path);
		BufferedWriter bufferedWriter;
		
		if(file.exists())
		{
			bufferedWriter = new BufferedWriter(new FileWriter(path,true));
		}
		else
		{
			bufferedWriter = new BufferedWriter(new FileWriter(path));
		}
		
		bufferedWriter.write(inputText);
		bufferedWriter.close();
	}
}
