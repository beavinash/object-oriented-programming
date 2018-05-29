/**
 * 
 */
package edu.umb.cs.cs681.hw12;

/**
 * @author avinashreddy
 *
 */
public class RequestHandler implements Runnable {
	private String randomFilePath;
    private AccessCounter accessCounter;

    public RequestHandler(String randomFilePath, AccessCounter accessCounter) {
        this.randomFilePath = randomFilePath;
        this.accessCounter = accessCounter;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " access to " + this.randomFilePath);
        this.accessCounter.increment(this.randomFilePath);
        System.out.println(threadName + ": access count of " + randomFilePath + ": " + this.accessCounter.getCount(this.randomFilePath));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
