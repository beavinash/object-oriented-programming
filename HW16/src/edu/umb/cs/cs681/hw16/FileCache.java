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
public abstract class FileCache {
	private static ReentrantLock lock = new ReentrantLock();
	private LinkedHashMap<Path, String> cache;

	public FileCache() {
		cache = new LinkedHashMap<Path, String>(4);
	}

	public String fetch(String targetFile) throws FileNotFoundException {	

		File file = new File(targetFile);
		Path path = file.toPath();
		Set<Path> keys = this.cache.keySet();
		if(file.exists()) {	
			lock.lock();
			try{
				if (keys.contains(path)) {
					System.out.println("Cache contains this file");
					//file = this.cache.get(targetFile);
					file = pathKey(file, path, keys);
					FiletoString(file);
				}

				else if(cache.size() != 4) {
					cache.put(path, targetFile);
					System.out.println("File is Cached");
					FiletoString(file);
				} else if(cache.size() == 4) 
				{
					replace(cache,file);
				}
			}finally{
				lock.unlock();
			}
		}	
		else {
			throw new FileNotFoundException("The desired File does not exist");	
		}
		return targetFile;
	}

	private File pathKey(File file, Path path, Set<Path> keys) {
		for(Path key:keys) {
			if(key.equals(path)) {
				String fileContent = cache.get(key);
				file = new File(fileContent);
			}
		}
		return file;
	}
	
	public abstract void replace(LinkedHashMap<Path, String>cache,File targetFile);
	public abstract String fileFetch(String targetFile) throws FileNotFoundException;
	
	private void FiletoString(File file) throws FileNotFoundException {
		lock.lock();
		try {
			
			FileInputStream fis = new FileInputStream(file);
			int content;		
			isRead(fis);
			System.out.println("\n");
		} 
		catch (FileNotFoundException e) {
			System.err.println("The Current File not available");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	}

	private void isRead(FileInputStream fis) throws IOException {
		int content;
		while ((content = fis.read()) != -1) {
			System.out.print((char) content);
		}
	}

	

	
}
