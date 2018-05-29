/**
 * 
 */
package edu.umb.cs.cs681.hw08;

/**
 * @author avinashreddy
 *
 */
public class Editor implements Runnable {

    private File aFile ;
    private boolean done = false ;

    public Editor(File file){
        this.aFile = file;
    }

    public void run(){
        while (true){
            if(done == true){
                System.out.printf("Done");
                break;
            }

            aFile.change();
            aFile.save();
            try {
                Thread.sleep(1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void setDone(){
        done = true;
    }
}
