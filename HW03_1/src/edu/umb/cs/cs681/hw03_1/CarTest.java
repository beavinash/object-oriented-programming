/**
 * 
 */
package edu.umb.cs.cs681.hw03_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author avinashreddy
 *
 */
public class CarTest {
	public static void main(String[] args) {
        
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(115000,2016,"Tesla Model S",200,"Tesla"));
        cars.add(new Car(120000,2015,"M 3",10,"BMW"));
        cars.add(new Car(154000,2014,"Tesla Model X",150,"Tesla"));
        
        System.out.println("The Minimum Price of all cars is: " + min(cars));
        System.out.println("The Maximum Price of all cars is: " + max(cars));
    }

    private static Integer min(List<Car> cars){

        if(cars.size() == 0 || null == cars)
            return 0;

        return cars.stream()
                .map((Car car)-> car.getPrice())
                .min(Comparator.comparing(price -> price))
                .get();
    }

    private static Integer max(List<Car> cars){
        if( cars.size() == 0 || null == cars)
            return 0;

        return cars.stream()
                .map((Car car)-> car.getPrice())
                .max(Comparator.comparing(price -> price))
                .get();
    }
}
