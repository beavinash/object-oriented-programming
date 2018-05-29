/**
 * 
 */
package edu.umb.cs.cs681.hw14;

/**
 * @author avinashreddy
 *
 */
public class FileSystem {
	private static FileSystem fsinstance = null;
	public Directory root;

	public static FileSystem getFileSystem() {
		if (fsinstance == null)
			fsinstance = new FileSystem();
		return fsinstance;
	}

	private FileSystem() {
		super();
	}

	public void showAllElements() {
		this.root.display();
	}

	
	public Directory getRoot() {
		return root;
	}

	public void setRoot(Directory root) {
		this.root = root;
	}
}
