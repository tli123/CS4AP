/**
 * LinkedQueue.java
 *
 * The class creates and manages a linkedlist queue of generics.
 *
 * File:
 *	$Id: LinkedQueue.java,v 1.0 2015/09/12 12:34:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: LinkedQueue.java,v $
 *	Initial revision
 *
 */

/**
 * A queue data type program in Java.
 *
 * @author txl2747
 */


public class LinkedQueue<E> implements Queue<E> {

    /**
     * The start of the queue.
     */
    private QueueNode<E> head;

    /**
     * Number of elements in the queue.
     */
    private int count = 0;

    /**
     * Constructor that sets the value of the head node.
     * @param data The value that the head node is to be set to.
     */
    public LinkedQueue(E data) {
        head = new QueueNode<E>(data);
        count++;
    }

    /**
     * Returns the start of the queue.
     * @return The start node of the queue.
     */
    public QueueNode<E> getHead() {
        return head;
    }
    
    /**
     * Remove and return the first element in the queue
     * 
     * @return the first element in the queue
     * 
     * @exception UnderflowException thrown if the queue is empty. 
     *            Message associated with the exception is: 
     *            "LinkedQueue dequeue problem"
     */
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("LinkedQueue dequeue problem");
        } else {
            E data = head.getData();
            head = head.getNext();
            count--;
            return data;
        }
    }
    
    /**
     * Add an object to the end of the queue.
     * 
     * @param newElement The object to be added to the queue.
     */
    public void enqueue(E newElement) {
        QueueNode<E> add = new QueueNode<E>(newElement);
        QueueNode<E> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(add);
        count++;
    }
    
   
    /**
     * Return the item at the front of the queue without deleting it.
     * 
     * @return the item at the front of the queue
     * 
     * @exception UnderflowException thrown if the queue is empty. 
     *            Message associated with the exception is: 
     *            "LinkedQueue getFront problem"
     */
    public E getFront() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("LinkedQueue getFront problem");
        } else {
            return head.getData();
        }
    }
    
    /**
     * Return the number of elements currently in this queue.
     * 
     * @return the number of elements in this queue.
     */
    public int getSize() {
        return count;
    }    

    /**
     * Inserts an items BEFORE the given item (cut in line)
     * @param itemToInsert The item to be inserted
     * @param insertBefore Which item in the queue the inserted items gets inserted before
     * @return true if we were able to insert the element, false otherwise
     */
    public boolean insertBefore(E itemToInsert, E insertBefore) {
        for (QueueNode<E> tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) {
            if (tmp.getNext().getData().equals(insertBefore)) {
                QueueNode<E> tmp2 = tmp.getNext();
                tmp.setNext(new QueueNode<E>(itemToInsert));
                tmp.getNext().setNext(tmp2);
                count++;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return the state of the queue; return true if the queue is empty, 
     * otherwise return false.
     * 
     * @return true if the queue is empty, otherwise return false.
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * Throw away all of the items in the queue so that the queue is 
     * once again empty.
     */
    public void makeEmpty() {
        head = null;
        count = 0;
    }
    
    /**
     * Removes the given item from the queue.  The item can appear anywhere in the list.
     *    
     * @param itemToRemove The item to be removed from the queue.
     *
     * @return true if the item was removed
     */
    public boolean remove(E itemToRemove) {
        for (QueueNode<E> tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) {
            if (tmp.getNext().getData().equals(itemToRemove)) {
                tmp.setNext(tmp.getNext().getNext());
                count--;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return a String representation of the contents of this queue.
     * The format of the String should be each element should be on a 
     * separate line and followed by the newline character. For example
     * if a queue contains the three elements 10, 20, 30, toString should
     * return a String: 
     * <br>
     * 10
     * <br>
     * 20
     * <br>
     * 30
     * <br>
     * Note: there should be a newline character after the last element, 
     * in this case the 30. 
     *  
     * @return String representation of this queue.
     */
    public String toString() {
        String s = "";
        for (QueueNode<E> tmp = head; tmp != null; tmp = tmp.getNext()) {
            s += tmp.getData() + "\n\n";
        }
        return s;
    }


     /**
     * Indicates whether some other object is "equal to" to this one.
     * Two queues are equal if they contain the same number of elements
     * and the elements are in the same order in both queues.
     * 
     * @param other The queue to compare this queue to.
     * 
     * @return true if both objects are the same queue, else return false.
     */
    public boolean equals(Object other) {	
        QueueNode<E> thisOne = this.getHead();
        LinkedQueue<E> that = (LinkedQueue<E>)other;
        QueueNode<E> otherOne = that.getHead();
        while ((thisOne != null) || (otherOne != null)) {
            if (!thisOne.getData().equals(otherOne.getData())) {
                return false;
            }
            thisOne = thisOne.getNext();
            otherOne = otherOne.getNext();
        }
        if ((thisOne != null) || (otherOne != null)) {
            return false;
        }
        return true;
    }
}
