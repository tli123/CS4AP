/*
 * HuffmanTree.java
 *
 * Version:
 *   $Id: HuffmanTree.java,v 1.1 2013/10/08 16:00:54 csci140 Exp $
 *
 * Revision:
 *   $Log: HuffmanTree.java,v $
 *   Revision 1.1  2013/10/08 16:00:54  csci140
 *   Initial revision
 *
 *   Revision 1.9  2013/10/03 19:17:22  csci140
 *   made changes to support generics
 *
 *   Revision 1.8  2001/05/07 18:13:37  cs2
 *   Fixed to 20001 style standards
 *
 *   Revision 1.7  2001/02/05 16:23:31  cs2
 *   Removed initial blank line in opening comment.
 *
 *   Revision 1.6  2001/02/05 16:18:16  cs2
 *   Spelling error/typo
 *
 *   Revision 1.5  2001/02/03 22:12:59  cs2
 *   Removed javadoc second * on file comment
 *
 *   Revision 1.4  2001/01/29 23:42:58  cs2
 *   kaa changed header
 *
 */

import java.util.*;

/**
 * This class implements objects that can be used to encode and decode
 * character based files using Huffman encoding.
 *
 * @author     Paul Tymann
 */


public class HuffmanTree implements Comparable<HuffmanTree> {

    // The data associated with each node in the tree

    private char ch;       // in a leaf node contains a character
    private int weight;    // the weight of the node

    // Descendants of this tree

    private HuffmanTree left;
    private HuffmanTree right;

    /**
     * Construct a Huffman tree containing a single node with
     * the given character and weight.
     *
     * @param    myChar    the character stored in this tree
     * @param    myWt      the weight of this node
     */

    public HuffmanTree( char myChar, int myWt ) {
	ch = myChar;
	weight = myWt;

	left = right = null;
    }

    /**
     * Construct a Huffman tree from two existing Huffman
     * trees.  The weight of the new tree is the sum of the
     * weights of the subtrees.  The character value is
     * undefined for non-leaf nodes.
     *
     * @param    lt    the left substree
     * @param    rt    the right subtree
     */

    public HuffmanTree( HuffmanTree lt, HuffmanTree rt ) {
	weight = lt.weight + rt.weight;

	left = lt;
	right = rt;
    }

    /**
     * Create a Huffman tree given a frequency table.  This method
     * can be used to create a Huffman tree to compress or decompress
     * a file once the frequency table has been built.
     *
     * @param    fTable    the frequency table for the file
     *
     * @return   a Huffman tree based on the frequency table
     *           passed as a parameter.
     */

    public static HuffmanTree makeTree( FrequencyTable fTable ) {
	// Working list used to construct the tree

	List<HuffmanTree> fList = new LinkedList<HuffmanTree>();

	// Turn the frequency table into a List of Huffman Trees,
	// where each tree contains a single node that contains a
	// character and its frequency in the file.

	Iterator i = fTable.chars().iterator();

	while ( i.hasNext() ) {
	    char curChar = ( ( Character )i.next() ).charValue();
	    int freq = fTable.getFrequency( curChar );
 
	    fList.add( new HuffmanTree( curChar, freq ) );
	}

	// Build the tree by taking the two smallest trees (here small
	// is defined by the tree with the lowest weight in its root
	// node) and combine them into a tree whose weight is the
	// sum of the weights of its subtrees.  The tree is being
	// built from the leaves up to the root.

	// Each time through this loop, the number of individual trees
	// decreases by one, so stop when there is only one tree
	// remaining.

	while ( fList.size() > 1 ) {
	    // Find the smallest element and remove it from the list

	    HuffmanTree smallest = Collections.min( fList );
	    fList.remove( smallest );

	    // Find the next smallest element and remove it from the list

	    HuffmanTree small = Collections.min( fList );
	    fList.remove( small );

	    // Add to the list a new tree that contains the two
	    // smallest trees as children

	    fList.add( new HuffmanTree( smallest, small ) );
	}

	// The tree is built, return the root.

	return ( HuffmanTree )fList.get( 0 );
    }

    /**
     * Return the translation table associated with this tree.  A translation
     * table is a map whose keys are the characters in the file, and
     * whose elements are bit strings representing the sequence of 0s and
     * 1s that represent the key using Huffman encoding.
     *
     * This method uses the makeTransTbl() method to do the actual tree
     * traversal.
     *
     * @return    a map of characters to bit strings.
     */

    public Map<Character, String> getTranslationTable() {
	Map<Character, String> tTable = new HashMap<Character, String>();

	makeTransTbl( "", tTable );

	return tTable;
    }

    // Recursively traverse the tree.  Add entries to the hashtable
    // when we find each leave of the tree.

    private void makeTransTbl( String prefix, 
			       Map<Character, String> table ) {
	if ( isLeaf() ) {
	    table.put( new Character( ch ), prefix );
	} else {
	    right.makeTransTbl( prefix + "1", table );
	    left.makeTransTbl( prefix + "0", table );
	}
    }    

    /**
     * Return the left child of this tree.
     *
     * @return    the left child of this tree.
     */

    public HuffmanTree getLeft() {
	return left;
    }

    /**
     * Return the right child of this tree.
     *
     * @return    the right child of this tree.
     */

    public HuffmanTree getRight() {
	return right;
    }

    /**
     * Return the character associated with this tree.
     *
     * @return    the character associated with this tree.
     */

    public char getChar() {
	return ch;
    }

    /**
     * Return the weight of this tree.  The weight is defined as the
     * sum of the weights of the subtrees (0 for a leaf).
     *
     * @return    the weight of this tree.
     */

    public int getWeight() {
	return weight;
    }

    /**
     * Return true if this tree is a leaf (i.e., it has no children)
     *
     * @return    true if this tree has no children and false otherwise.
     */

    public boolean isLeaf() {
	return ( left == null ) && ( right == null );
    }

    /**
     * Return true if the weight of this tree is equal to the
     * weight of the specified tree.
     *
     * @param     other    tree to compare.
     *
     * @return    true if the weight of this tree is equal to the given
     *            tree and false otherwise.
     */

    public boolean equals( Object other ) {
	boolean retval = false;

	if ( other != null && other instanceof HuffmanTree ) {
	    retval = weight == ( ( HuffmanTree )other ).weight;
        } 
	return retval;
    }

    /**
     * Compare the weight of this tree to the given tree.  Return -1 if
     * the weight of this tree is less than the given tree, 0 if the
     * weights are equal, and 1 if the weight of this tree is greater
     * than the given tree.
     *
     * @param     other    tree to compare.
     *
     * @return    -1 if the weight of this tree is less than the given tree,
     *            0 if the weights of both trees are equal,
     *            1 if the weight of this tree is greater than the given tree.
     */

    public int compareTo( HuffmanTree other ){
	return weight - other.weight;
    }
/*
    public int compareTo( Object other ) throws ClassCastException {
	return weight - ( ( HuffmanTree )other ).weight;
    }
*/

} // HuffmanTree
 
