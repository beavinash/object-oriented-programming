/**
 * 
 */
package edu.umb.cs.cs681.hw02;

import java.util.ArrayList;

/**
 * @author avinashreddy
 *
 */
public class Commandable {
	private ArrayList<Command> commands;
    private boolean changed = false;

    public Commandable(){
        this.commands = new ArrayList<>();
    }


    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void deleteCommand(Command command){
        this.commands.remove(command);
    }

    protected void setChanged(){
        this.changed = true;
    }

    protected void clearChanged(){
        this.changed = false;
    }

    public boolean hasChanged(){
        return this.changed;
    }

    public void notifyObservers(Object obj) {
        if (hasChanged()) {
            for(int i=0; i<commands.size(); i++){
                commands.get(i).execute();
            }
            clearChanged();
        }
    }
}
