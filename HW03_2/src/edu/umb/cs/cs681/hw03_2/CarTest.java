/**
 * 
 */
package edu.umb.cs.cs681.hw03_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author avinashreddy
 *
 */
public class CarTest {
	public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(100000, 2016, "Model S", 200, "Tesla"));
        cars.add(new Car(120000, 2015, "A4", 10, "Audi"));
        cars.add(new Car(150000, 2014, "M3", 15, "BMW"));
        cars.add(new Car(150000, 2012, "Model X", 150, "Tesla"));
        System.out.println("The number of counts are: " + count(cars));
        System.out.println("The number reduced for cars are:" + reduce(cars));
        System.out.println("The average number is: " + average(cars));
    }

    private static Long count(List<Car> cars) {
        if (null == cars || cars.size() == 0)
            return (long) 0;

        return cars.stream()
                .map((Car car) -> car.getMake())
                .count();
    }

    private static String reduce(List<Car> cars) {
        if (null == cars || cars.size() == 0)
            return "";

        return cars.stream()
                .map((Car car) -> car.getMake())
                .reduce(" ", (result, carMaker) -> result + carMaker,
                        (result, intermediateR) -> result);
    }

    private static Integer average(List<Car> cars) {
        if (null == cars || cars.size() == 0)
            return (int) 0;

        final AtomicInteger count = new AtomicInteger();
        return cars.stream()
                .map((Car car) -> car.getPrice())
                .reduce(0, (a, b) -> {
                    int number = count.incrementAndGet();
                    return (a * (number - 1) + b) / number;
                });

    }
}
