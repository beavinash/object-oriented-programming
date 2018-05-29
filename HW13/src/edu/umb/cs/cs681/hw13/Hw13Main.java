/**
 * 
 */
package edu.umb.cs.cs681.hw13;

/**
 * @author avinashreddy
 *
 */
public class Hw13Main {
	public static void main(String[] args) {
		ThreadSafeBankAccount account = new ThreadSafeBankAccount();
		DepositRunnable d = new DepositRunnable(account);
		WithdrawRunnable w = new WithdrawRunnable(account);
	
		Thread dt = new Thread(d);
		Thread wt = new Thread(w);
		
		
		dt.start();
		wt.start();
		
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			
		}
		
		dt.interrupt();
		d.setDone();
		dt.interrupt();
		w.setDone();
	}
}
