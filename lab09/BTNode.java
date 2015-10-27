/**
 * BTNode.java
 *
 * This class holds the node that is to be used in the binary search tree.
 *
 * File:
 *	$Id: BTNode.java,v 1.0 2015/10/23 13:21:11 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: BTNode.java,v $
 *	Initial revision
 *
 */

/**
 * The binary tree node class.
 *
 * @author Tommy Li
 */

public class BTNode<T> {

    /**
     * The left child of the node.
     */
    private BTNode<T> left;

    /**
     * The right child of the node.
     */
    private BTNode<T> right;

    /**
     * The data that is held in the node.
     */
    private T data;

    /**
     * Constructor for building a node with a data element. 
     * The data passed in should be stored, and the left and
     * right children should be set to null.
     * @param data     The data element
     */
    public BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Constructor for building a node where the data element, 
     * and the left and right nodes are all specified.
     * @param data      The data element
     * @param left      The left child.
     * @param right     The right child.
     */
    public BTNode(T data, BTNode<T> left, BTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Accessor for data element.
     * @return The data element.
     */
    public T getData() {
        return data;
    }

    /**
     * Accessor for the left child.
     * @return The left child.
     */
    public BTNode<T> getLeft() {
        return left;
    }

    /**
     * Accessor for the right child.
     * @return The right child.
     */
    public BTNode<T> getRight() {
        return right;
    }

    /**
     * Mutator for the data.
     * @param newData        The new data element.
     */
    public void setData(T newData) {
        data = newData;
    }

    /**
     * Mutator for the left child.
     * @param newLeft        The new left child.
     */
    public void setLeft(BTNode<T> newLeft) {
        left = newLeft;
    }

    /**
     * Mutator for the right child.
     * @param newRight       The new right child.
     */
    public void setRight(BTNode<T> newRight) {
        right = newRight;
    }

    /**
     * Return a string representation of the data element.
     * @return The data element in String form.
     * @override             toString() in class java.lang.Object
     */
    public java.lang.String toString() {
        return data + "";
    }
}
