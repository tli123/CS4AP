/*
 * Shape.java
 * 
 * Version: 
 *     $Id: Shape.java,v 1.4 2000/12/07 21:36:35 cs2 Exp $
 * 
 * Revisions: 
 *     $Log: Shape.java,v $
 *     Revision 1.4  2000/12/07 21:36:35  cs2
 *     Modified code and comments to meet 20002 style stds
 *
 *
 */

/**
 * Shape is an abstract class to implement a basic shape.
 *
 * @author     Karen A Atkinson
 *
 */

abstract public class Shape extends Object {
    
    private double xPos;    // x position of shape
    private double yPos;    // y position of shape

    /**
     * Construct the shape at the specified position
     *
     * @param    xLoc    x location for shape
     * @param    yLoc    y location for shape
     */

    public Shape( double xLoc, double yLoc ) {
        xPos = xLoc;
        yPos = yLoc;
    }

    /**
     *   Compute the area of the shape.
     *
     *   @return    the area of the shape
     */

    abstract public double area();

    /**
     * Stretches the size of the shape by multiplying
     * each of the dimensions of the shape by the factor
     * provided.  For example, if the factor is .5, then each of
     * the dimensions would be cut in half.
     * 
     * @param    factor    factor to stretch by
     *
     * @exception ShapeException Exception thrown by subclass for negative
     *                           factor.
     */

    abstract public void stretchBy( double factor ) throws ShapeException;

    /**
     * Return the x coordinate of the current location of the shape.
     *
     * @return   x coordinate of the shape
     */

    public final double getXPos() {
	return xPos;
    }

    /**
     * Return the y coordinate of the current location of the shape.
     *
     * @return    y corrdinate of the shape
     */

    public final double getYPos() {
	return yPos;
    }

    /**
     * Move the shape to a new location.
     *
     * @param    xLoc    new X location
     * @param    yLoc    new Y location
     *
     */

    public void moveTo( double xLoc, double yLoc ) {
	xPos = xLoc;
	yPos = yLoc;
    }

    /**
     *  Return a string representation of this shape.
     *
     *  @return a string representation of this shape.
     *
     */

     public String toString() {
         return "Shape";
     }

} // Shape
