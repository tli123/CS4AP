/**
 * Player.java
 *
 * The superclass of all the players. Holds scores and pieces.
 *
 * File:
 *	$Id: Player.java,v 1.0 2015/10/05 17:11:11 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Player.java,v $
 *	Initial revision
 *
 */

/**
 * A player in British Square.
 *
 * @author txl2747
 */


public class Player {

    /**
     * The score for player 1.
     */
    public int score;

    /**
     * The type of piece the player has.
     */
    public String piece;

    /**
     * The type of player. Used for printing purposes.
     */
    public String type;

    //Makes a new instance of the move checker.
    MoveChecker m = new MoveChecker();

    /**
     * The contructor initializes the piece, type, and
     * score of the player.
     * @param piece The type of piece the player has.
     * @param type The type of player.
     */
    public Player(String piece, String type) {
        this.piece = piece;
        this.type = type;
        score = 0;
    }
    /**
     * Updates the score of the player.
     */
    public void updateScore() {
        score++;
    }

    /**
     * Checks if the player has available moves.
     * @param board The game board.
     * @return True if the player has moves left, false otherwise. 
     */
    public boolean movesLeft(String[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
		if (m.legalMove(board, piece, (board.length * i) + j, false)) {
                     return true;
		}
	    }
	}
        return false;
    }
    /**
     * This method "makes" a move by replacing the index of 
     * the space with the piece of the player.
     * @param space The space the player is putting his or her piece at.
     * @param board The game board.
     * @param firstTurn True if it is a first turn.
     * @return The updated game board.
     */
    public String[][] makeMove(int space, String[][] board, boolean firstTurn) {
        //If it is a legal move, change the board and return it, and update score.
        if (m.legalMove(board, piece, space, firstTurn)) {
            board[space / board.length][space - ((space / board.length) * board.length)] = piece;
            updateScore();
            System.out.println("Player places an " + piece + " piece at location: " + space + "\n");
	} else {
	    //Otherwise, make an invalid input and return the original board.
            System.out.print("invalid location: " + space + "\n");
	}
        return board;
    }
    /**
     * Obtains the move of the player. Overriden in
     * subclasses.
     * @param board The game board.
     * @param firstMove True if it is the first move.
     * @return The updated game board.
     */
    public String[][] getMove(String[][] board, boolean firstMove) {
        return board;
    }

}
