/**
 * 
 */
package edu.umb.cs.cs681.hw10_1;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */


public class SecurityGate {

    private int count = 0;
    private static ReentrantLock LOCK = new ReentrantLock(true);
//    private ReentrantLock lock = new ReentrantLock();
    public static SecurityGate instance;

    public static SecurityGate getInstance() {
        if (null == instance) {
            LOCK.lock();
            try {
                if (null == instance) {
                    instance = new SecurityGate();
                }

            } finally {
                LOCK.unlock();
            }
        }
        return instance;
    }

    public void enter(){
        LOCK.lock();
        try
		{
			count++;
		}
		finally{
			LOCK.unlock();
		}
    }

    public void exit(){
        LOCK.lock();
        try
		{
			count--;
		}
		finally
		{
			LOCK.unlock();
		}
    }

    public int getCount(){
        System.out.println(count);
        return count;
    }
    
    

}
