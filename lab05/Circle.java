/**
 * Circle.java
 *
 * This class is now completed with the exception handlers that the previous circle class did not have.
 *
 * File:
 *	$Id: Circle.java,v 1.0 2015/09/25 16:21:21 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Circle.java,v $
 *	Initial revision
 *
 */

/**
 * A circle implementation program in Java.
 *
 * @author Tommy Li
 */

import java.lang.*;

public class Circle extends Shape {

    private double radius;    // the radius of the circle
    
    /**
     * Create a new circle.
     *
     * @param    myXPos    x location for center of the circle
     * @param    myYPos    y location for center of the circle
     * @param    myRadius  radius of the circle
     *
     * @exception  ShapeException  Exception is thrown when the radius is
     *                             a negative value.  "Negative radius in
     *                             Circle constructor"
     */

    public Circle( double myXPos, double myYPos, double myRadius ) throws ShapeException {
        super( myXPos, myYPos );
        if (myRadius < 0) {
            throw new ShapeException("Negative radius in Circle constructor");
	} else {
            radius = myRadius;
	}
    }

    /**
     * Return the radius of the circle.
     *
     * @return    radius of the circle
     */

    public double getRadius() {
	return radius;
    }

    /**
     * Compute and return the area of the circle.
     *
     * @return    the area of the circle
     */

    public double area() {
	return Math.PI * radius * radius;
    }

    /**
     * Stretches the size of the circle by multiplying
     * the radius by the factor provided.
     *
     * @param    factor    factor to stretch by
     *
     * @exception ShapeException Exception is thrown when a negative
     *                           factor parameter is received.
     *                           "Negative factor in call to stretchBy"
     */

    public void stretchBy( double factor ) throws ShapeException {
        if (factor < 0) {
            throw new ShapeException("Negative factor in call to stretchBy");
	} else {
	    radius = radius * factor;
	}
    }

    /**
     * Return a string representation of a circle.
     *
     * @return    a string representing this circle
     */

    public String toString() {
	return "Circle";
    }

} // Circle
