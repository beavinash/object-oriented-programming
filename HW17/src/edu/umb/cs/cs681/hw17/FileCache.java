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
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * @author avinashreddy
 *
 */


public abstract class FileCache  {
	
	private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
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
			rwLock.writeLock().lock();
			try{
				isContain(targetFile, file, path, keys);
			} finally {
				rwLock.readLock().lock();
				rwLock.writeLock().unlock();
			} try {
					FiletoString(file);
				}finally {
					rwLock.readLock().unlock();
				}

		}	
		else {
			throw new FileNotFoundException("The current File does not exist");	
		}
		return targetFile;
	}

	private void isContain(String targetFile, File file, Path path, Set<Path> keys) {
		if(!keys.contains(path)) {
			if(cache.size() != 4) {
				cache.put(path, targetFile);
				System.out.println("File is Cached");
			}
			else {
				replace(cache,file);
			}
		}
	}
	
	public abstract void replace(LinkedHashMap<Path, String>cache,File targetFile);

	public abstract String fileFetch(String targetFile) throws FileNotFoundException;

	private void FiletoString(File file) throws FileNotFoundException {
		lock.lock();
		try  {

			FileInputStream fis = new FileInputStream(file);
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
