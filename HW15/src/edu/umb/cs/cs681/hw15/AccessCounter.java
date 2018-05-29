/**
 * 
 */
package edu.umb.cs.cs681.hw15;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author avinashreddy
 *
 */
public class AccessCounter {
	private Map<String, Long> filePathMap;
    private ReentrantReadWriteLock readWriteLock;
    private Lock readLock;
    private Lock writeLock;

    public AccessCounter(List<String> filePaths) {
        this.filePathMap = new HashMap<>();
        for (String filePath : filePaths) {
            filePathMap.put(filePath, 0L);
        }

        this.readWriteLock = new ReentrantReadWriteLock();
        this.readLock = readWriteLock.readLock();
        this.writeLock = readWriteLock.writeLock();

    }

    public void increment(String filePath) {
        try {
            this.writeLock.lock();
            long count = this.filePathMap.get(filePath);
            count += 1;
            this.filePathMap.put(filePath, count);
            System.out.println(filePath + ": " + count);
        } finally {
            this.writeLock.unlock();
        }
    }

    public long getCount(String filePath) {
        try {
            this.readLock.lock();
            return this.filePathMap.get(filePath);
        } finally {
            this.readLock.unlock();
        }
    }
}
