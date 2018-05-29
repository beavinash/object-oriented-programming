/**
 * 
 */
package edu.umb.cs.cs681.hw03_2;

import java.util.Comparator;

/**
 * @author avinashreddy
 *
 */
public class MileageComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2) {
		return (int)(car2.getMileage()-car1.getMileage());
	}
}
