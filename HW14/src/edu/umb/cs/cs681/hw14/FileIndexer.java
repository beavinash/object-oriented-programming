/**
 * 
 */
package edu.umb.cs.cs681.hw14;

/**
 * @author avinashreddy
 *
 */
public class FileIndexer implements Runnable {
	private FileQueue queue;
	private boolean done = false;
	public FileIndexer() {
		
	}
	public FileIndexer(FileQueue queue) {
		this.queue= queue;
	}
	@Override
	public void run() {
		while(done == false ){
			File file = queue.get();
			if(file!=null){
			indexFile(file);
			}
			try {
			Thread.sleep(100);
			} catch (InterruptedException exception) {}
			}
	}

	public void indexFile(File file) {
		// index a give file.
		if(null != file) {
			System.out.println(file.getName());
		}
		
	}
	public void setDone() {
		// TODO Auto-generated method stub
		this.done = true;
	}
}
