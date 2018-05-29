/**
 * 
 */
package edu.umb.cs.cs681.hw14;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */
public class File extends FSElement {
	public File(Directory parent, String name, String owner, Date created,int size) {
		super(parent, name, owner, created, created, size);

	}

	@Override
	public boolean isFile() {
		return true;
	}

	public int getSizer() {
		return this.size;
	}

	@Override
	public void display() {
		System.out.println("FileName:" + this.getName());
		System.out.println("File Size: " + this.getSizer());
	}
}
