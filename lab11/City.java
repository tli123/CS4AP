/**
 * City.java
 *
 * This holds a City, which is the vertex for the graph. Holds the various
 * set and get methods to access its attributes.
 *
 *
 * File:
 *	$Id: City.java,v 1.0 2015/11/03 03:26:22 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: City.java,v $
 *	Initial revision
 *
 */

/**
 * The vertex of the graph, a City.
 *
 * @author Tommy Li
 */

public class City implements Comparable<City> {

    /**
     * The current cost of traveling to this city (when determining 
     * the shortest path).
     */
    private int cost = Integer.MAX_VALUE;

    /**
     * The name of the city.
     */
    private String name;

    /**
     * The city's predecessor (when determining the shortest path).
     */
    private String predecessor = null;

    /**
     * Construct the city with a given name. By default the predecessor 
     * should be null and the cost should be Integer.MAX_VALUE.
     * @param name The name of the city. 
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * Get the name of this city. 
     * @return The city name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this city.
     * @param name The new city's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the predecessor associated with this city.
     * @return The predecessor city.
     */
    public String getPredecessor() {
        return predecessor;
    }

    /**
     * Set the predecessor to the given city.
     * @param predecessor The predecessor city.
     */
    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    /**
     * Get the cost associated with this city.
     * @return The cost to travel to this city.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the cost for a given city.
     * @param cost The cost to travel to this city.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Compares two cities to see how they are ordered. The primary 
     * quantity to compare is cost. If costs are equal, compare the 
     * city names (normal lexicographic ordering).
     * @param other The city this is being compared to.
     * @return An integer whose value is zero if both Cities' costs 
     * and names are equal; negative if this cost is less than the 
     * other cost, or if the costs are equal and if this name is less 
     * than the other name; positive if this cost is greater than the 
     * other cost, or if the costs are equal and if this name is greater 
     * than the other name.
     */
    public int compareTo(City other) {
        if (equals((Object)other)) {
            return 0;
	}
        if (getCost() == other.getCost()) {
            return (getName().compareTo(other.getName()));
	} else {
            return getCost() - other.getCost();
	}
    }
    /**
     * Compares this city to the other object. They are equal if the both 
     * cost's and name's are equal.
     * @return true if both objects are Cities, and they have the same 
     * cost and name; return false otherwise. (non-Javadoc)
     * @override equals in class java.lang.Object
     */
    public boolean equals(Object other) {
        City otherCity = (City)other;
        return (getCost() == otherCity.getCost()) && (getName().compareTo(otherCity.getName()) == 0);
    }

}
