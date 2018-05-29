/**
 * 
 */
package edu.umb.cs.cs681.hw01;

/**
 * @author avinashreddy
 *
 */
@FunctionalInterface
public interface Observer {
	public abstract void update(Observable obs, Object obj);
}



