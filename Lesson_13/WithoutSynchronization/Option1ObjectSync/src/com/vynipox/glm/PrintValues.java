/**
 * Print Values class.
 */
package com.vynipox.glm;

public class PrintValues {
	public void print(String name)
	{
		for(int i = 0; i < 100; i++)
		{
			if((i % 10) == 0)
			{
				System.out.print("\n");
				System.out.print(name + ":");
			}
			System.out.printf(" %d",i);
		}
	}
}
