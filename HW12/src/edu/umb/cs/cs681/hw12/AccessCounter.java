/**
 * 
 */
package edu.umb.cs.cs681.hw12;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author avinashreddy
 *
 */


public class AccessCounter {

	private Map<Path, Long> filePathMap;
	private Lock lock = new ReentrantLock();

	public AccessCounter() {
		if( null == this.filePathMap) {
			this.filePathMap = new HashMap<>();
		}
	}
	public void increment(String fileName) {
		
		Path path = Paths.get(fileName);
		try {
			this.lock.lock();
			if(this.filePathMap.containsKey(path) ) {
				long count = this.filePathMap.get(path) +1;
				this.filePathMap.put(path, count);
			}
			else {
				this.filePathMap.put(path, 1L);
			}
			
			
		} finally {
			this.lock.unlock();
		}
	}

	public long getCount(String filePath) {
		Path path = Paths.get(filePath);
		long count =0;
		try {
			this.lock.lock();
			count =  this.filePathMap.containsKey(path)  ? this.filePathMap.get(path) :0;
		} finally {
			this.lock.unlock();
		}
		return count;
	}
}

