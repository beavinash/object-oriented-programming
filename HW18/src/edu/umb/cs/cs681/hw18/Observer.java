/**
 * 
 */
package edu.umb.cs.cs681.hw18;

/**
 * @author avinashreddy
 *
 */
@FunctionalInterface
public interface Observer {
	public abstract void update(Observable obs, Object obj);
}



