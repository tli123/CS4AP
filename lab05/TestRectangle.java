/* 
 * TestRectangle.java
 * 
 * Version: 
 *     $Id: TestRectangle.java,v 1.6 2001/12/12 13:39:05 cs2 Exp $
 * 
 * Revisions: 
 *     $Log: TestRectangle.java,v $
 *     Revision 1.6  2001/12/12 13:39:05  cs2
 *     Style changes -- ptt
 *
 *     Revision 1.5  2000/12/20 19:49:22  cs2
 *     Added @param line to javadoc for main method.
 *
 *     Revision 1.4  2000/12/07 21:36:35  cs2
 *     Modified code and comments to meet 20002 style stds
 *
 *
 */

/**
 * TestRectangle.java
 * <p>
 * A simple test program to test the exceptions thrown by the Rectangle class.
 * <p>
 *
 * @author	Jim Vallino
 *
 */

public class TestRectangle {

    /**
     * Create Rectangle objects trying to force exceptions to occur.
     *
     */
    public TestRectangle() {
	Rectangle theRectangle;

	// Test the negative width/height exception.
	try {
	    theRectangle = new Rectangle( 1.0, 1.0, -2.0, 2.0 );
	    System.out.println(
    	            "Did not get expected exception after negative width." );
	} catch( ShapeException e ) {
	    System.out.println( "Exception after negative width." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

	try {
	    theRectangle = new Rectangle( 1.0, 1.0, 2.0, -2.0 );
	    System.out.println(
		    "Did not get expected exception after negative height." );
	} catch( ShapeException e ) {
	    System.out.println( "Exception after negative height." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

	// Test the negative stretch factor exception
	try {
	    theRectangle = new Rectangle( 1.0, 1.0, 2.0, 2.0 );

	    theRectangle.stretchBy( -3 );
	    System.out.println( "Did not get expected exception after "
                                + "negative stretch." );
	} catch( ShapeException e ) {
	    System.out.println( "Exception after negative stretch factor." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

	// Perform operations that should not generate exceptions.
	try {
	    theRectangle = new Rectangle( 1.0, 1.0, 2.0, 2.0 );

	    System.out.println( "The rectangle area is " 
                                + theRectangle.area() );
	    theRectangle.stretchBy( 3 );
	    System.out.println( "After stretching the area is " 
			        + theRectangle.area() );
	} catch( ShapeException e ) {
	    System.out.println( "Unexpected exception." );
	    System.out.print( "The message text was: " );
	    System.out.println( e.getMessage() );
	}

    }
	
    /**
     * Instantiate a TestRectangle object to check the performance of the
     * new ShapeException class.
     *
     * @param args command line arguments (ignored)
     */

    public static void main( String[] args ) {
	TestRectangle test;
	test = new TestRectangle();
    }
    
} // TestRectangle
