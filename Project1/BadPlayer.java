/**
 * BadPlayer.java
 *
 * The class holds the getMove() method for the bad player. Extends player.
 *
 * File:
 *	$Id: BadPlayer.java,v 1.0 2015/10/05 18:32:02 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: BadPlayer.java,v $
 *	Initial revision
 *
 */

/**
 * A bad player in British Square.
 *
 * @author txl2747
 */


public class BadPlayer extends Player {

    /**
     * Constructor that sends parameters to superclass.
     * @param piece The piece the player has.
     */
    public BadPlayer(String piece) {
        super(piece, "bad");
    }   

    /**
     * The bad algorithm describes a bad player who takes the first
     * available spot from left to right, up to down.
     * @param player The player makeing the move.
     * @param firstTurn True if it is a first turn.
     * @return The updated board.
     */
    public String[][] getMove(String[][] board, boolean firstTurn) {
        int move = 0;
        for (int i = 0; i < board.length * board.length; i++) {
            if (m.legalMove(board, piece, i, firstTurn)) {
                move = i;
                break;
	    }
	}
        return makeMove(move, board, firstTurn);
    }
}
