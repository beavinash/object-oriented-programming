/**
 * 
 */
package edu.umb.cs.cs681.hw01;

/**
 * @author avinashreddy
 *
 */
public class ObserverMain {
	public static void main(String args[]){
		Observable observable = new Observable(); 
		observable.addObserver( (Observable o, Object obj)->{System.out.println(obj);} ); 
		observable.setChanged();
		observable.notifyObservers("Hello World!");
		System.out.println();
	}
}