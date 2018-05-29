/**
 * 
 */
package edu.umb.cs.cs681.hw06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author avinashreddy
 *
 */
public class MCTest {
    public static void main(String[] args) {
    	
        if (args.length == 2) {
            long nTimes = Long.valueOf(args[0]);
            int nThreads = Integer.valueOf(args[1]);
            Thread thread;
            for (int nCount = 0; nCount < nThreads; nCount++) {
                thread = new Thread(() -> {
                    long n = 25;
                    for (long i = 0; i < nTimes; i++) {
                        n *= 25;
                    }

                    System.out.println(Thread.currentThread().getName() + " Value: " + n);
                });

                thread.start();
            }

        }

    }
}
