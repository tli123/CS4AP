/**
 * MoveChecker.java
 *
 * The class holds the legal move checking methods for the game.
 *
 * File:
 *	$Id: MoveChecker.java,v 1.0 2015/10/05 19:45:18 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: MoveChecker.java,v $
 *	Initial revision
 *
 */

/**
 * A move checking class for British Square in Java.
 *
 * @author txl2747
 */


public class MoveChecker {

    /**
     * This method checks if the move is legal on a specific space.
     * It will call each of the seperate methods that checks if the
     * 4 directions have pieces of the opposing player's.
     * @param board The game board.
     * @param player The player making a move.
     * @param space The space that is being played on.
     * @param firstTurn True if it is a first turn.
     * @return True if it is a legal move, false otherwise.
     */
    public boolean legalMove(String[][] board, String player, int space, boolean firstTurn) {
        if (firstTurn) {
            if (space == ((((board.length - 1) / 2) * board.length) + ((board.length - 1) / 2))) {
		return false;
	    }
	}
        int across = space / board.length;
        int down = space - ((space / board.length) * board.length);
        if (board[across][down].equals("X") || board[across][down].equals("O")) {
            return false;
	}
        String opponent;
        if (player.equals("X")) {
            opponent = "O";
	} else {
            opponent = "X";
	}
        return ((checkLeft(board, opponent, across, down) && checkRight(board, opponent, across, down)) && (checkUp(board, opponent, across, down) && checkDown(board, opponent, across, down)));        
    }

    /**
     * This method checks if the square to the left is occupied by
     * an opponent's piece.
     * @param board The game board.
     * @param opponent The piece of the opponent.
     * @param across The index of the game board across.
     * @param down The index of the game board downward.
     * @return True if the left side has no enemy piece, false otherwise.
     */
    public boolean checkLeft(String[][] board, String opponent, int across, int down) {
        if (across == 0) {
            return true;
	} else {
            return !(board[across - 1][down].equals(opponent));
	}
    }

    /**
     * This method checks if the square to the right is occupied by
     * an opponent's piece.
     * @param board The game board.
     * @param opponent The piece of the opponent.
     * @param across The index of the game board across.
     * @param down The index of the game board downward.
     * @return True if the right side has no enemy piece, false otherwise.
     */
    public boolean checkRight(String[][] board, String opponent, int across, int down) {
        if (across == board.length - 1) {
            return true;
	} else {
            return !(board[across + 1][down].equals(opponent));
	}
    }

    /**
     * This method checks if the upper square is occupied by
     * an opponent's piece.
     * @param board The game board.
     * @param opponent The piece of the opponent.
     * @param across The index of the game board across.
     * @param down The index of the game board downward.
     * @return True if the upper square has no enemy piece, false otherwise.
     */
    public boolean checkUp(String[][] board, String opponent, int across, int down) {
        if (down == 0) {
            return true;
	} else {
            return !(board[across][down - 1].equals(opponent));
	}
    }

    /**
     * This method checks if the lower square is occupied by
     * an opponent's piece.
     * @param board The game board.
     * @param opponent The piece of the opponent.
     * @param across The index of the game board across.
     * @param down The index of the game board downward.
     * @return True if the lower square has no enemy piece, false otherwise.
     */
    public boolean checkDown(String[][] board, String opponent, int across, int down) {
        if (down == board[across].length - 1) {
            return true;
	} else {
            return !(board[across][down + 1].equals(opponent));
	}
    }
}
