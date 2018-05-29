/**
 * 
 */
package edu.umb.cs.cs681.hw04_3;

/**
 * @author avinashreddy
 *
 */
public class PNGTest {
	public static void main(String args[]) throws InterruptedException {
        PrimeNumberGenerator primeGen1 = new StreamBasedPrimeNumberGenerator(1L, 100000L);
        PrimeNumberGenerator primeGen2 = new StreamBasedPrimeNumberGenerator(100000L, 200000L);
        Thread t1 = new Thread(primeGen1);
        Thread t2 = new Thread(primeGen2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        primeGen1.getPrimes().forEach((k) -> System.out.println("Value from (1L, 100000L) : " + k));
        primeGen2.getPrimes().forEach((k) -> System.out.println("Value from (100000L, 200000L): " + k));
    }
}
