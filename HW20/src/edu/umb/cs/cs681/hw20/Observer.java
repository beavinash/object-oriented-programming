/**
 * 
 */
package edu.umb.cs.cs681.hw20;

/**
 * @author avinashreddy
 *
 */
@FunctionalInterface
public interface Observer {
	public abstract void update(Observable obs, Object obj);
}



