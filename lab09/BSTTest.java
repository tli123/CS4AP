/*
 * BSTTest.java
 *
 * Version:
 *      $Id: BSTTest.java,v 1.3 2006/04/18 21:04:34 vcss233 Exp $
 *
 * Revisions: 
 *      $Log: BSTTest.java,v $
 *      Revision 1.3  2006/04/18 21:04:34  vcss233
 *      faculty review changed
 *
 */

import java.util.*;
import java.io.*;

/**
 * A tester class for the BST class.  It reads a series of numbers from
 * a file, and builds a tree.  It then prints out the size and height
 * of the tree respectively.  Next it peforms a inorder traversal
 * of the tree.  Next it prompts the user for input and attempts to
 * find elements in the tree.  Finally, it determines the average
 * number of comparisons it takes to find an element in the tree,
 * by searching for each element.
 */

public class BSTTest {

	/**
	 * The main routine does all the work described above.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		BST<Integer> tree = new BST<Integer>();
		
		if (args.length != 1) {
			System.err.println("Usage: java BSTTest input-file");
			System.exit(0);
		}
		
		// open the input file
		BufferedReader in = null;
		try {
			in = new BufferedReader ( new FileReader (args[0]));
		} catch (FileNotFoundException e) {
			System.err.println(args[0] + " not found.");
			System.exit(0);
		}
		
		List<Integer> numbers = new LinkedList<Integer>();
		Scanner sc = new Scanner(in);
		// read in the values and insert into the tree
		while (sc.hasNext()) {
			int val = sc.nextInt();
			numbers.add(val);	
			tree.insert(val);
		}
		
		// display the number of elements in the tree and its height
		System.out.println("Tree size=" + tree.size());
		System.out.println("Tree height=" + tree.height());
		
		// perform traversals on the tree
		System.out.println("Tree elements inorder:");
		tree.inorder();
		
		// find user elements in the tree
		sc = new Scanner(System.in);
		System.out.print("Enter element to find (ctrl-d to exit): ");
		while (sc.hasNext()) {
			int element = sc.nextInt();
			System.out.print(element + (tree.find(element) ? 
					" found. " : " not found. "));
			System.out.println("Number of comparisons = " + 
					tree.getNumCompares());
			tree.resetNumCompares();
			System.out.print("Enter element to find (ctrl-d to exit): ");
		}
		System.out.println("\nUser input done.");
	
		// find the average number of searches for all elements in the
		// collection
		tree.resetNumCompares();
		System.out.println("Searching for every element in the tree.");
		for (Integer i : numbers) {
			tree.find(i);
		}
		
		int numCompares = tree.getNumCompares();
		System.out.println("Total number of comparisons = " +
				numCompares);
		System.out.println("Average number of comparisons = " + 
				(float)numCompares / numbers.size());
	}

}

