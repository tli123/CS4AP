/*
 * BTNodeTest.java
 *
 * Version:
 *	$Id: BTNodeTest.java,v 1.5 2009/04/04 18:53:28 vcss233 Exp $
 *
 * Revisions: 
 *	$Log: BTNodeTest.java,v $
 *	Revision 1.5  2009/04/04 18:53:28  vcss233
 *	fixed author tag error
 *
 *	Revision 1.4  2009/04/02 18:45:01  vcss233
 *	removed ctor allowing null data reference
 *
 *	Revision 1.3  2006/04/18 21:04:34  vcss233
 *	faculty review changed
 *
 */

/**
 * A test class for the BTNode class.  It tests all the methods of the
 * BTNode class for correctness.
 * 
 * @author Sean Strout
 */
public class BTNodeTest {
	
	/**
 	 * Verifies all contents of a node are correct.  If anything
	 * is wrong it prints an error message to standard error.
 	 *
	 * @param node the node to verify
	 * @param data the expected data value
	 * @param left the expected left node
	 * @param right the expected right node
 	 */
	private static <T> void verifyNode(BTNode<T> node, T data, 
			BTNode<T> left, BTNode<T> right) {
		System.out.println("verifyNode(data=\"" + data + "\", left=\""
				+ left + "\", right=\"" + right + "\")");
		
		if (node.getData() != null && !node.getData().equals(data)) {
			System.err.println("\tgetData() failed.");
		}
		if (node.getLeft() != left) {
			System.err.println("\tgetLeft() failed.");
		}
		if (node.getRight() != right) {
			System.err.println("\tgetRight() failed.");
		}
	} // verifyNode

	
	/**
	 * Main method creates several different BTNode's and verifies
	 * them.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		// test setData
		BTNode<String> empty = new BTNode<String>( "" );
		empty.setData("not-empty");
		verifyNode(empty, "not-empty", null, null);
		
		BTNode<String> left = new BTNode<String>("left");	
		verifyNode(left, "left", null, null);
		
		BTNode<String> right = new BTNode<String>("right");	
		verifyNode(right, "right", null, null);
		
		BTNode<String> parent = 
			new BTNode<String>("parent", left, right);
		verifyNode(parent, "parent", left, right);
		
		BTNode<Integer> intNode = new BTNode<Integer>(10);
		verifyNode(intNode, 10, null, null);
		
	} // main
} // BTNodeTest

