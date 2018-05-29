/**
 * 
 */
package edu.umb.cs.cs681.hw12;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author avinashreddy
 *
 */
public class Hw12 {
	public static void main(String args[]) {

		Random rand = new Random();
		int maxNoFilePath = 10;
		List<String> filePaths = new ArrayList<>();
		for (int i = 1; i <= maxNoFilePath; i++) {
			filePaths.add(i + ".html");
		}

		AccessCounter accessCounter = new AccessCounter();
		RequestHandler requestHandler;
		String randomFilePath;
		int randomNum;
		for (int i = 1; i <= maxNoFilePath; i++) {
			randomNum = 1 + rand.nextInt(maxNoFilePath);
			randomFilePath = randomNum + ".html";

			requestHandler = new RequestHandler(randomFilePath, accessCounter);
			Thread thread = new Thread(requestHandler);
			thread.start();
		}

	}
}
