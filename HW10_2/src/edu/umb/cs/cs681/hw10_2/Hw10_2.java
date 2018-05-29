/**
 * 
 */
package edu.umb.cs.cs681.hw10_2;

/**
 * @author avinashreddy
 *
 */
public class Hw10_2 {
	public static void main(String args[]) {
		Guest guest = new Guest();

		Thread thread = new Thread(guest);
		Thread thread1 = new Thread(guest);
		Thread thread2 = new Thread(guest);
		Thread thread3 = new Thread(guest);
		Thread thread4 = new Thread(guest);
		Thread thread5 = new Thread(guest);
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

	}
}
