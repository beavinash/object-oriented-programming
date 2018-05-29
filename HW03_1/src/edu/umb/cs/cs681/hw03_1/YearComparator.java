/**
 * 
 */
package edu.umb.cs.cs681.hw03_1;

import java.util.*;
/**
 * @author avinashreddy
 *
 */
public class YearComparator implements Comparator<Car> {
	public int compare(Car car1, Car car2){
		return car1.getYear()-car2.getYear();
	}
}
