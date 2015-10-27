/**
 * BinSet.java
 *
 * This holds a binary searchable data structure.
 *
 * File:
 *	$Id: BinSet.java,v 1.0 2015/10/2 19:28:20 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: BinSet.java,v $
 *	Initial revision
 *
 */

/**
 * A binary searchable data structure.
 *
 * @author Tommy Li
 */


import java.util.*;

public class BinSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> s = new ArrayList<E>();

    /**
     * Constructs an empty BinSet.
     */
    public BinSet(){}

    /**
     * Constructs a BinSet from the given collection.
     * @param c The collection of elements used to build the set.
     */
    public BinSet(Collection<? extends E> c){
        addAll(c);
    }
    
    /**
     * private helper function that implements the binary search
     * Searches for an element using the binary-search algorithm.
     *
     * @param       e     The element the the method searches for in the 
     *                    private ArrayList.
     *
     * @return             An int, either the index of the position of e
     *                     or -1 indicating failure to find e.
     *
     */
    private int binarySearch(E e){
        int low = 0;
        int high = size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (s.get(mid).compareTo(e) == 0) {
                return mid;
	    } else if (s.get(mid).compareTo(e) < 0) {
                high = mid - 1;
	    } else if (s.get(mid).compareTo(e) > 0) {
                low = mid + 1;
	    }
	}
        return -1;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * @param e Element to be added to the set.
     * @return True if this set did not already contain the specified element.
     * @override add in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public boolean add(E e) {
        if (!contains(e)) {
	    s.add(e);
            Collections.sort(s);
            return true;
	}
        return false;
    }

    /**
     * Adds all of the elements in the specified collection 
     * to this set if they're not already present.
     * @param c Collection containing elements to be added to this set.
     * @return True if this set changed as a result of the call.
     * @override addAll in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        Iterator i = c.iterator();
        while (i.hasNext()) {
            if (add((E)i.next())) {
		changed = true;
	    }
	}
        return changed;
    }
    /**
     * Removes all elements from this set.
     * @override clear in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public void clear() {
        s.clear();
    }
     
    /**
     * Returns true if this set contains the specified element. 
     * Note that this method must perform in O(log(n)) time.
     * @param o Element whose presence in this set is to be tested.
     * @return True if this set contained the specified element
     * @override contains in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        return s.contains(o);
    }

    /**
     * Returns true if this set contains all of the elements 
     * of the specified collection.
     * @param c Collection to be checked for containment in this set.
     * @return True if this set contains all of the elements of the specified collection.
     * @override containsAll in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    /**
     * Returns true if the set contains no elements.
     * @return True if this set contains no elements
     * @overrideisEmpty in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public boolean isEmpty() {
        return s.isEmpty();
    }

    /**
     * Returns an iterator over the elements in this set.
     * @return An iterator over the elements in this set.
     * @override iterator in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */        
    public Iterator<E> iterator() {
        return s.iterator();
    }
    
    /**
     * Removes the specified element from this set if it is present.
     * @param o Object to be removed from this set, if present.
     * @return True if this set contained the specified element.
     * @override remove in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public boolean remove(Object o) {
        return s.remove(o);
    }
     
    /**
     * Retains only the elements in this set that are contained 
     * in the specified collection.
     * @param c Collection containing elements to be retained in this set
     * @return True if this set changed as a result of the call
     * @override retainAll in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }
    
    /**
     * Returns the number of elements in this set (its cardinality).
     * @return The number of elements in this set (its cardinality).
     */
    public int size() {
        return s.size();
    }
     

    /**
     * Returns an array containing all of the elements in this set.
     * @return An array containing all the elements in this set
     * @override toArray in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public Object[] toArray() {
        return s.toArray();
    }
     
    /**
     * Returns an array containing all of the elements in this set; 
     *the runtime type of the returned array is that of the specified array.
     * @param a the array into which the elements of this set are to 
     *          be stored, if it is big enough; otherwise, a new array 
     *          of the same runtime type is allocated for this purpose.
     * @return An array containing all the elements in this set
     *
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return s.toArray(a);      
    }

    /**
     * Returns a string representation of the set.
     * @return A string represention of the set.
     * @override toString in class java.util.AbstractCollection<E extends java.lang.Comparable<? super E>>
     */
    public String toString(){
        String arr = "[";
        for (int i = 0; i < size(); i++) {
            if (i != size() - 1) {
		arr += s.get(i) + ", ";
	    } else {
                arr += s.get(i);
	    }
	}
        return arr + "]";
    }


    /**
     * Displays a message followed by success or failure indicating
     * whether or not a particular test was successful.
     *
     * @param message The String form of the message.
     *
     * @param       b    A boolean indicating whether the test was successful 
     *			 or not.    
     *
     */

    private static void resultTest(String message, boolean b){
	if (b){
	    System.out.println(message + " success");
	} else {
	    System.out.println(message + " failure");
	}
    }
    

    /**
     * Runs a suite of tests to validate the implemenation of BinSet
     * for Integer elements.
     *
     */

    private static void testInteger(){
	Set<Integer> set = new BinSet<Integer>(Arrays.asList(1,3));
	
	resultTest("constructor 1",
		   Arrays.equals(set.toArray(), Arrays.asList(1,3).toArray()));
	
	set.add(2);
	resultTest("add 1",
		   Arrays.equals(set.toArray(), 
				 Arrays.asList(1,2,3).toArray()));
	
	resultTest("contains 1", set.contains(1));
	resultTest("contains 2", set.contains(2));
	resultTest("contains 3", set.contains(3));
	resultTest("contains 4", !set.contains(4));
	
	resultTest("size 1", set.size() == 3);
	
	set.clear();
	resultTest("clear/size", set.size() == 0);
	resultTest("clear/isEmpty", set.isEmpty());
	
	set.addAll(Arrays.asList(1,2,3));
	resultTest("addAll 1",set.size() == 3);
	
	resultTest("containsAll 1", set.containsAll(Arrays.asList(3,2)));
	resultTest("containsAll 2", !set.containsAll(Arrays.asList(4,3)));
	
	set.remove(2);
	resultTest("remove 1", 
		   Arrays.equals(set.toArray(), Arrays.asList(1,3).toArray()));
	
	Integer[] a = {1,3};
	int j = 0;
	for (Integer i : set){
	    resultTest("iterator " + i, i.equals(a[j]));
	    j++;
	}
	
	set.retainAll(Arrays.asList(3,4));
	resultTest("retainAll 1", 
		   Arrays.equals(set.toArray(), Arrays.asList(3).toArray()));
	
	resultTest("toArray(array) 1", 
		   Arrays.equals(set.toArray(new Integer[0]), 
				 Arrays.asList(3).toArray()));
    }

    /**
     * The main method for BinSet.  It runs any test scaffolding methods 
     * such as testInteger.
     *
     * @param args Command line arguments are not used.
     *
     */

    public static void main(String[] args){
	testInteger();
   }

}
