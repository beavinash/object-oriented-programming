/**
 * 
 */
package edu.umb.cs.cs681.hw09;

/**
 * @author avinashreddy
 *
 */

	

	public class SingletonRunnable implements Runnable  {

		
		@Override
		public void run() {
			Singleton.getInstance();
		}

	}

