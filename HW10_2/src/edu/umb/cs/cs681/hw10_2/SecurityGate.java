/**
 * 
 */
package edu.umb.cs.cs681.hw10_2;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */
public class SecurityGate {

	
	private static SecurityGate instance = null;
	private static ReentrantLock lock = new ReentrantLock();
	AtomicInteger at = new AtomicInteger(8);
	
	public static SecurityGate getInstance()
	{
		lock.lock();
		try {
			if(instance==null) {
				instance = new SecurityGate();
			}
		} finally {
			lock.unlock();
		}
		return instance;
	}

	public void enter()
	{
		at.updateAndGet((int i)->++i);
	}

	public void exit()
	{
		at.updateAndGet((int i)->--i);
	}
	
	public void getCount()
	{
		System.out.println(at);
	}
	
}
