/**
 * Road.java
 *
 * Holds the various attributes and get and set methods to access these
 * private attributes. Acts as the edge of the graph. 
 *
 *
 * File:
 *	$Id: Road.java,v 1.0 2015/11/03 03:12:32 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Road.java,v $
 *	Initial revision
 *
 */

/**
 * The road - the edge of the graph.
 *
 * @author Tommy Li
 */

public class Road {

    /**
     * The length of this road segment, for example: 72 miles.
     */
    private int length;

    /**
     * The name of the road segment, for example: "I90".
     */
    private String road;

    /**
     * Constructs a Road object.
     * @param length Road length.
     * @param road Road name.
     */
    public Road(int length, String road) {
        this.length = length;
        this.road = road;
    }
    /**
     * Get the road length.
     * @return Road length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Set the road length.
     * @param length The new length for the road.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Get the road name.
     * @return Road name.
     */
    public String getRoad() {
        return road;
    }

    /**
     * Set the road name.
     * @param road The new name for the road.
     */
    public void setRoad(String road) {
        this.road = road;
    }


}
