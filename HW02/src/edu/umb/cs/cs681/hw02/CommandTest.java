/**
 * 
 */
package edu.umb.cs.cs681.hw02;

/**
 * @author avinashreddy
 *
 */
public class CommandTest {

    public static void main(String[] args) {
        Commandable commandable = new Commandable();
        commandable.addCommand( ()->{System.out.println("Hello World!");} );
        commandable.setChanged();
        commandable.notifyObservers("Hello World!");
    }

}

