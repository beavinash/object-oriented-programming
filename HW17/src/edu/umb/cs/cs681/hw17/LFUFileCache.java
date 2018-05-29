/**
 * 
 */
package edu.umb.cs.cs681.hw17;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
/**
 * @author avinashreddy
 *
 */
public class LFUFileCache extends FileCache {
	
	private static LFUFileCache instance = null;
	private AccessCounter accessCounter = AccessCounter.getInstance();
	
	
	public static LFUFileCache getInstance() {
		if(instance == null) {
			instance = new LFUFileCache();
		}
		return instance;
	}
	
	@Override
	public void replace(LinkedHashMap<Path, String> cache, File targetFile) {
		Path path = targetFile.toPath();
		String file = targetFile.toString();
		
		Set<Path> keys = cache.keySet();
		ArrayList<Path> keysList = new ArrayList<Path>(keys);
		Collections.sort(keysList,(Path p1,Path p2)->accessCounter.getCount(p1)-accessCounter.getCount(p2));
		pathKey(cache, path, file, keys, keysList);
		
		System.out.println("Cache Replaced with LFU");
		System.out.println(keysList.get(1)+" is replaced by" +path);	
	}

	private void pathKey(LinkedHashMap<Path, String> cache, Path path, String file, Set<Path> keys,
			ArrayList<Path> keysList) {
		for(Path key:keys) {
			if(key==keysList.get(1))
			{
				cache.remove(key);
				cache.put(path, file);
			}
		}
	}

	@Override
	public String fileFetch(String targetFile) throws FileNotFoundException {
		super.fetch(targetFile);
		return targetFile;
	}
}

