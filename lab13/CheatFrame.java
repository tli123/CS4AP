/**
 * CheatFrame.java
 *
 * Holds the cheat board, which has the solution for the puzzle.
 *
 *
 * File:
 *	$Id: CheatFrame.java,v 1.0 2015/11/19 01:26:18 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: CheatFrame.java,v $
 *	Initial revision
 *
 */

/**
 * The cheatframe for the game.
 *
 * @author Tommy Li
 */

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class CheatFrame extends JFrame {

    /**
     * Constructs a CheatFrame object.
     * @param cardButtons - An ArrayList of CardButtons that are 
     *                      all showing their numbers.
     * @param size - The size (of one side) of the board (measured 
     *               in cards).
     */
    public CheatFrame(ArrayList<CardButton> cardButtons, int size) {
        super("Cheat Concentration Game");
        this.getContentPane().setLayout(new GridLayout(size, size));
        for (CardButton card : cardButtons) {
	    this.add(card);
	}
        this.setSize(300, 300);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
