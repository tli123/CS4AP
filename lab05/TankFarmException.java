/**
 * TankFarmException.java
 *
 * This class passes messages to the superclass when called.
 *
 * File:
 *	$Id: TankFarmException.java,v 1.0 2015/09/25 15:42:27 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: TankFarmException.java,v $
 *	Initial revision
 *
 */

/**
 * A TankFarmException program in Java.
 *
 * @author Tommy Li
 */

public class TankFarmException extends java.lang.Exception {

    /**
     * The constructor the passes the message to the superclass.
     * @param message The message that the class will hold.
     */
    public TankFarmException(java.lang.String message) {
	super(message);
    }

}
