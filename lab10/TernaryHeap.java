/**
 * TernaryHeap.java
 *
 * This class holds the heap, as well as methods for inserting and removing.
 * This heap has 3 children per parent.
 *
 * File:
 *	$Id: TernaryHeap.java,v 1.0 2015/10/27 2:50:32 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: TernaryHeap.java,v $
 *	Initial revision
 *
 */

/**
 * The ternary heap in java.
 *
 * @author Tommy Li
 */

public class TernaryHeap<E extends java.lang.Comparable<E>> {

    /**
     * Holds the heap.
     */
    private E[] heapArr;

    /**
     * Holds the current number of elements in the heap.
     */
    private int size = 0;

    /**
     * Constructor of an empty heap.
     * @param init An empty array of the appropriate type, large 
     * enough to hold the heap at all times.
     */
    public TernaryHeap(E[] init) {
        heapArr = init;
        size = 0;
    }

    /**
     * Returns the number of items in the heap.
     * @return Size of the heap.
     */
    public int size() {
        return size;
    }

    /**
     * Make sure the heap array is large enough before inserting
     * an element. If it is too small, it will enlarge the size.
     */
    @SuppressWarnings("unchecked")
    private void checkSize() {
        if (size() == heapArr.length) {
            E[] tempHeapArr = (E[])new Comparable[heapArr.length + 3];
            for (int i = 0; i < heapArr.length; i++) {
                tempHeapArr[i] = heapArr[i];
	    }
            heapArr = tempHeapArr;
	}
    }

    /**
     * Inserts an item into the heap.
     * @param item To insert.
     */
    public void insert(E item) {
        checkSize();
        heapArr[size++] = item;
        siftUp(size() - 1);
    }

    /**
     * When adding a new node, this private helper will
     * start to sift the node upward so the properties 
     * of the heap are maintained.
     * @param index The index of the element being sifted up.
     */
    private void siftUp(int index) {
        if (index > 0) {
            int parent = (index - 1) / 3;
            if (heapArr[parent].compareTo(heapArr[index]) > 0) {
                swap(parent, index);
                siftUp(parent);
	    }
	}
    }


    /**
     * Remove and return the item at the root of the heap.
     * @return The smallesy item in the heap.
     * @exception UnderflowException Thrown when the heap is empty.
     */
    public E remove() throws UnderflowException {
        if (size() == 0) {
            throw new UnderflowException("The heap is empty.");
	} else {
            E data = heapArr[0];
            size--;
            swap(0, size);
            siftDown(0);
            return data;
	}
    }

    /**
     * Sifts an element down so the heap's properties are preserved.
     * @param index The index to start sifting down at.
     */
    private void siftDown(int index) {
        if (index < size()) {
            int firstChild = 3 * index + 1;
            E min = null;
            int minPos = firstChild; 
            if (firstChild < size()) {
                min = heapArr[firstChild];
                if (firstChild + 1 < size()) {
                    if (heapArr[minPos].compareTo(heapArr[firstChild + 1]) > 0) {
                        min = heapArr[firstChild + 1];	
                        minPos = firstChild + 1;
		    }
		}
                if (firstChild + 2 < size()) {
                    if (heapArr[minPos].compareTo(heapArr[firstChild + 2]) > 0) {
                        min = heapArr[firstChild + 2];			
                        minPos = firstChild + 2;
		    }
		}
	    }
            if (min != null && heapArr[index].compareTo(min) > 0) {
                swap(index, minPos);
                siftDown(minPos);
	    }
	}        
    }

    /**
     * Swaps two elements in the arrsy.
     * @param indexOne Index to switch.
     * @param indexTwo Index to switch.
     */
    private void swap(int indexOne, int indexTwo) {
        E tmp = heapArr[indexOne];
        heapArr[indexOne] = heapArr[indexTwo];
        heapArr[indexTwo] = tmp;
    }

    /**
     * Returns the String representation of the heap for testing. 
     * This consists of each element's String representation on a line 
     * by itself, in order reading across each level of the heap from 
     * top to bottom.
     * @return The String representation of the heap.
     * @override toString in class java.lang.Object.
     */
    public java.lang.String toString() {
        String heap = "";
        for (int i = 0; i < size() - 1; i++) {
            heap += heapArr[i] + "\n";
	}
        if (size() != 0) {
            heap += heapArr[size() - 1];
	}
        return heap;
    }
}
