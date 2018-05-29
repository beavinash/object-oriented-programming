/**
 * 
 */
package edu.umb.cs.cs681.hw04_2;

/**
 * @author avinashreddy
 *
 */
public class PNGTest {
	public static void main(String args[]) throws InterruptedException {
		PrimeNumberGenerator primeGen1= new PrimeNumberGenerator(1L,1000000L);
		PrimeNumberGenerator primeGen2 = new PrimeNumberGenerator(1000001L,2000000L);
		Thread t1 = new Thread(primeGen1);
		Thread t2 = new Thread(primeGen2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		primeGen1.getPrimes().forEach((k1)->System.out.println("Value from (1L,1000000L): " + k1 ));
		System.out.println(" ");
		primeGen2.getPrimes().forEach((k2)->System.out.println("Value from (1000001L,2000000L): " + k2 ));
		
	}
}
