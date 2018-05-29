/**
 * 
 */
package edu.umb.cs.cs681.hw17;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */
public class AccessCounter {
	
	private HashMap<Path, Integer> map;
	private ReentrantLock lock = new ReentrantLock();
	private static AccessCounter instance = null;

	private AccessCounter() {
		map = new HashMap<>();
	}

	public static AccessCounter getInstance() {
		if(instance==null) {
			instance = new AccessCounter();
		}
		return instance;
	}


	public void increment(Path path) {
		if(map.containsKey(path)) {	
			Set<Path> keys = map.keySet();
			mapKey(path, keys);
		}
		else {
			lock.lock();
			try{
				map.put(path, 1);
			}
			finally{
				lock.unlock();
			}
		}
		
		if(!map.containsKey(path)) {	
			Set<Path> keys = map.keySet();
			mapKey(path, keys);
		}
	}

	private void mapKey(Path path, Set<Path> keys) {
		for (Path key : keys) {
			lock.lock();
			try {
				if(key.equals(path)) {
					Integer value = map.get(key) + 1;
					map.put(key, value);
				}
				else {
					continue;
				}
			}
			finally {
				lock.unlock();
			}
		}
	}

	public int getCount(Path path) {
		int count = 0; 
		if(map.containsKey(path)) {
			Set<Entry<Path, Integer>> entrySet = map.entrySet();
			count = countKey(path, count, entrySet);
		}
		else {
			lock.lock();
			try {
				System.out.println(count);
			}
			finally {
				lock.unlock();
			}
		}
		
		if(!map.containsKey(path)) {	
			Set<Path> keys = map.keySet();
			mapKey(path, keys);
		}
		return count;
	}

	private int countKey(Path path, int count, Set<Entry<Path, Integer>> entrySet) {
		for(Entry<Path, Integer> entry: entrySet) {
			lock.lock();
			try{
				if(entry.getKey().equals(path)) {
					count = entry.getValue();
					System.out.println("Count for file "+entry.getKey().getFileName()+" is "+count);
				}
			}finally {
				lock.unlock();
			}
		}
		return count;
	}

	
}
