/**
 * 
 */
package edu.umb.cs.cs681.hw11;

/**
 * @author avinashreddy
 *
 */
public class Hw11Main {
	public static void main(String args[]) {
		CancellablePrimeNumberGenerator gen = new CancellablePrimeNumberGenerator(1L,1000000L);
		
		Thread t = new Thread(gen);
		t.start();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			
		}
	    t.interrupt();
		gen.setDone();
		
		System.out.println("Prime Numbers generated " + gen.getPrimes().size());
	}
}
