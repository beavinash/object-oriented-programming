/**
 * 
 */
package edu.umb.cs.cs681.hw17;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

public
/**
 * @author avinashreddy
 *
 */
 class FIFOFileCache extends FileCache {
	
	private ReentrantLock lock = new ReentrantLock();
	private static FIFOFileCache instance = null;
	
	

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
	public String fileFetch(String targetFile)  throws FileNotFoundException{
		super.fetch(targetFile);
		return targetFile;
	}
}