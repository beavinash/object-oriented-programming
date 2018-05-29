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
public class Link extends FSElement {
	FSElement target;

	public Link(Directory parent, String name, String owner, Timestamp date, Timestamp date2, int size,FSElement target) {
		super(parent, name, owner, date, date2, size);
		this.target = target;
	}

	@Override
	public boolean isFile() {
		return true;
	}

	public int getTaregetSizer() {
		return this.target.size;
	}

	@Override
	public void display() {
		System.out.println("LinkName:" + this.getName());
		System.out.println("owner:" + this.getOwner());
		System.out.println("PointTo:" + this.target.getName());
		System.out.println("Link Size: " + this.getTaregetSizer());
	}
}
