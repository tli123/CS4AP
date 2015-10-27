/**
 * RandomPlayer.java
 *
 * The class holds the getMove() method for the random player. Extends player.
 *
 * File:
 *	$Id: RandomPlayer.java,v 1.0 2015/10/05 19:22:55 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: RandomPlayer.java,v $
 *	Initial revision
 *
 */

/**
 * A random player in British Square.
 *
 * @author txl2747
 */


import java.util.ArrayList;

public class RandomPlayer extends Player {

    /**
     * Constructor that sends parameters to superclass.
     * @param piece The piece the player has.
     */
    public RandomPlayer(String piece) {
        super(piece, "random");
    }

    /**
     * The random algorithm chooses a random spot until the
     * spot is a legal move. Then, it calls the making move method.
     * An ArrayList keeps check of the moves that the random 
     * player chooses so the same move isn't repeatedly chosen.
     * @param board The game board.
     * @boolean firstTurn True if this is the first turn.
     * @return The updated board.
     */
    public String[][] getMove(String[][] board, boolean firstTurn) {
        int move;
	//Finds all empty spaces
        ArrayList<Integer> movesLeft = new ArrayList<Integer>();
	//ArrayList to hold all the tried moves.
        ArrayList<Integer> pastMoves = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != "X" && board[i][j] != "O") {
                    movesLeft.add(Integer.parseInt(board[i][j]));
		}
	    }
	}
        while (true) {
	    //Finds a random spot on the arraylist and checks if it is legal
            move = movesLeft.get((int)(Math.random() * movesLeft.size()));
            if (!pastMoves.contains(move)) {
                pastMoves.add(move);
                if (m.legalMove(board, piece, move, firstTurn)) {
                    break;
	        }
	    }
	}
        return makeMove(move, board, firstTurn);
    }
}
