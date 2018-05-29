/**
 * 
 */
package edu.umb.cs.cs681.hw14;

import java.util.LinkedList;

/**
 * @author avinashreddy
 *
 */
public class FileQueue {
	LinkedList<File> linkedList;

	public FileQueue() {
		linkedList = new LinkedList<>();

	}

	public void put(File file) {
		this.linkedList.add(file);
	}

	public File get() {
		File fileReturn = null;

		if (linkedList.size() > 0) {
			fileReturn = linkedList.get(0);
			linkedList.removeFirst();
		}
		return fileReturn;
	}
}
