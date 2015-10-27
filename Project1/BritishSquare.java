/**
 * BritishSquare.java
 *
 * This class maintains the board and game for British Square.
 *
 * File:
 *	$Id: BritishSquare.java,v 1.0 2015/10/05 18:24:12 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: BritishSquare.java,v $
 *	Initial revision
 *
 */

/**
 * A game of British Square in Java.
 *
 * @author txl2747
 */

public class BritishSquare {

    /**
     * A board representation of the game.
     */
    public String[][] board;

    /**
     * This constructor is run if the user does not specify a
     * a board size. It will run the call the other constructor
     * to initiliaze a board of size 5.
     */
    public BritishSquare() {
        this(5);
    }

    /**
     * This constructor intializes the game board with the given size.
     * @param size The size of the board.
     */
    public BritishSquare(int size) {
        board = new String[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
		board[i][j] = ((board.length * i) + j) + "";
	    }
	}
    }

    /**
     * Returns a String representation of the current game board.
     * @return The String representation of the current game board.
     */
    public String toString() {
        String printedBoard = "";
        String across = "";
        String acrossX = "|XXX";
        String acrossO = "|OOO";
        for (int i = 0; i < board.length; i++) {
            across += "+---";
	}
        across += "+\n";
        for (int i = 0; i < board.length; i++) {
            printedBoard += across;
            String downTop = "";
	    String downBottom = "";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("X")) {
                    downTop += acrossX;
                    downBottom += acrossX;
		} else if (board[i][j].equals("O")) {
                    downTop += acrossO;
                    downBottom += acrossO;
		} else if (board[i][j].length() == 1) {
                    downTop += "|   ";
                    downBottom += "|" + board[i][j] + "  ";
		} else if (board[i][j].length() == 2) {
                    downTop += "|   ";
                    downBottom += "|" + board[i][j] + " ";
		}
	    }
            printedBoard += downTop + "|\n" + downBottom + "|\n";
	}
        return printedBoard + across;
    }

    /**
     * The main method, and where the game is run.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        String message = "Usage: java BritishSquare player-X player-O [brdSize]\nwhere player-X and player-O are one of: human, bad, good, random\n[brdSize] is optional, if provided it must be in the range from: 3 to 7";
	//Checks for bad arguments
        if (args.length < 2 || args.length > 3) {
            System.err.print(message);
            System.exit(0);
	}
        String[] types = {"human", "bad", "good", "random"};
        boolean argOneCheck = false;
        boolean argTwoCheck = false;
        for (int i = 0; i < types.length; i++) {
            if (args[0].equals(types[i])) {
		argOneCheck = true;
	    }
            if (args[1].equals(types[i])) {
		argTwoCheck = true;
	    }
	}
        if (!argOneCheck || !argTwoCheck) {
            System.err.print(message);
            System.exit(0);
	}
        if (args.length == 3) {
            if ((Integer.parseInt(args[2]) < 3) || (Integer.parseInt(args[2]) > 7)) {
                System.err.print(message);
                System.exit(0);
	    }
	}
	//Instantiates the players.
        Player one;
        Player two;
        if (args[0].equals("human")) {
            one = new HumanPlayer("X");
	} else if (args[0].equals("random")) {
            one = new RandomPlayer("X");
	} else if (args[0].equals("bad")) {
            one = new BadPlayer("X");
	} else {
            one = new GoodPlayer("X");
	}
        if (args[1].equals("human")) {
            two = new HumanPlayer("O");
	} else if (args[1].equals("random")) {
            two = new RandomPlayer("O");
	} else if (args[1].equals("bad")) {
            two = new BadPlayer("O");
	} else {
            two = new GoodPlayer("O");
	}
        BritishSquare b;
        if (args.length == 2) {
            b = new BritishSquare();
	} else {
            b = new BritishSquare(Integer.parseInt(args[2]));
	}
	//Booleans to hold if it is the first turn or not.
        boolean firstTurnOne = true;
        boolean firstTurnTwo = true;
        System.out.println("\n" + b.toString());
	while (one.movesLeft(b.board) || two.movesLeft(b.board)) {
	    //Player 1's turn
      	    System.out.println(one.type + " player X moving...");
            if (!one.movesLeft(b.board)) {
                System.out.println("X has no more moves and must skip turn.");
            } else {
                if (firstTurnOne && b.board.length % 2 == 1) {
                    b.board = one.getMove(b.board, firstTurnOne);
                    firstTurnOne = false;
                    System.out.println(b.toString());
    	        } else {
		    b.board = one.getMove(b.board, false);
                    System.out.println(b.toString());
	        }
	    }
            try {
                Thread.sleep(100);
	    } catch (Exception e) {}
	    //Player 2's turn
            if (!one.movesLeft(b.board) && !two.movesLeft(b.board)) {
                break;
            }
            System.out.println(two.type + " player O moving...");
            if (!two.movesLeft(b.board)) {
                System.out.println("O has no more moves and must skip turn.");
            } else {
                if (firstTurnTwo && b.board.length % 2 == 1) {
		    b.board = two.getMove(b.board, firstTurnTwo);
                    firstTurnTwo = false;
                    System.out.println(b.toString());
	        } else {
                    b.board = two.getMove(b.board, false);
                    System.out.println(b.toString());
	        }
            }
            try {
                Thread.sleep(100);
	    } catch (Exception e) {}
	}
	//Game over
        System.out.println("No more legal moves available, the game is over\nFinal Score: X = " + one.score + " : O = " + two.score);
        if (one.score > two.score) {
	    System.out.print("Player X won\n");
	} else if (one.score < two.score) {
            System.out.print("Player O won\n");
	} else {
            System.out.print("Its a tie, no one wins\n");
	}
    }
}
