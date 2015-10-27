/*
 * Queue.java
 * 
 * Version: 
 *     $Id: Queue.java,v 1.6 2013/09/03 17:23:16 csci140 Exp $
 * 
 * Revisions: 
 *     $Log: Queue.java,v $
 *     Revision 1.6  2013/09/03 17:23:16  csci140
 *     Added insertBefore
 *
 *     Revision 1.5  2013/09/02 19:29:41  csci140
 *     Added removeFrom middle
 *
 *     Revision 1.4  2006/03/14 15:53:00  vcss233
 *     made generic
 *
 *     Revision 1.3  2001/05/09 19:19:51  cs2
 *     specified format for toString.
 *
 *     Revision 1.2  2001/05/09 18:37:13  cs2
 *     Added getSize, toString, and equals as required methods.
 *     Description of toString format is not determined yet.
 *
 *     Revision 1.1  2001/05/09 15:50:02  cs2
 *     Initial revision
 *
 */

/** 
 * An interface for a Queue class
 * 
 * @author Hank Etlinger
 * @author Lois Rixner
 * @author Jeremy Brown
 */

public interface Queue<E> {

    /**
     * Add an object to the end of the queue.
     * 
     * @param newElement The object to be added to the queue.
     */

    public void enqueue( E newElement );

    /**
     * Return the item at the front of the queue without deleting it.
     * 
     * @return the item at the front of the queue
     * 
     * @exception UnderflowException thrown if the queue is empty. 
     *            Message associated with the exception is: 
     *            "LinkedQueue getFront problem"
     */

    public E getFront() throws UnderflowException;

    /**
     * Remove and return the first element in the queue
     * 
     * @return the first element in the queue
     * 
     * @exception UnderflowException thrown if the queue is empty. 
     *            Message associated with the exception is: 
     *            "LinkedQueue dequeue problem"
     */

    public E dequeue() throws UnderflowException;

    /**
    * Removes the given item from the queue.  The item can appear anywhere in the list.
    *    
    * @param itemToRemove The item to be removed from the queue.
    *
    * @return true if the item was removed
    */
    public boolean remove(E itemToRemove);


	/**
	* Inserts an items BEFORE the given item (cut in line)
	* @param itemToInsert The item to be inserted
	* @param insertBefore Which item in the queue the inserted items gets inserted before
    * @return true if we were able to insert the element, false otherwise
	*/
    public boolean insertBefore(E itemToInsert, E insertBefore);

    /**
     * Return the number of elements currently in this queue.
     * 
     * @return the number of elements in this queue.
     */

    public int getSize(); 

    /**
     * Return the state of the queue; return true if the queue is empty, 
     * otherwise return false.
     * 
     * @return true if the queue is empty, otherwise return false.
     */

    public boolean isEmpty();

    /**
     * Throw away all of the items in the queue so that the queue is 
     * once again empty.
     */

    public void makeEmpty();

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
 
    public String toString();

    /**
     * Indicates whether some other object is "equal to" to this one.
     * Two queues are equal if they contain the same number of elements
     * and the elements are in the same order in both queues.
     * 
     * @param other The queue to compare this queue to.
     * 
     * @return true if both objects are the same queue, else return false.
     */

    public boolean equals( Object other );

} // Queue
