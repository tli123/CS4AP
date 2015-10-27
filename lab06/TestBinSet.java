/**
 * TestBinSet.java
 *
 * This program tests both Card and BinSet classes.
 *
 * File:
 *	$Id: TestBinSet.java,v 1.0 2015/10/02 19:58:21 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: TestBinSet.java,v $
 *	Initial revision
 *
 */

/**
 * A program tests Card.java and BinSet.java.
 *
 * @author Tommy Li
 */

import java.util.*;

public class TestBinSet {

    /**
     * The main method. Tests BinSet.java and Card.java.
     * @param args Command line arguements. Not used.
     */

    public static void main(String[] args) {
        BinSet<String> b = new BinSet<String>();
        System.out.println(b.add("hi")); //true
        System.out.println(b.add("there")); //true
        System.out.println(b.add("drew")); //true
	System.out.println(b.add("drew")); //false
        System.out.println(b.toString()); //["drew", "hi", "there"]
        Collection<String> c = new ArrayList<String>();
        c.add("thanks");
        c.add("for");
	c.add("grading");
        System.out.println(b.addAll(c)); //true
        c.clear();
        c.add("drew");
        c.add("for");
        c.add("grading");
        System.out.println(b.addAll(c)); //false
        System.out.println(b.toString()); //[drew, for, grading, hi, thanks, there]
        System.out.println(b.isEmpty()); //false;
        b.clear();
        System.out.println(b.isEmpty()); //true
	System.out.println(b.addAll(c)); //true
        System.out.println(b.contains("supercalifragilisticexpialidocious")); //false
	System.out.println(b.contains("grading")); //true
        b.add("blegh");
        System.out.println(b.containsAll(c)); //true
        Collection<String> co = new ArrayList<String>();
        co.add("deiw");
        co.add("ejdow");
        co.add("djiew");
        System.out.println(b.containsAll(co)); //false
        Iterator i = b.iterator();
        while (i.hasNext()) {
	    System.out.print(i.next() + " "); //blegh drew for grading
	}
        System.out.println("\n" + b.size()); //4
        c.clear();
        c.add("drew");
        c.add("for");
        System.out.println(b.retainAll(c)); //true
        System.out.println(b.toString()); //[drew, for]
        System.out.println(b.remove("HIIII")); //false
	System.out.println(b.remove("drew")); //true
        b.addAll(co);
        System.out.println(b.toString()); //[deiw, djiew, edjow, for]
        Object[] arr = b.toArray();
	System.out.println(Arrays.toString(arr)); //[deiw, djiew, edjow, for]
        String[] strArr = new String[b.size()];
        strArr = b.toArray(strArr);
        System.out.println(Arrays.toString(arr)); //[deiw, djiew, edjow, for]

        Card one = new Card(Ranks.THREE, "HEARTS");
        Card two = new Card(Ranks.THREE, "HEARTS");
        Card three = new Card(Ranks.THREE, "CLUBS");
        Card four = new Card(Ranks.QUEEN, "DIAMONDS");
        Card five = new Card(Ranks.DEUCE, "HEARTS");

        System.out.println(one.equals(two)); //true
        System.out.println(one.equals(three)); //false
        System.out.println(one.compareTo(two)); //0
        System.out.println(one.compareTo(three)); // >0
        System.out.println(three.compareTo(two)); // <0
        System.out.println(four.compareTo(one)); // <0
        System.out.println(three.compareTo(four)); // <0
        System.out.println(one.compareTo(five)); // >0
        System.out.println(one.toString()); // THREE OF HEARTS
	System.out.println(two.toString()); // THREE OF HEARTS
	System.out.println(three.toString()); // THREE OF CLUBS
	System.out.println(four.toString()); // QUEEN OF DIAMONDS
	System.out.println(five.toString()); // DEUCE OF HEARTS
    }

}
