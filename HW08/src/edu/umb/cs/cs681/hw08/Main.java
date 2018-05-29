/**
 * 
 */
package edu.umb.cs.cs681.hw08;

/**
 * @author avinashreddy
 *
 */
public class Main {

    public static void main(String[] args)  {
       
    	File file = new File();
    	Editor editorFile = new Editor(file);
    	AutoSaver autoSaverFile = new AutoSaver(file);
    	
    	Thread t1 = new Thread(editorFile);
    	Thread t2 = new Thread(autoSaverFile);
    	
    	t1.start();
    	t2.start();
    	
    	try {
			Thread.sleep(1000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        editorFile.setDone();
        autoSaverFile.setDone();
        
        try {
			t1.join();
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }

}
