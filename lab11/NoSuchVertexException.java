/*
 * File: $Id: NoSuchVertexException.java,v 1.1 2008/03/25 14:51:58 vcss23x Exp $
 * Revisions:
 *	$Log: NoSuchVertexException.java,v $
 *	Revision 1.1  2008/03/25 14:51:58  vcss23x
 *	Initial revision
 *
 */

/**
 * An exception thrown by a class that implements the DiGraph interface
 * to indicate a problem with the parameters passed to a method.  Note that
 * there is no way to create a NoVertexException that does not contain a
 * message.
 *
 * @author     Paul Tymann
 */
public class NoSuchVertexException extends Exception {

    /**
     * Create a new NoSuchVertexException that contains the specified
     * message.
     *
     * @param msg the message to be placed in the exception.
     */
    public NoSuchVertexException( String msg ) {
    	super( msg );
    }
} // NoSuchVertexException
