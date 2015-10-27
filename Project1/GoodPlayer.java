/**
 * GoodPlayer.java
 *
 * The class holds the getMove() method for the good player. Extends player.
 *
 * File:
 *	$Id: GoodPlayer.java,v 1.0 2015/10/05 18:37:32 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: GoodPlayer.java,v $
 *	Initial revision
 *
 */

/**
 * A good player in British Square.
 *
 * @author txl2747
 */


public class GoodPlayer extends Player {

    /**
     * Constructor that sends parameters to superclass.
     * @param piece The piece the player has.
     */
    public GoodPlayer(String piece) {
        super(piece, "good");
    }

    /**
     * The good player choses the place where it can block off
     * the most moves from the other player. If there are multiple,
     * there it will chose a random one.
     * @param board The game board.
     * @param firstTurn True if it is a first turn.
     * @return The updated game board.
     */
    public String[][] getMove(String[][] board, boolean firstTurn) {
        int bestMove = 0;
        int maxBlock = 0;
        for (int i = 0; i < board.length * board.length; i++) {
            if (m.legalMove(board, piece, i, firstTurn)) {
                int across = i / board.length;
                int down = i - ((i / board.length) * board.length);
                int block = 0;
                if (across != 0) {
                    if (m.legalMove(board, piece, (board.length * (across - 1) + down), firstTurn)) {
                        block++;
		    }
		}
                if (across != board.length - 1) {
                    if (m.legalMove(board, piece, (board.length * (across + 1) + down), firstTurn)) {
			block++;
		    }
		}
                if (down != 0) {
                    if (m.legalMove(board, piece, (board.length * across + (down - 1)), firstTurn)) {
			block++;
		    }
		}
                if (down != board[across].length - 1) {
                    if (m.legalMove(board, piece, (board.length * across + (down + 1)), firstTurn)) {
			block++;
		    }
		}
		if (block >= maxBlock) {
                    maxBlock = block;
                    bestMove = i;
		}
	    }
	}
        return makeMove(bestMove, board, firstTurn);
    }
}
