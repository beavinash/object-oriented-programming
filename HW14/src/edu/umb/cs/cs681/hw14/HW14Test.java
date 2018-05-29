/**
 * 
 */
package edu.umb.cs.cs681.hw14;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author avinashreddy
 *
 */
public class HW14Test {
	public static void main(String args[]) {
		
		
		FileQueue  fileQueue = new FileQueue();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		Directory  root= new Directory(null, "root", "rootuser", date);
		
		File fileA = new File(root, "fileA", "root", date, 10);
		File fileB = new File(root, "fileB", "root", date, 10);
		Link link1 = new Link(root, "link1", "root", date, date, 33, fileA);
		root.appendChild(fileA);
		root.appendChild(fileB);
		root.appendChild(link1);
		
		
		FileCrawler fileCrawler = new FileCrawler(root,fileQueue);
		FileIndexer fileIndexer = new FileIndexer(fileQueue);
		
		Thread crawlerThread = new Thread(fileCrawler);
		Thread indexerThread = new Thread(fileIndexer);
		
		crawlerThread.start();
		indexerThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException exception) {
			
		}

		crawlerThread.interrupt();
		fileCrawler.setDone();
		indexerThread.interrupt();
		fileIndexer.setDone();
	}
}
