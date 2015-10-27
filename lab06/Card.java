/**
 * Card.java
 *
 * This holds a Card with a rank and a suit.
 *
 * File:
 *	$Id: Card.java,v 1.0 2015/10/02 19:55:14 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Card.java,v $
 *	Initial revision
 *
 */

/**
 * A program that holds a card.
 *
 * @author Tommy Li
 */

public class Card implements java.lang.Comparable<Card>{

    /**
     * The rank of this card (Ace, 1, 2, etc)
     */
    public Ranks rank;

    /**
     * The suit of this card (Heart, Diamond, Spade, Club)
     */
    public java.lang.String suit;

    /**
     * Initializes the rank and suit of the card.
     * @param r The rank of the card.
     * @param s The suit of the card.
     */
    public Card(Ranks r, java.lang.String s) {
        rank = r;
        suit = s;
    }

    /**
     * Returns a string representation of the card.
     * @return A string representation of the card.
     */
    public String toString() {
        return rank.values()[rank.getValue() - 2] + " OF " + suit;
    }

    /**
     * Checks if two cards are equal.
     * @param c The card this card is being compared to.
     * @return True if they are equal, false otherwise.
     */

    public boolean equals(Object o) {
        Card c = (Card)o;
        return (this.suit.equals(c.suit) && this.rank.getShortName().equals(c.rank.getShortName()));
    }

    /**
     * Compares two cards, first by suit, then value.
     * @param c The card this card is being compared to.
     * @return 0 if they are equal, a negative value if
     *         this card is smaller, a postive value if
     *         this card is larger.
     */
    public int compareTo(Card c) {
        if (this.equals(c)) {
	    return 0;
	} else {
            String[] suitArr = new String[]{"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
	    int cardOne = 0;
	    int cardTwo = 0;
            for (int i = 0; i < suitArr.length; i++) {
                if (this.suit.equals(suitArr[i])) {
                    cardOne = i;
		}
                if (c.suit.equals(suitArr[i])) {
                    cardTwo = i;
		}
	    }
            if (cardOne == cardTwo) {
                return this.rank.getValue() - c.rank.getValue();
	    }
            return cardOne - cardTwo;
	}
    }

}
