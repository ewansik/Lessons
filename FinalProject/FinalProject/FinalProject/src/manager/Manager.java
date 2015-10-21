package manager;

import thread.MyThread;

public class Manager {

	public void test(MyThread myThread)
	{
		myThread.start();
		try {
			myThread.join();
			System.out.println(myThread.getHospital().getLocation());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}	
}
