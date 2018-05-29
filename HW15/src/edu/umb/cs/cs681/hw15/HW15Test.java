/**
 * 
 */
package edu.umb.cs.cs681.hw15;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author avinashreddy
 *
 */
public class HW15Test {
	public static void main(String[] args) {

        Random rand = new Random();
        int maxNoFilePath = 10;
        List<String> filePaths = new ArrayList<>();
        for (int i = 1; i <= maxNoFilePath; i++) {
            filePaths.add(i+ ".html");
        }

        AccessCounter accessCounter = new AccessCounter(filePaths);
        RequestHandler requestHandler;
        String randomFilePath;
        int randomNum;
        for (int i = 1; i <= maxNoFilePath; i++) {
            randomNum = 1 + rand.nextInt((maxNoFilePath - 1) + 1);
            randomFilePath = randomNum + ".html";
            System.out.println(randomFilePath);
            requestHandler = new RequestHandler(randomFilePath, accessCounter);
            Thread thread = new Thread(requestHandler);
            thread.start();
        }

    }
}
