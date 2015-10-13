/**
 * MyThread class;
 */
package com.vynipox.glm;

public class  MyThread extends Thread{

	
	private PrintValues printValues;
	
	public MyThread(PrintValues printValues)
	{
		this.setPrintValues(printValues);
	}
	
	@Override
	public void run() {
		synchronized(printValues)
		{
			printValues.print(this.getName());
		}
	}

	public PrintValues getPrintValues() {
		return printValues;
	}

	public void setPrintValues(PrintValues printValues) {
		this.printValues = printValues;
	}
}
