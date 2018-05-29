/**
 * 
 */
package edu.umb.cs.cs681.hw10_1;

/**
 * @author avinashreddy
 *
 */
public class Hw10_1 {

	public static void main(String args[])
	{
		Guest guest = new Guest();
		Guest guest1 = new Guest();
		Guest guest2 = new Guest();
		Guest guest3 = new Guest();
		Guest guest4 = new Guest();
		Guest guest5 = new Guest();

		Thread thread = new Thread(guest);
		Thread thread1 = new Thread(guest1);
		Thread thread2 = new Thread(guest2);
		Thread thread3 = new Thread(guest3);
		Thread thread4 = new Thread(guest4);
		Thread thread5 = new Thread(guest5);
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	
	}

}
