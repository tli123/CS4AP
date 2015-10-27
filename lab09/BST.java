/**
 * BST.java
 *
 * A generic binary search tree which supports insertion, find,
 * inorder traversal, size and height.  The tree uses 
 * BTNode&lt;T&gt; objects as the nodes in the tree.  
 *
 *
 * File:
 *	$Id: BST.java,v 1.0 2015/10/23 13:21:45 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: BST.java,v $
 *	Initial revision
 *
 */

/**
 * A binary search tree program in Java.
 *
 * @author Sean Strout
 * @author Tommy Li
 */
public class BST<T extends Comparable<T>> {
	/** the root node of the tree */
	private BTNode<T> root;		

	/** the number of comparisons performed when finding a node */
	private int numCompares;

	/**
	 * Constructor sets the root of the tree to null and number of
	 * compares to 0.
	 */
	public BST() {
		root = null;
		numCompares = 0;
	} // BST
	
	/**
	 * Accessor for the number of comparison operations performed
	 * in find.  A comparison is defined as a single call to
	 * compareTo on the data element.
	 * 
	 * @return the number comparison operations performed in find
	 */
	public int getNumCompares() {
		return numCompares;
	} // getNumCompares
	
	/**
	 * Resets the comparison counter that is used in the
	 * private find routine to determine the number of 
	 * comparisons operations performed to find an element
	 * in the tree.
	 */
	public void resetNumCompares() {
		numCompares = 0;
	}
	
	/**
	 * Recursively inserts a newNode into the tree as a child of node.
	 * The data in the newnode to be inserted should be compared to the 
	 * data in the current node using the compareTo method.  The result
	 * of this comparison determines which branch the new node will be
	 * inserted in.  If the current node's branch for the new node
	 * is null, it should immediately be inserted, otherwise the routine 
	 * should recurse with the branch node as the current node.  In other
	 * words, the new node can only be inserted as a leaf node in the 
	 * tree.  Also, the BST does not support insertion of duplicate 
	 * elements - it will ignore them.
	 *
	 * @param node the eventual parent node 
	 * @param newNode the new child node, inserted
	 */
	private void insert(BTNode<T> node, BTNode<T> newNode) {
            if (newNode.getData().compareTo(node.getData()) < 0) {
            	if (node.getLeft() == null) {
            	    node.setLeft(newNode);
            	} else {
            	    insert(node.getLeft(), newNode);
            	}
            } else {
            	if (node.getRight() == null) {
            	    node.setRight(newNode)
            	} else {
            	    insert(node.getRight(), newNode);
            	}
            }
	} // private insert

	/**
	 * Public insert routine creates a new node containing the data
	 * and inserts it into the correct position in the tree.  If the tree
	 * is currently empty, the node created here becomes the root node,
	 * otherwise the private insert routine is called with the root
	 * and the node to be inserted.
	 *
	 * @param newData the data element to be inserted as a node
	 */
	public void insert(T newData) {
		BTNode<T> newNode = new BTNode<T>(newData);
		if (root == null) {
			root = newNode;
		} else {
			// call private insertion routine with root
			insert(root, newNode);
		}
	} // public insert
	
	/**
	 * Private routine performs a inorder traversal
	 * of the tree and prints out each node's data.
	 *
	 * @param node current node in the traversal
	 */
	private void inorder(BTNode<T> node) {	
            if (node.getLeft() != null) {
                inorder(node.getLeft());
	    }
            System.out.println(node.toString());
            if (node.getRight() != null) {
                inorder(node.getRight());
	    }
	} // private inorder
	
	/**
	 * Public routine calls the private inorder routine
	 * with the root of the tree.
	 */
	public void inorder() {
	    inorder(root);
	} // public inorder

	/**
	 * Private find routine locates a data element in a tree at
	 * a given node.  If the node is null the element is 
	 * not found.  Otherwise, compare the data to the current node.  
	 * If the elements are equal then it is found, otherwise
	 * recurse with either the left or right child, depending on
	 * the result of the comparison. Remember to increment the 
	 * number of comparison operations on each call to compareTo.
	 *
	 * @param node the current node in the traversal
	 * @param data the data we are looking for
	 * @return true if the data is in the tree, false otherwise
	 */
	private boolean find(BTNode<T> node, T data) {
            if (node == null) {
            	return false;
            } else if (data.compareTo(node.getData()) == 0) {
            	numCompares++;
            	return true;
            }
            numCompares++;
            return data.compareTo(node.getData()) < 0 ? find(node.getLeft(), data) : find(node.getRight(), data);
	} // private find

	/**
	 * Public find routine locates a data element in the tree.  It
	 * should call the private find routine with the root of the 
	 * tree and the element to find.
	 *
	 * @param data the data value to find
	 * @return true if the data is in the tree, false otherwise
	 */
	public boolean find(T data) {
	    return find(root, data);
	}

	/**
	 * Private height routine for finding the height of the tree.  
	 * The height of a tree with no elements is always -1. 
	 * The height of a tree with one element is always 0. 
	 * You must write this routine recursively using this simple definition:  <BR>
	 * If the node is null, the height is -1; <BR>
	 * If the node has no left child and no right child, the height is 0; <BR>
	 * Otherwise, the height is 1 plus the height of the 'tallest' left or right child.
	 *
	 * @param node current node in the height traversal
	 * @return the height of the tree at this node
	 */
	private int height(BTNode<T> node) {
	    if (node == null) {
                return -1;
	    } else if (node.getLeft() == null && node.getRight() == null) {
                return 0;
	    }
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	} // private height

	/**
	 * Public height routine for finding the height of the tree.  This
	 * calls the private height routine with the root of the tree.
	 * The height of a tree with no elements is always -1. 
	 * The height of a tree with one element is always 0. 
	 * The height of a tree with more than one element is always 1
	 * plus the height of the subtree that has the greatest height. 
	 * 
	 * @return the height of the tree at this node
	 */
	public int height() {
	    return height(root);
	} // public height

	/**
	 * Private size routine for determining the number of elements in
	 * the tree.  This routine must be written recursively using this
	 * simple definition:  If the node is null, its size is 0, otherwise
	 * its size is 1 plus the size of the left and right children.
	 *
	 * @param node current node in the traversal
	 * @return the height of the tree at this node
	 */
	private int size(BTNode<T> node) {
            if (node == null) {
                return 0;
	    }
            return 1 + size(node.getLeft()) + size(node.getRight());
	} // private size

	/**
	 * Public size routine for determining the number of elements in 
	 * the tree.  This calls the private size routine with the root of
	 * the tree.
	 * 
	 * @return the height of the tree at this node
	 */
	public int size() {
	    return size(root);
	} // public size
} // BST
