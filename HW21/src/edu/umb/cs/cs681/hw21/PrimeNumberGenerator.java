/**
 * 
 */
package edu.umb.cs.cs681.hw21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author avinashreddy
 *
 */


public class PrimeNumberGenerator implements Runnable {
    protected List<Long> primes;
    protected Long from;
    protected Long to;

    protected boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) return false;

        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public PrimeNumberGenerator() {

    }

    public PrimeNumberGenerator(long from, long to) {
        this.primes = new ArrayList<Long>();
        this.from = from;
        this.to = to;
    }

    public void run() {
        for (long n = from; n <= to; n++) {
            if (isPrime(n)) {
                this.primes.add(n);
            }
        }
    }


    public List<Long> getPrimes() {
        return primes;
    }

    public void setPrimes(List<Long> primes) {
        this.primes = primes;
    }


}
