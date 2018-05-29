/**
 * 
 */
package edu.umb.cs.cs681.hw19;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author avinashreddy
 *
 */
public class Hw19 {
	
	public static void main(String args[]) {

		RequestHandler requestHandler = new RequestHandler();
		
		Thread thread1 = new Thread(requestHandler);
		Thread thread2 = new Thread(requestHandler);
		Thread thread3 = new Thread(requestHandler);
		Thread thread4 = new Thread(requestHandler);
		Thread thread5 = new Thread(requestHandler);
		Thread thread6 = new Thread(requestHandler);
		Thread thread7 = new Thread(requestHandler);
		Thread thread8 = new Thread(requestHandler);
		

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		

		try{
			Thread.sleep(3000);
		}catch (InterruptedException e) {}
		thread1.interrupt();
		thread2.interrupt();
		thread3.interrupt();
		thread4.interrupt();
		thread5.interrupt();
		thread6.interrupt();
		thread7.interrupt();
		thread8.interrupt();
		
		requestHandler.setDone();
	
	}	
	
}
