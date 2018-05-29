/**
 * 
 */
package edu.umb.cs.cs681.hw21;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author avinashreddy
 *
 */
public class Hw21Test {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		CallablePrimeGenerator gen = new CallablePrimeGenerator(20, 100); 
		ExecutorService executor = Executors.newFixedThreadPool(2); 
		Future<List<Long>> future = executor.submit(gen);
		List<Long> primes = future.get();
		executor.shutdown();
		
		primes.forEach((k)->System.out.println("Value : " + k ));
	}
}
