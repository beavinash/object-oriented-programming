/**
 * 
 */
package edu.umb.cs.cs681.hw05;


import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author avinashreddy
 *
 */
public class HW5Test {
	public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LongStream.range(1L, 100000L).filter(value -> {
                if (value <= 1) {
                    return false;
                }

                if (value == 2) {
                    return true;
                }
                
                if (value % 2 == 0) return false;

                //if not, then just check the odds
                for (int i = 3; i * i <= value; i += 2) {
                    if (value % i == 0)
                        return false;
                }
                return true;
            }).boxed().collect(Collectors.toList()).forEach((k) -> System.out.println("Value from (1L, 100000L): " + k));
        });
        t1.start();
    }
}
