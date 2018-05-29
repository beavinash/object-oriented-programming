/**
 * 
 */
package edu.umb.cs.cs681.hw14;

import java.util.Date;

/**
 * @author avinashreddy
 *
 */
public class FSElement {
	String name;
	String owner;
	Date created;
	Date lastModified;
	int size;
	Directory parent;

	public FSElement(Directory parent, String name, String owner, Date created, Date lastModified, int size) {
		super();
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.created = new Date();
		this.lastModified = this.created;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	

	public boolean isFile() {
		return true;
	}

	public void display() {
		System.out.println("File Name:" + this.getName());
		System.out.println("Owner Name:" + this.getOwner());

	}

}
