/**
 * SnowflakeBinarySearch.java
 *
 * This class uses the Turtle class to draw snowflakes recursively.
 *
 * File:
 *	$Id: Snowflake.java,v 1.0 2015/08/29 11:58:10 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Snowflake.java,v $
 *	Initial revision
 *
 */

/**
 * A snowflake drawing in Java.
 *
 * @author Tommy Li
 */

import java.util.Scanner;

public class Snowflake {

    /**
     * Initializes the graphics.
     *
     * @param S The length of the snowflake side.
     * @returns A Turtle object to draw with.
     */    
    public static Turtle init(int S) {
	double x0 = 75.0;
	double y0 = 25.0;
	double a0 = 60.0;
	Turtle t = new Turtle(x0, y0, a0);
	t.setWorldCoordinates(0, 0, 150, 150);
	return t;
    }

    /**
     * Draw a snowflake side.
     *
     * @param S The length of the snowflake side.
     * @param N The depth of recursion.
     * @param t A Turtle object to draw with.
     */ 
    public static void snowflakeSide(int S, int N, Turtle t) {
	if (N == 1) {
	    t.goForward((double)S);
	} else if (N > 1) {
	    int S3 = S/3;
	    snowflakeSide(S3, N - 1, t);
	    t.turnLeft(60.0);
	    snowflakeSide(S3, N - 1, t);
	    t.turnRight(120.0);
	    snowflakeSide(S3, N - 1, t);
	    t.turnLeft(60.0);
	    snowflakeSide(S3, N - 1, t);
	}
    }

    /**
     * Draw a snowflake.
     *
     * @param S The length of the snowflake side.
     * @param N The depth of recursion.
     * @param t A Turtle object to draw with.
     */ 
    public static void snowflake(int S, int N, Turtle t) {
	t.turnLeft(60.0);
	for (int i = 0; i < 3; i++) {
	    snowflakeSide(S, N, t);
	    t.turnRight(120.0);
	}
    }

    /**
     * The main method receives user inputs and draws a snowflake piece by piece.
     *
     * @param args The command line arguments (unused).
     */ 
    public static void main(String[] args) {
	System.out.println("Enter S: ");
	Scanner sc = new Scanner(System.in);
	int S = sc.nextInt();
	System.out.println("Enter N: ");
	int N = sc.nextInt();
	Snowflake f = new Snowflake();
	Turtle t = f.init(S);
	f.snowflake(S, N, t);	
    }

}
