/**
 * 
 */
package edu.umb.cs.cs681.hw09;

import java.util.ArrayList;

//import javafx.beans.binding.When;
/**
 * @author avinashreddy
 *
 */


public class HW9Test {

    public static void main(String[] args) {
    	
    	ArrayList<Thread> threadlist = new ArrayList<>();
    	for (int i=0; i<3; i++) {
    		Thread t = new Thread(new SingletonRunnable());
    		t.start();
    		System.out.println(" Singleton " + (i));
    	}threadlist.forEach((Thread t) -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
    	
    }
}
