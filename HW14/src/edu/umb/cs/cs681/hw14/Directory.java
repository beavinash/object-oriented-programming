/**
 * 
 */
package edu.umb.cs.cs681.hw14;
import java.util.ArrayList;
import java.util.Date;
/**
 * @author avinashreddy
 *
 */
public class Directory extends FSElement {
	ArrayList<FSElement> childern;

	public Directory(Directory parent, String name, String owner, Date created) {
		super(parent, name, owner, created, created, 0);

		childern = new ArrayList<FSElement>();
	}

	public ArrayList<FSElement> getChildren() {
		return this.childern;
	}

	public void appendChild(FSElement newChild) {
		this.childern.add(newChild);
	}

	public int getSize() {
		this.size = 0;
		for (FSElement fChildren : this.childern) {
			this.size = this.size + fChildren.getSize();
		}
		return this.size;
	}

	public void display() {
		System.out.println();
		System.out.println("Directory Name:" + this.getName());
		System.out.println("Owner Name:" + this.getOwner());
		System.out.println();
		// System.out.println("Directory Childrens are: " + this.getChildren());
		for (FSElement fChildren : this.childern) {
			fChildren.display();
		}
	}
}
