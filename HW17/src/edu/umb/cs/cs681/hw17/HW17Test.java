/**
 * 
 */
package edu.umb.cs.cs681.hw17;

import java.io.File;

/**
 * @author avinashreddy
 *
 */
public class HW17Test {
	
	public static void main(String args[])
	{
		String A = "a.html";
		File fileA = new File(A);
		
		
		String B = "b.html";
		File fileB = new File(B);
		
		
		String C = "c.html";
		File fileC = new File(C);
		
		
		RequestHandler requestHandler = new RequestHandler(fileA, FIFOFileCache.getInstance());
		Thread thread1 = new Thread(requestHandler);
		Thread thread2 = new Thread(requestHandler); 
		Thread thread3 = new Thread(requestHandler);
		
		requestHandler = new RequestHandler(fileB, FIFOFileCache.getInstance());
		Thread thread4 = new Thread(requestHandler);
		Thread thread5 = new Thread(requestHandler);
		
		requestHandler = new RequestHandler(fileC, FIFOFileCache.getInstance());
		Thread thread6 = new Thread(requestHandler);
		Thread thread7 = new Thread(requestHandler);
		
		
		
		startOfThread(requestHandler, thread1, thread2, thread3, thread4, thread5, thread6, thread7);
	}

	private static void startOfThread(RequestHandler requestHandler, Thread thread1, Thread thread2, Thread thread3,
			Thread thread4, Thread thread5, Thread thread6, Thread thread7) {
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		
		
		
		try{
			Thread.sleep(4000);
		}catch (InterruptedException e) {}
		thread1.interrupt();
		thread6.interrupt();
		thread2.interrupt();
		thread3.interrupt();
		thread4.interrupt();
		thread5.interrupt();		
	
		thread6.interrupt();
		thread7.interrupt();
		
		
		requestHandler.setDone();
	}
}
