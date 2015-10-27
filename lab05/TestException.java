/*
 * TestException.java
 * 
 * Version: 
 *     $Id: TestException.java,v 1.11 2000/12/20 19:51:07 cs2 Exp $
 * 
 * Revisions: 
 *     $Log: TestException.java,v $
 *     Revision 1.11  2000/12/20 19:51:07  cs2
 *     *** empty log message ***
 *
 *     Revision 1.10  2000/12/20 19:47:09  cs2
 *     Fixed to match coding standards
 *
 *     Revision 1.9  2000/12/14 13:28:03  cs2
 *     Put the error messages back to "out" - I think it was done this
 *     way for the try testing.....
 *
 *     Revision 1.8  2000/12/14 13:21:49  cs2
 *     Made the error messages go to std error.
 *
 *     Revision 1.7  2000/12/07 21:36:35  cs2
 *     Modified code and comments to meet 20002 style stds
 *
 *
 */

import java.lang.*;

/**
 * A class to test the definition of ShapeException in CS 2 lab 3
 * activity 1.
 *
 * @author	Jim Vallino
 *
 */

public class TestException {
    
    /**
     * The constructor - invokes a method where an exception occurs 
     * and catches it
     *
     */

    public TestException() {
	try {
	    methodA();
        }
        catch( ShapeException e ) {
	    System.out.println( "ShapeException caught" );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}
    }

    /**
     * Throw a ShapeException so that we can catch it
     *
     * @exception ShapeException always thrown "exception thrown in methodA"
     */

    public void methodA() throws ShapeException {
	throw new ShapeException( "exception thrown in methodA" );
    }

    /**
     * A driver program to test student's ShapeException class
     *
     * @param args command line arguments (ignored)
     */

    public static void main( String[] args ) {
	TestException test = new TestException();
    }
    
} // TestException
