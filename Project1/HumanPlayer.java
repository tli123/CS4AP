/**
 * HumanPlayer.java
 *
 * The class holds the getMove() method for the human player. Extends player.
 *
 * File:
 *	$Id: HumanPlayer.java,v 1.0 2015/10/05 18:45:01 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: HumanPlayer.java,v $
 *	Initial revision
 *
 */

/**
 * A human player in British Square.
 *
 * @author txl2747
 */


import java.util.Scanner;

public class HumanPlayer extends Player {

   /**
    * Creates s new Scanner to use for human input.
    */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Constructor that sends parameters to superclass.
     * @param piece The piece the player has.
     */
    public HumanPlayer(String piece) {
        super(piece, "human");
    }

    /**
     * Gets the move from a human player by using Scanner. If the
     * move is invalid, it forces the player to pick a move until
     * the move chosen is valid.
     * @param board The game board.
     * @return The updated game board.
     */
    public String[][] getMove(String[][] board, boolean firstTurn) {
        //Makes a copy of current board for comparison.
        final String[][] oldBoard = new String[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                oldBoard[i][j] = board[i][j];
	    }
	}
        //Initializes the new board for future use.
        String[][] newBoard = new String[board.length][board.length];
        //Make new instance of Scanner for user input.
        while (true) {
            System.out.print("Player " + piece + ": Enter the location to place your piece (-1 to quit): ");
            int move = sc.nextInt();
            if (move == -1) {
                System.out.print(piece + " quits the game\n");
                System.exit(0);
                break;
	    } else if ((move < -1) || (move >= board.length * board.length)) {
                System.out.print("invalid location: " + move + "\n");
	    } else {
                newBoard = makeMove(move, board, firstTurn);
                boolean equal = true;
                //If old board and new one are not equal, move successful.
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (!oldBoard[i][j].equals(newBoard[i][j])) {
                            equal = false;
	                }	    
	            }
                }
                if (!equal) {
                    break;
	        }
	    } 
	}
        return newBoard;
    }
}
