/**
 * 
 */
package edu.umb.cs.cs681.hw17;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */
public class RequestHandler implements Runnable{
	
	private FileCache fileCache;
	private Path path;
	private File file;
	private AccessCounter access = AccessCounter.getInstance();
	private ReentrantLock lock = new ReentrantLock();
	volatile boolean done = false;
	

	public RequestHandler(File file, FileCache fileCache) { 
		lock.lock();
		try {
			this.fileCache = fileCache; 
			this.path = file.toPath();
			this.file = file;
		}
		finally {
			lock.unlock();
		}
	}

	public void setDone() {
		done = true;
	}

	@Override
	public void run() {
		lock.lock();
		try{
			if(done == false) {
				fileCache.fetch(file.toString());
				access.increment(path);
				access.getCount(path);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}