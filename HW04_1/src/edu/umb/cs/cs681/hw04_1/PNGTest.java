/**
 * 
 */
package edu.umb.cs.cs681.hw04_1;

/**
 * @author avinashreddy
 *
 */
public class PNGTest {
	public static void main(String args[]) throws InterruptedException {
        PrimeNumberGenerator primeGen= new PrimeNumberGenerator(1L,100000L);
        Thread t1 = new Thread(primeGen);
        t1.start();
        t1.join();
        primeGen.getPrimes().forEach((k)->System.out.println("Value from (1L,100000L): " + k ));

    }
}
