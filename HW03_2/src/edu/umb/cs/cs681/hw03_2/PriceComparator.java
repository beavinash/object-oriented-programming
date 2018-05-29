/**
 * 
 */
package edu.umb.cs.cs681.hw03_2;

import java.util.Comparator;
/**
 * @author avinashreddy
 *
 */
public class PriceComparator implements Comparator<Car> {
	public int compare(Car car1, Car car2){
		return car2.getPrice()-car1.getPrice();
	}
}
