/**
 * LinkedQueueTest.java
 *
 * The class contains a series of tests to test the LinkedQueue class.
 *
 * File:
 *	$Id: LinkedQueueTest.java,v 1.0 2015/09/12 12:50:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: LinkedQueueTest.java,v $
 *	Initial revision
 *
 */

/**
 * A main program to test LinkedQueue.java.
 *
 * @author txl2747
 */

public class LinkedQueueTest {

    /**
     * @param args Not used.
     * @exception UnderflowException thrown if the queue is empty. 
     */
    public static void main(String[] args) throws UnderflowException {
        LinkedQueue<Integer> l = new LinkedQueue<Integer>(5);
        l.enqueue(7);
        l.enqueue(9);
        l.enqueue(10);
        l.enqueue(39);
        System.out.println(l.toString()); //5 7 9 10 39
        System.out.println(l.dequeue()); //5
        System.out.println(l.dequeue()); //7	
        System.out.println(l.dequeue()); //9
        System.out.println(l.toString()); //10 39
        System.out.println(l.getFront()); //10
        l.enqueue(2);
        l.enqueue(4);
        l.enqueue(8);
        System.out.println(l.toString()); //10 39 2 4 8
        System.out.println(l.getSize()); //5
        System.out.println(l.isEmpty()); //false
        System.out.println(l.insertBefore(0, 2)); //true
        System.out.println(l.toString()); //10 39 0 2 4 8
        System.out.println(l.remove(322)); //false
        System.out.println(l.remove(39)); //true
        System.out.println(l.toString()); //10 0 2 4 8
        System.out.println(l.remove(8)); //true
        System.out.println(l.toString()); //10 0 2 4
        l.makeEmpty();
        System.out.println(l.isEmpty()); //true 
        System.out.println(l.getSize()); //0

        LinkedQueue<String> s = new LinkedQueue<String>("hi");
        LinkedQueue<String> es = new LinkedQueue<String>("hi");
        LinkedQueue<String> us = new LinkedQueue<String>("nohi");

        s.enqueue("drew");
        es.enqueue("drew");
        s.enqueue("thanks");
        es.enqueue("thanks");
        s.enqueue("for");
        es.enqueue("for");
        s.enqueue("grading");
        es.enqueue("grading");
        us.enqueue("nodrew");
        us.enqueue("nothanks");
        us.enqueue("nofor");
        us.enqueue("nograding");

        System.out.println(s.equals(es)); //true
        System.out.println(s.equals(us)); //false

        System.out.println(s.dequeue()); //grading
        System.out.println(s.equals(es)); //false
        System.out.println(s.dequeue()); //for
        System.out.println(s.dequeue()); //drew
        System.out.println(s.dequeue()); //thanks
        System.out.println(s.dequeue()); //hi
        System.out.println(s.dequeue()); //exception
    }
}
