/**
 * KnapsackN.java
 *
 * A solution to a restricted form of the "knapsack" or "subset sum"
 * problem where you are given a number N and asked if there is a
 * subset of size <em>exactly</em> N whose elements sum to the
 * desired value.
 *
 * File:
 *	$Id: KnapsackN.java,v 1.0 2015/09/18 20:37:55 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: KnapsackN.java,v $
 *	Initial revision
 *
 */

/**
 * @author Tommy Li
 */

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class KnapsackN {

    /**
     * The array that will hold the entire set of numbers.
     */
    private InstrumentedArray a = null;

    /**
     * The array of the indices of the elements currently chosen
     * for summing.
     */
    private int[] choices = null;

    /**
     * The desired sum.
     */
    private int targetSum = 0;

    /**
     * Read a sum and an array of integers. See if
     * a subset of the array elements sum to that value.
     *
     * @param args arg0 is size of subset to pick.
     */
    public static void main( String[] args ) {

/**************************************************************
YOUR CODE GOES HERE.
There are three error messages you must print when needed:

"Usage: java KnapsackN subset-size"
        -- if the number of arguments is wrong

"Subset size is non-positive."
        -- if the command line argument is 0 or less

"Size of input data is less than subset size N"
        -- if the command line argument value (N) is greater than the
        -- number of elements read from standard input.
        -- (This can't be checked until the data has been read in.)

Here are some suggestions as to how to structure this method:

- Get the command line argument.
- Read the first data item as your sum.
- Read the rest of the data and put it in a list. We use a list
-   because we don't know the size of the data set ahead of time.
- Copy the data from the list into an array.
- Create an InstrumentedArray object containing the array.
- Create a Knapsack using the provided parameters.
- Search for a solution.

**************************************************************/

        if (args.length < 1) {
            System.out.print("Usage: java KnapsackN subset-size");
            System.exit(0);
        }
        int setSize = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);    
        int sum = Integer.parseInt(sc.nextLine());
        if (setSize <= 0) {
            System.out.print("Subset size is non-positive.");
            System.exit(0);
        }
        ArrayList<Integer> subSet = new ArrayList<Integer>();
        while (sc.hasNext()) {
            subSet.add(Integer.parseInt(sc.nextLine()));
	}
	if (setSize > subSet.size()) {
            System.out.print("Size of input data is less than subset size N");
            System.exit(0);
        }
        int[] subArray = new int[subSet.size()];
        for (int i = 0; i < subSet.size(); i++) {
            subArray[i] = subSet.get(i);
        }
        InstrumentedArray iArray = new InstrumentedArray(subArray);
        KnapsackN k = new KnapsackN(iArray, sum, setSize);
        boolean success = k.run();
        System.out.println("Total reads: " + k.a.getTotalReads());
        System.out.println("Succesful? " + success);
    }

    /**
     * Create an instance of the Knapsack-N problem.
     *
     * @param candidates the set of data from which a subset will be chosen
     * @param sum the target sum for the data subset
     * @param subsetSize how big the subset must be.
     */
    public KnapsackN( InstrumentedArray candidates, int sum, int subsetSize ) {
        a = candidates;
        targetSum = sum;

        // Initialize the choices array to choose the first N elements
        // of the data array, where N = subsetSize.
        choices = new int[ subsetSize ];
        for ( int i=0; i<subsetSize; ++i ) {
            choices[i] = i;
        }
    }

    /**
     * Compute the next set of choices from the previous. The
     * algorithm tries to increment the index of the final choice
     * first. Should that fail (index goes out of bounds), it
     * tries to increment the next-to-the-last index, and resets
     * the last index to one more than the next-to-the-last.
     * Should this fail the algorithm keeps starting at an earlier
     * choice until it runs off the start of the choice list without
     * Finding a legal set of indices for all the choices.
     *
     * @return true unless all choice sets have been exhausted.
     */
    private boolean nextChoices() {
        for ( int i=choices.length-1; i>=0; --i ) {
            choices[i] += 1;
            for ( int j=i+1; j<choices.length; ++j ) {
                choices[j] = choices[j-1] + 1;
            }
            if ( choices[choices.length-1] < a.size() ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print out the current set of choices. This method is
     * intended to be for debug purposes.
     */
    private void printChoices() {
        System.out.print( "[" );
        for ( int i=0; i<choices.length; ++i ) {
            System.out.print( " " + choices[i] );
        }
        System.out.println( " ]" );
    }

    /**
     * Run the search algorithm by repeatedly getting a new subset
     * and checking to see if the sum matches. <em>This method
     * runs through all possible subsets, even after it finds one
     * that satisfies the desired sum</em>.
     *
     * @return true iff at least one subset yielded the desired sum
     */
    public boolean run() {
        boolean result = false;
/***************************
 Your solution goes here.
***************************/
        while (nextChoices()) {
            if (sum() == targetSum) {
	        result = true;
	    }
	}
        return result;
    }

    /**
     * Sum the chosen elements.
     * The private array choices indicates the indices in the
     * InstrumentedArray a that are to be added up.
     *
     * @return the sum of the chosen elements.
     */
    private int sum() {
        int result = 0;
/***************************
 Your solution goes here.
***************************/
        for (int i : choices) {
            result += a.get(i);
	}
        return result;
    }

}
