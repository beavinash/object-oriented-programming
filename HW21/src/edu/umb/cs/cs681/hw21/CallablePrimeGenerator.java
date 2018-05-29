/**
 * 
 */
package edu.umb.cs.cs681.hw21;
import java.util.*;
import java.util.concurrent.*;
import java.util.ArrayList;
/**
 * @author avinashreddy
 *
 */
class CallablePrimeGenerator implements Callable<List<Long>>{ 
	
	private List<Long> primes;
	private long from;
	private long to;

	public CallablePrimeGenerator(long from, long to){
		this.from = from;
		this.to = to;
		this.primes = new ArrayList<Long>(); 
	}
	
	public List<Long> call() throws Exception { 
		PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGenerator(this.from, this.to);
		Thread t = new Thread(primeNumberGenerator);
		t.start();
		t.join();
		this.primes = primeNumberGenerator.getPrimes();
		return this.primes; 
	} 
	
}
