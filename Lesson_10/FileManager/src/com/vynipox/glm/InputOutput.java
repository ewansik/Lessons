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
	 * Method of creating new file.
	 * @param path
	 * @throws IOException
	 */
	public static void createFile(String path) throws IOException
	{
		File file = new File(path);
		
		if(file.exists())
		{
			System.out.printf("The file '%s' exists in folder.\n",path);
		}
		else
		{
			System.out.printf("The file '%s' was created.\n",path);
			file.createNewFile();
		}
	}
	
	/**
	 * Method of append date to the file.
	 * @param path
	 * @param inputText
	 * @param append
	 * @throws IOException
	 */
	public static void appendFile(String path,String inputText, boolean append) throws IOException
	{
		BufferedWriter bufferedWriter;
		
		if(append)
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
	
	/**
	 * Method of viewing file.
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
	 * Method of deleting file.
	 * @param path
	 * @throws IOException
	 */
	public static void deleteFile(String path) throws IOException
	{
		File file = new File(path);
		file.delete();
	}
	
	/**
	 * Method of creating new folder.
	 * @param path
	 * @throws IOException
	 */
	public static void createDir(String path) throws IOException
	{
		 File directory = new File(path);

		 if (!directory.exists())
		 {
			 System.out.printf("You have created new folder '%s'.\n", path);
			 directory.mkdir();			 
		 }
		 else
		 {
			 System.out.printf("You will use existing folder '%s'.\n",path);
		 }
	}
}
