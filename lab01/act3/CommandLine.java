/**
 * CommandLine.java
 *
 * This class is a program that allows the user to type in a set of data, and 
 * use it to sort and search.
 *
 * File:
 *	$Id: CommandLine.java,v 1.0 2015/08/29 11:50:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: CommandLine.java,v $
 *	Initial revision
 *
 */

/**
 * A binary search program in Java.
 *
 * @author Tommy Li
 */

import java.util.Scanner;

import java.util.NoSuchElementException;

public class CommandLine {

    /**
     * Main Method
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
	System.out.println("**Initial Command Line Arguments");
	for (int i = 0; i < args.length; i++) {
	    System.out.print(args[i] + " ");
	    if (i + 1 == args.length) {
		System.out.println();
	    }
	}
	System.out.println();
	System.out.println("**Sorted Command Line Arguments");
	InsertionSort n = new InsertionSort();
	n.sort(args);
	for (int i = 0; i < args.length; i++) {
	    System.out.print(args[i] + " ");
	    if (i + 1 == args.length) {
		System.out.println();
	    }
	}
	System.out.println();
	Scanner sc = new Scanner(System.in);
	BinarySearch b = new BinarySearch();
	try {
	    while (true) {
		System.out.print("Enter a word to search for (ctrl-d to quit): ");
		String word = sc.nextLine();
		int index = b.search(args, word);
		if (index != -1) {
		    System.out.println("\"" + word.toLowerCase() + "\" was found at index: " + index);
		} else {
		    System.out.println("\"" + word.toLowerCase() + "\" was not found");
		}
	    }
	} catch (NoSuchElementException e) {}
    }
}
