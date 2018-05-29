/**
 * 
 */
package edu.umb.cs.cs681.hw10_1;

/**
 * @author avinashreddy
 *
 */
public class Guest implements Runnable {
    private SecurityGate gate;
    public Guest(){
        gate = SecurityGate.getInstance();
    }
    @Override
    public void run() {
        gate.enter();
        gate.exit();
        gate.getCount();
    }
}
