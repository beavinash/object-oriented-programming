/**
 * 
 */
package edu.umb.cs.cs681.hw04_3;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author avinashreddy
 *
 */
public class StreamBasedPrimeNumberGenerator extends PrimeNumberGenerator {

    public StreamBasedPrimeNumberGenerator() {
        super();
    }

    public StreamBasedPrimeNumberGenerator(long from, long to) {
        super(from, to);
    }

    @Override
    public void run() {
        this.primes = LongStream.range(this.from, this.to).filter(value -> isPrime(value)).boxed().collect(Collectors.toList());
    }
}