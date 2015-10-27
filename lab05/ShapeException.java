/**
 * ShapeException.java
 *
 * This class handles ShapeExceptions by passing the message to the superclass.
 *
 * File:
 *	$Id: ShapeException.java,v 1.0 2015/09/25 15:21:14 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: ShapeException.java,v $
 *	Initial revision
 *
 */

/**
 * A ShapeException program in Java.
 *
 * @author Tommy Li
 */

public class ShapeException extends java.lang.Exception {

    /**
     * The constructor the passes the message to the superclass.
     * @param message The message that the class will hold.
     */
    public ShapeException(java.lang.String message) {
	super(message);
    }

}
