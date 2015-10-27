/**
 * InsertionSort.java
 *
 * This class implements the insertion sort algorithm to sort an array of Strings.
 *
 * File:
 *	$Id: InsertionSort.java,v 1.0 2015/08/29 11:43:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: InsertionSort.java,v $
 *	Initial revision
 *
 */

/**
 * A insertion sort program in Java.
 *
 * @author Tommy Li
 */

public class InsertionSort {

    /**
     * Method that uses insertion sort to sort an array of Strings.
     *
     * @param data Array of strings to sort.
     */
    public static void sort(String[] data) {
	for (int i = 1; i < data.length; i++) {
	    String s = data[i];
	    int j;
	    for (j = i - 1 ; j >= 0 && data[j].toLowerCase().compareTo(s.toLowerCase()) > 0; j--) {
		data[j + 1] = data[j];
	    }
	    data[j + 1] = s;
	}
    }

}
