/**
 * Woolie.java
 *
 * This class holds the Woolies that will cross the bridge.
 *
 * File:
 *	$Id: Woolie.java,v 1.0 2015/11/10 20:22:17 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Woolie.java,v $
 *	Initial revision
 *
 */

/**
 * The Woolie class.
 *
 * @author Tommy Li
 */

public class Woolie extends Thread implements Runnable {

   /**
    * The name of the Woolie.
    */
    private String name;

   /**
    * The time it takes the Woolie to cross.
    */
    private int crossTime;

   /**
    * The destination of the Woolie.
    */
    private String destination;

   /**
    * The TrollsBridge the Woolie is crossing.
    */
    private TrollsBridge bridgeGuard;

   /**
    * Construct a new Woolie object that can run as a thread. The constructor simply 
    * initializes all of the instance's fields.
    * @param name The name of the Woolie.
    * @param crossTime The time it takes the Woolie to cross.
    * @param destination The destination of the Woolie.
    * @param bridgeGuard The TrollsBridge the Woolie is crossing.
    */
    public Woolie(String name, int crossTime, String destination, TrollsBridge bridgeGuard) {
        if (name == null) {
            System.out.println("name cannot be null");
            System.exit(0);
        }
        if (crossTime < 0) {
            System.out.println("crossTime must be greater or equal to 0");
            System.exit(0);
        }
        if (!destination.equals("Sicstine") && !destination.equals("Merctran")) {
            System.out.println("destination must be Sicstine or Merctran");
            System.exit(0);
        }
        if (bridgeGuard == null) {
            System.out.println("bridgeGuard cannot be null");
            System.exit(0);
        }
        this.name = name;
        this.crossTime = crossTime;
        this.destination = destination;
        this.bridgeGuard = bridgeGuard;
    }

   /**
    * The run method handles a Woolie's behavior as it crosses the bridge. The well-behaved Woolie
    * asks the troll at the bridge to cross. While it is crossing the bridge, it reports its progress 
    * each second as it works its way across, and the woolie lastly tells the troll that it has gotten off the bridge.
    * There are several messages that a Woolie thread must display to describe their progress crossing the bridge.
    *
    * Note: In all the following messages "name" is the representation of the Woolie returned by its getName() method. 
    * The Woolie prints the first message immediately after telling the troll it wants to enter.
    *
    * When the Woolie starts crossing the bridge, at time 0, display the message 
    *     name is starting to cross.
    *
    * For every one second interval, beyond time 0, that the Woolie is on the bridge, display the message
    *     name xyz seconds.
    * where "xyz" is the number of seconds that the Woolie has been on the bridge. 
    *
    * When the Woolie reaches its destination, display the message
    *     name leaves at city.
    * where "city" is the Woolie's destination. After printing this final message, the woolie tells the troll that it 
    * is leaving the bridge. 
    */
    public void run() {
        int time = 1;
        bridgeGuard.enterBridgePlease(this);
        System.out.println(this.woolieName() + " is starting to cross.");
        while (time <= crossTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.print("InerruptedException: Thread cannot be put to sleep.");
            }
            System.out.println("\t" + this.woolieName() + " " + time + " seconds.");
            time++;
        }
        System.out.println(this.woolieName() + " leaves at " + destination + ".");
        bridgeGuard.leave();
    }

   /**
    * Gets the name of the Woolie.
    * @return The name of the Woolie.
    */
    public String woolieName() {
        return name;
    }
}
