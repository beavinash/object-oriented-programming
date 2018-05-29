/**
 * 
 */
package edu.umb.cs.cs681.hw16;
import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author avinashreddy
 *
 */
public class FIFOFileCache extends FileCache {
	private ReentrantLock lock = new ReentrantLock();
	private static FIFOFileCache instance = null;
	private String targetFile;
	

	public static FIFOFileCache getInstance()
	{
		if(instance == null) {
			instance = new FIFOFileCache();
		}
		return instance;
	}

	@Override
	public void replace(LinkedHashMap<Path, String> cache, File targetFile) {		
		Path path = targetFile.toPath();
		String file = targetFile.toString();
		
		Object key  = cache.keySet().iterator().next();
		cache.remove(key);
		
		cache.put(path, file);
		
		System.out.println("cache is replaced");
		System.out.println(key+" is replaced by " +path);
	}

	@Override
	public String fileFetch(String targetFile)  throws FileNotFoundException {
		super.fetch(targetFile);
		return targetFile;
	}
}
