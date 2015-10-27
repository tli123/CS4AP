/**
 * BinarySearch.java
 *
 * This class is a basic binary search program that allows for a faster
 * search through a sorted set of data.
 *
 * File:
 *	$Id: BinarySearch.java,v 1.0 2015/08/29 11:01:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: BinarySearch.java,v $
 *	Initial revision
 *
 */

/**
 * A binary search program in Java.
 *
 * @author Tommy Li
 */

public class BinarySearch {

    /**
     * A constant to express when the value is not found in the array.
     */
    public static final int NOT_FOUND = -1;

    /**
     * Method to Binary Search an array of Strings for a specific value.
     *
     * @param data A sorted array of strings.
     * @param value The value being searched for.
     * @returns The index in the array that the value is found, or -1 when it is not found.
     */
    
    public static int search(String[] data, String value) {
	int low = 0;
	int high = data.length - 1;
        while (low <= high) {
	    int midpoint = (low + high)/2;
	    if (value.toLowerCase().compareTo(data[midpoint].toLowerCase()) < 0) {
		high = midpoint - 1;
	    } else if (value.toLowerCase().compareTo(data[midpoint].toLowerCase()) > 0) {
		low = midpoint + 1;
	    } else {
		return midpoint;
	    }
	}
	return NOT_FOUND;		
    }
}
