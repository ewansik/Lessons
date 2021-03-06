/**
 * MyThread class;
 */
package com.vynipox.glm;

public class  MyThread extends Thread{

	@Override
	public void run() {
		synchronized(MyThread.class)
		{
			print(this.getName());
		}
	}
	
	public void  print(String name)
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
