/**
 * 
 */
package edu.umb.cs.cs681.hw18;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */
public class Observable {
	private ArrayList<Observer> observers;
	private boolean changed;
	private ReentrantLock lock = new ReentrantLock();
	
	public Observable(){
		lock.lock();
		try {
			this.observers = new ArrayList<Observer>();
			this.changed = false;
		} finally {
			lock.unlock();
		}
	}

	public void addObserver(Observer o) {
		lock.lock();
		try {
			this.observers.add(o);
		} finally {
			lock.unlock();
		}
	}

	public void deleteObserver(Observer o) {
		lock.lock();
		try {
			this.observers.remove(o);
		} finally {
			lock.unlock();
		}
	}

	protected void setChanged(){
		lock.lock();
		try {
			this.changed = true;
		} finally {
			lock.unlock();
		}
	}

	protected void clearChanged() {
		lock.lock();
		try {
			this.changed = false;
		} finally {
			lock.unlock();
		}
	}

	public boolean hasChanged(){
		return this.changed;
	}

	public void notifyObservers(Object obj) {
		lock.lock();
		try {
			if (hasChanged()) {
				
				for (Observer obs: observers) {
					obs.update(this, obj);
				}
				clearChanged();
			}
		} finally {
			lock.unlock();
		}
	}
}
