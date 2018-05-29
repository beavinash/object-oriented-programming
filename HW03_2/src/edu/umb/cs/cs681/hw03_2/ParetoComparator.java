/**
 * 
 */
package edu.umb.cs.cs681.hw03_2;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author avinashreddy
 *
 */
public class ParetoComparator implements Comparator<Car> {
	public ParetoComparator(ArrayList<Car> cars) {
		for(Car carObject: cars){
		 carObject.setCars(cars);
		}
	}

	public int compare(Car car1, Car car2){
		return car2.getDominationCount()-car1.getDominationCount();
	}
}
