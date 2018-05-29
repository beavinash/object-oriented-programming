/**
 * 
 */
package edu.umb.cs.cs681.hw08;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author avinashreddy
 *
 */


public class File { 

ReentrantLock lock = new ReentrantLock();
    private boolean changed = false ;
    private String filePath = "textfile.txt";
    private java.io.File file = new java.io.File(filePath);

    public void change(){
    	lock.lock();
        try{
            changeContentFile();
            changed = true ;
        }finally {
        	lock.unlock();
        }
    }

    public void save(){
    	lock.lock();
        try {
            if (!changed) {
                return;
            } else {
                // get current Timestamp
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println(timestamp);
                changed = false;
            }
        }finally {
        	lock.unlock();
        }
    }

    private void changeContentFile(){
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;
        try
        {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null)
            {
                if (line.contains("ABC"))
                    line = line.replace("ABC", "CDF");
                lines.add(line);
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(lines.toString());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}

