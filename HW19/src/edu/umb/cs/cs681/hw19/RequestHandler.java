/**
 * 
 */
package edu.umb.cs.cs681.hw19;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author avinashreddy
 *
 */
public class RequestHandler implements Runnable {
	private String randomFilePath;
    private AccessCounter accessCounter = AccessCounter.getInstance();
	private ReentrantLock lock = new ReentrantLock();
    boolean done = false;
    

    @Override
    public void run() {
    	lock.lock();
		try{
			while(done == false) {
				Path path = Paths.get("src/a.html");
				Path path2 = Paths.get("src/b.html");
				Path path3 = Paths.get("src/c.html");
				getAdd(path, path2, path3);
			}
		}finally{
			lock.unlock();
		}
    }

	private void getAdd(Path path, Path path2, Path path3) {
		accessCounter.increment(path);
		accessCounter.getCount(path);
		accessCounter.increment(path2);
		accessCounter.getCount(path2);
		accessCounter.increment(path3);
		accessCounter.getCount(path3);
	}
    
    public void setDone() {
		done = true;
	}
}
