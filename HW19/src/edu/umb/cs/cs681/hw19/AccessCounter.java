/**
 * 
 */
package edu.umb.cs.cs681.hw19;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author avinashreddy
 *
 */


public class AccessCounter {

	private static ConcurrentHashMap<Path, Integer> map;
	private Lock lock = new ReentrantLock();
	private static AccessCounter instance = null;

	public static AccessCounter getInstance()
	{
		if (instance==null) {
			instance = new AccessCounter();
			map = new ConcurrentHashMap<>();
		}
		return instance;
	}
	
	public void increment(Path path) {
		map.compute(path,(Path p,Integer v)->{return v==null ? 1 : ++v;});
	}
	
	public int getCount(Path path) {
		int count = 0;
		if (map.containsKey(path)) {
			count = map.computeIfPresent(path, (Path p, Integer v)->{return v;});
			System.out.println("Count to the file for "+path.getFileName()+" is "+count);
			return count;
		}
		System.out.println("The count:"  + count);
		return count;
	}

	
}

