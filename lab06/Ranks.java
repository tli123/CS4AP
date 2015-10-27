/*
 * Ranks.java
 *
 * Version:
 * $Id: Ranks.java,v 1.1 2013/09/19 18:32:14 csci140 Exp $
 *
 * Revisions:
 * $Log: Ranks.java,v $
 * Revision 1.1  2013/09/19 18:32:14  csci140
 * Initial revision
 *
 */

/**
 * An enum representing the ranks in a normal poker deck
 *
 * @author paw: Phil White
 */

public enum Ranks { 
    DEUCE( " 2", 2 ), 
    THREE( " 3", 3 ), 
    FOUR ( " 4", 4 ), 
    FIVE ( " 5", 5 ),
    SIX  ( " 6", 6 ), 
    SEVEN( " 7", 7 ), 
    EIGHT( " 8", 8 ), 
    NINE ( " 9", 9 ), 
    TEN  ( "10", 10 ), 
    JACK ( " J", 11 ), 
    QUEEN( " Q", 12 ), 
    KING ( " K", 13 ), 
    ACE  ( " A", 14 );

   /**
    * a constant for the total number of ranks
    */
    public static final int NUM_RANKS = 13;
    private final String shortName;
    private final int value;

   /**
    * initialize the ranks enums,
    *
    * @param    n       short name for the ranks
    * @param    v       the value of the rank
    */
    Ranks( String n, int v ){
        shortName = n;
	value = v;
    }

   /**
    * accessor for the name
    *
    * @return   a string with the short name for this ranks
    */
    public String getShortName(){
        return shortName;
    }

   /**
    * accessor for the value
    *
    * @return   an int for the value of the rank
    */
    public int getValue(){
        return value;
    }
}
