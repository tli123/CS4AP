/* 
 * TestCircle.java
 *
 * Version:
 *     $Id: TestCircle.java,v 1.6 2001/12/12 13:39:05 cs2 Exp $
 * 
 * Revisions: 
 *     $Log: TestCircle.java,v $
 *     Revision 1.6  2001/12/12 13:39:05  cs2
 *     Style changes -- ptt
 *
 *     Revision 1.5  2001/12/07 13:57:06  cs2
 *     style
 *
 *     Revision 1.4  2000/12/07 21:36:35  cs2
 *     Modified code and comments to meet 20002 style stds
 *
 * 
 */

/**
 * A simple test program to test the exceptions thrown by the Circle class.
 *
 * @author	Jim Vallino
 *
 */

public class TestCircle {

    /**
     * Create Circle objects trying to force exceptions to occur.
     */

    public TestCircle() {
	Circle theCircle;

	// Test the negative radius exception.

	try {
	    theCircle = new Circle( 1.0, 1.0, -2.0 );
	    System.out.println(
    		    "Did not get expected exception after negative radius." );
	} catch( ShapeException e ) {
	    System.out.println( "Exception after negative radius." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

	// Test the negative stretch factor exception

	try {
	    theCircle = new Circle( 1.0, 1.0, 4.0 );

	    theCircle.stretchBy( -3 );
	    System.out.println( "Did not get expected exception after "
                                + "negative stretch." );
	} catch( ShapeException e ) {
	    System.out.println( "Exception after negative stretch factor." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

	// Perform operations that should not generate exceptions.

	try {
	    theCircle = new Circle( 1.0, 1.0, 4.0 );

	    System.out.println( "The circle area is " + theCircle.area() );
	    theCircle.stretchBy( 3 );
	    System.out.println( "After stretching the area is " 
			        + theCircle.area() );
	} catch( ShapeException e ) {
	    System.out.println( "Unexpected exception." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

    }
	
    /**
     * Instantiate a TestCircle object to check the performance of the
     * new ShapeException class.
     *
     * @param args command line arguments (ignored).
     */
    public static void main( String[] args ) {
	TestCircle test;
	test = new TestCircle();
    }
    
} // TestCircle
