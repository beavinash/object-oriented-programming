/**
 * 
 */
package edu.umb.cs.cs681.hw07;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 * @author avinashreddy
 *
 */

public class HW7Main {
	public static void main(String args[]) throws InterruptedException {
	    
	    CancellablePrimeNumberGenerator cGen1 = new CancellablePrimeNumberGenerator(1L, 100000L);
	    ReentrantLock lock = new ReentrantLock();
	    
	    Thread ct1 = new Thread(cGen1);
	   
	    
	    ct1.start();
	    try {
			Thread.sleep(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    try {
	    		lock.lock();
			cGen1.setDone();
		} finally {
			// TODO Auto-generated catch block
			lock.unlock();
			
		}
	    
	    System.out.println("The Current Size is: "+cGen1.getPrimes().size());
	    cGen1.getPrimes().forEach((k) -> System.out.println("Value : " + k));
	    
	}
	
	
}
