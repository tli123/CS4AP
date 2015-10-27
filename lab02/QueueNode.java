/**
 * QueueNode.java
 *
 * The class creates the nodes necesarry to implement the queue.
 *
 * File:
 *	$Id: QueueNode.java,v 1.0 2015/09/12 11:24:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: QueueNode.java,v $
 *	Initial revision
 *
 */

/**
 * A program that creates the nodes and pointers for the LinkedQueue in Java.
 *
 * @author txl2747
 */

public class QueueNode<E> {

    /**
     * Data to be stored in QueueNode.
     */
    private E data;

    /**
     * Self reference to the next node.
     */
    public QueueNode<E> next;

    /**
     * Constuctor that puts data in the Node and initiates next.
     */
    public QueueNode (E datum) {
        data = datum;
        next = null;
    }

    /**
     * Returns the next node in the queue.
     * @returns The next Node.
     */
    public QueueNode<E> getNext() {
        return next;
    }

    /**
     * Retrieves the data in the node.
     * @return The data stored in the node.
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the next node.
     * @param n The node that is being set next.
     */
    public void setNext(QueueNode<E> n) {
        next = n;
    }

    /**
     * Sets the data of the current node.
     * @param data The data being stored in the node.
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns a string containing the data.
     * @return The data stored in the node as a string.
     */
    public String toString() {
        return "" + data;
    }	
}
