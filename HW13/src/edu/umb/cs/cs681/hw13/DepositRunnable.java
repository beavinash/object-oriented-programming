/**
 * 
 */
package edu.umb.cs.cs681.hw13;

/**
 * @author avinashreddy
 *
 */
/**
 * A deposit runnable makes periodic deposits to a bank account.
 */
public class DepositRunnable implements Runnable {
	private static final int DELAY = 100;
	private ThreadSafeBankAccount account;
	private boolean done = false;


	public DepositRunnable(ThreadSafeBankAccount anAccount) {
		this.account = anAccount;
	}

	public void run() {
		try {
			while(true) {
				if(done == true)
					break;
				account.deposit(100);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exception) {
		}
	}
	
	public void setDone() {
		this.done  = true;
	}
}
