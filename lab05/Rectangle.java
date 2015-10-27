/**
 * Rectangle.java
 *
 * This class has the exception handlers that the original rectangle class did not have.
 *
 * File:
 *	$Id: Rectangle.java,v 1.0 2015/09/25 15:28:30 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Rectangle.java,v $
 *	Initial revision
 *
 */

/**
 * A rectangle implementation program in Java.
 *
 * @author Tommy Li
 */
import java.lang.*;

public class Rectangle extends Shape {

    private double width;     // the width of the rectangle
    private double height;    // the height of the rectangle
    
    /**
     * @param    myXPos    x location for center of the rectangle
     * @param    myYPos    y location for center of the rectangle
     * @param    myWidth   width of the rectangle
     * @param    myHeight  height of the rectangle
     * @throws   ShapeException  Thrown when the constructor is called 
     *           with a negative width or height parameter ("Invalid 
     *           parameter in Rectangle constructor").
     */

    public Rectangle( double myXPos, double myYPos, double myWidth, 
                      double myHeight ) throws ShapeException {
	super( myXPos, myYPos );
        if ((myWidth < 0) || (myHeight < 0)) {
	    throw new ShapeException("Invalid parameter in Rectangle constructor");
	} else {
	    width = myWidth;
	    height = myHeight;
	}
    }

    /**
     * Return the width of the rectangle.
     *
     * @return    width of the rectangle
     */

    public double getWidth() {
	return width;
    }

    /**
     * Return the height of the rectangle.
     *
     * @return    height of the rectangle
     */

    public double getHeight() {
        return height;
    }

    /**
     * Compute and return the area of the rectangle.
     *
     * @return    the area of the rectangle
     */

    public double area() {
	return width * height;
    }

    /**
     * Stretches the size of the rectangle by multiplying
     * the width and the height by the factor provided.
     *
     * @param    factor    factor to stretch by
     * @throws   ShapeException   Thrown when a negative factor is 
     *           specified as a parameter to the stretchBy method 
     *           ("Negative factor in call to stretchBy") Zero is 
     *           not a negative number.
     */

    public void stretchBy ( double factor ) throws ShapeException {
        if (factor < 0) {
            throw new ShapeException("Negative factor in call to stretchBy");
	} else {
	    width = width * factor;
            height = height * factor;
	}
    }

    /**
     * Return a string representation of a rectangle.
     *
     * @return    a string representing this rectangle.
     *
     */

    public String toString() {
	return "Rectangle";
    }

} // Rectangle
