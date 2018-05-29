/**
 * 
 */
package edu.umb.cs.cs681.hw14;

/**
 * @author avinashreddy
 *
 */
public class FileCrawler implements Runnable {
	private Directory root; // root dir of a given drive (tree structure)
	private FileQueue queue;
	private boolean done;

	public FileCrawler() {
		
	}
	public FileCrawler(Directory root, FileQueue queue) {
		this.root = root;
		this.queue = queue;
	}
	@Override
	public void run() {
		while(!done) {
			crawl(root);
		try {
			Thread.sleep(100);
		} catch (InterruptedException exception) {}
	}

	}

	private void crawl(Directory root) {
		// Crawl a given drive (tree structure)
		// Put files to a queue. Ignore directories and links.
		for (FSElement fs : root.getChildren()) {
			if (fs instanceof File) {
				queue.put((File) fs);
			}
		}
	}
	public void setDone() {
		this.done = true;
		
	}
}
