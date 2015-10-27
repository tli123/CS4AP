/**
 * InstrumentedArray.java
 *
 * This class features an array in which the number of reads is recorded.
 *
 * File:
 *	$Id: InstrumentedArray.java,v 1.0 2015/09/18 20:30:14 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: InstrumentedArray.java,v $
 *	Initial revision
 *
 */

/**
 * @author Tommy Li
 */

public class InstrumentedArray {

    /**
     * The number of reads made.
     */
    private int totalReads;

    /**
     * The instrumented array.
     */
    public int[] intArray;

    /**
     * Creates an instrumented array containing Integers.
     * The object contains a native array of the same size.
     * @param size The number of integers in the array.
     * @postcondition The get count is initialized to 0. 
     */
    public InstrumentedArray(int size) {
        intArray = new int[size];
        totalReads = 0;
    }

    /** Creates an instrumented array containing Integers 
     * from an existing native array. No data is copied.
     * @param data The native array to be used.
     */
    public InstrumentedArray(int[] data) {
        intArray = data;
        totalReads = 0;
    }

    /**
     * Get the values of one of the array's elements.
     * @param data The index of the desired element.
     * @return The value of the desired element.
     * @throws ArrayIndexOutOfBoundsException If an invalid index is specified.
     * @precondition 0 <= index <= size()
     * @postcondition The get count is incremented by 1.
     */
    public int get(int index) throws ArrayIndexOutOfBoundsException {
        if ((index < 0 ) || (size() <= index)) {
            throw new ArrayIndexOutOfBoundsException("Array out of bounds.");
	} else {
            totalReads++;
            return intArray[index];
	}
    }

    /**
     * Change the value of one of this array's elements.
     * @param index The index of the elements to be changed.
     * @param value The new integer value for the element.
     * @precondition 0 <= index <= size()
     * @postcondition The get count is <i>not</i> incremented.
     */
    public void put(int index, int value) {
        if ((0 <= index) && (index < intArray.length)) {
            intArray[index] = value;
	}
    }

    /**
     * Find out how many element reads have been performed on this array.
     * @returns The current number of reads.
     */
    public int getTotalReads() {
        return totalReads;
    }

    /**
     * Find the size of the array.
     * @return The number of elements in this array.
     */
    public int size() {
        return intArray.length;
    }

    /**
     * Finds if the value is in the array. If not, return false.
     * @param value The value to be found.
     * @return true if found, false otherwise
     */
    public boolean search(int value) {
        totalReads++;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == value) {
                return true;
	    }
	}
        return false;
    }
    /**
     * Finds the maximum value in the array.
     * @return The max value in the array.
     */
    public int maxVal() {
        int maxNum = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            maxNum = Math.max(maxNum, intArray[i]);
	}
        totalReads++;
        return maxNum; 
    }

    /**
     * The main method.
     * @param args Command line arguments. Not used.
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        InstrumentedArray i = new InstrumentedArray(4);
        i.put(0, 3);
	i.put(1, 4);
        i.put(2, 9);
        i.put(3, 1);
        System.out.println(i.size()); //4
        System.out.println(i.maxVal()); //9
        System.out.println(i.search(12)); //false
        System.out.println(i.getTotalReads()); //2
        System.out.println(i.get(3)); //
        i.put(0, 12);
        System.out.println(i.maxVal()); //12
	System.out.println(i.getTotalReads()); //4
    }
}
