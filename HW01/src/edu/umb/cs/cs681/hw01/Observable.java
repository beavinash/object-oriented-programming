/**
 * 
 */
package edu.umb.cs.cs681.hw01;
import java.util.ArrayList;
/**
 * @author avinashreddy
 *
 */
public class Observable {
	private ArrayList<Observer> observers;
	private boolean changed;
	
	public Observable(){
		this.observers = new ArrayList<Observer>();
		this.changed = false;
	}

	public void addObserver(Observer o){
		this.observers.add(o);
	}

	public void deleteObserver(Observer o){
		this.observers.remove(o);
	}

	protected void setChanged(){
		this.changed = true;
	}

	protected void clearChanged(){
		this.changed = false;
	}

	public boolean hasChanged(){
		return this.changed;
	}

	public void notifyObservers(Object obj) {
		if (hasChanged()) {
			
			for (Observer obs: observers) {
				obs.update(this, obj);
			}
			
//			for(int i=0; i<this.observers.size(); i++){
//				this.observers[i].update(this,obj);
//			}
			
			clearChanged();
		}
	}
}
