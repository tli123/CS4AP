/**
 * TrollBridge.java
 *
 * This class holds the bridge the Woolies will cross.
 *
 * File:
 *	$Id: TrollBridge.java,v 1.0 2015/11/10 17:21:11 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: TrollBridge.java,v $
 *	Initial revision
 *
 */

/**
 * The bridge class.
 *
 * @author Tommy Li
 */

import java.util.Queue;
import java.util.LinkedList;

public class TrollsBridge {

   /**
    * Holds the maximum capacity of this bridge.
    */
    private int max;

   /**
    * Holds the number of Woolies on the bridge.
    */
    private int onBridge;

   /**
    * Holds the line of Woolies.
    */
    private Queue<Woolie> line;

   /**
    * Create a TrollsBridge with a given capacity. The municipal authority creates a 
    * TrollsBridge for each bridge that needs management.
    * @param max the maximum capacity of the TrollsBridge.
    */
    public TrollsBridge(int max) {
        this.max = max;
        onBridge = 0;
        line =  new LinkedList<Woolie>();
    }

   /**
    * Request permission to go onto the troll's bridge. Woolies call this method to 
    * ask the troll to put them on the queue of woolies trying to get on the bridge. 
    * The Woolie (thread) waits until it becomes the head of the queue and there is 
    * room on the troll's bridge.
    *
    * Note: Since this class is a monitor, this method needs to ensure mutual exclusive 
    * access by calling threads. That means synchronized methods are needed.
    *
    * The troll of a TrollsBridge guards its bridge to make sure that woolies get on 
    * the bridge in the order of their arrival.
    *
    * The troll of a TrollsBridge prints the following message when the Woolie shows 
    * up to get in line to cross the bridge:
    *
    * The troll scowls "Get in line!" when woolies_name_here shows up at the bridge.
    * @param thisWoolie the Woolie trying to get on the bridge (the same object as 
    *                   Thread calling this method)
    */
    public synchronized void enterBridgePlease(Woolie thisWoolie) {
        line.add(thisWoolie);
        System.out.println("The troll scowls \"Get in line!\" when " + thisWoolie.woolieName() + " shows up at the bridge.");
        while (onBridge == max || line.peek() != thisWoolie) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.print("InterrupedException: Thread cannot be placed in wait()");
            }
        }
        onBridge++;
        line.remove(thisWoolie);
    }

   /**
    * Tell the troll of a TrollsBridge that a woolie has left the bridge so that 
    * the troll can let other woolies get on if there is room.
    *
    * A well-behaved Woolie always informs the troll of a TrollsBridge that it 
    * (the caller) is getting off the bridge.
    *
    * Note: Since this class is a monitor, this method needs to ensure mutual exclusive 
    * access by calling threads. That means synchronized methods are needed.
    *
    */
    public void leave() {
        onBridge--;
        try {
            notifyAll();
        } catch (IllegalMonitorStateException e) {}
    }

}
