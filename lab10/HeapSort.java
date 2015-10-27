/**
 * HeapSort.java
 *
 * This class holds the main method that is used to heapsort data obtained from
 * a file of numbers.
 *
 * File:
 *	$Id: HeapSort.java,v 1.0 2015/10/27 2:47:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: HeapSort.java,v $
 *	Initial revision
 *
 */

/**
 * The HeapSort in java.
 *
 * @author Tommy Li
 */

import java.util.*;
import java.io.*;

public class HeapSort {


    /**
     * The main method. Holds the HeapSort.
     * @param args The command line arguments.
     * @exception UnderflowException Thrown when removing from an empty heap.
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws UnderflowException {
        if (args.length != 1) {
            System.out.println("Usage: java HeapSort [filename]");
            System.exit(0);
	}
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(args[0]));
	} catch (FileNotFoundException e) {
            System.err.println(args[0] + " not found.");
            System.exit(0);
	}
        Scanner sc = new Scanner(in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        while (sc.hasNext()) {
            arrList.add(sc.nextInt());
	}
        Integer[] intArr = new Integer[arrList.size()];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = arrList.get(i);
	}
        Integer[] emptyArray = new Integer[0];
        TernaryHeap heap = new TernaryHeap(emptyArray);
        for (int i = 0; i < intArr.length; i++) {
            heap.insert(intArr[i]);
	}
        Integer[] sortedArr = new Integer[intArr.length];
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = (Integer)heap.remove();
	}
        System.out.println("Unsorted Array: " + Arrays.toString(intArr));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
    }

}
