
package edu.umb.cs.cs681.hw09;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */


public class Singleton {

    public static Singleton instance;
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static Singleton getInstance() {
        
            lock.lock();
            try {
                if (null == instance) {
                    instance = new Singleton();
                }
                return instance;
            } finally {
                lock.unlock();
            }
    }
    
    
	public void run() {
		System.out.println(Singleton.getInstance());
	}

    private Singleton(){}
}
