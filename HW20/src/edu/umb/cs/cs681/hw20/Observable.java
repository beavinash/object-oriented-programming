/**
 * 
 */
package edu.umb.cs.cs681.hw20;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author avinashreddy
 *
 */
public class Observable {
	private CopyOnWriteArrayList<Observer> observers;
	private boolean changed;
	private ReentrantLock lock = new ReentrantLock();
	
	public Observable(){
			this.observers = new CopyOnWriteArrayList<Observer>();
			this.changed = false;
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
			this.observers.remove(o);
	}

	protected void setChanged(){
			this.changed = true;
	}

	protected void clearChanged() {
			this.changed = false;
	}

	public boolean hasChanged(){
		return this.changed;
	}

	public void notifyObservers(Object arg) {

		lock.lock();
		try {
			if (!this.changed) 
				return;
			changed = false;
		} finally {
			lock.unlock();
		}
		Iterator it = observers.iterator();
		while( it.hasNext()) {
			((Observer) it.next()).update(this, arg);
		}
		clearChanged();
	}
}
