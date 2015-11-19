/**
 * CardBack.java
 *
 * File:
 *	$Id: CardBack.java,v 1.1 2013/11/19 17:50:42 csci140 Exp $
 *
 * Revisions:
 *	$Log: CardBack.java,v $
 *	Revision 1.1  2013/11/19 17:50:42  csci140
 *	Initial revision
 *
 */

/**
 * Class definition for the back of a card in the concentration card
 * game.
 *
 * @author: Arthur Nunes-Harwitt
 */

public class CardBack implements CardFace {

    /**
     * Get the constant indicating that the card is face-down.
     *
     * @return The boolean indicating the card is face-down.
     */
    @Override
    public boolean isFaceUp() {
	return false;
    }

    /**
     * This method is required by the interface, but this class cannot
     * return a value.  Instead, an exception is thrown.
     *
     * @return Technically an integer, but no integer is ever
     * returned.
     */
    @Override
    public int getNumber() {
	throw new RuntimeException("The number is hidden.");
    }

    /**
     * Get the String representing the back of a card.
     *
     * @return A String representing the back of a card.
     */
    @Override
    public String toString() {
	return "***";
    }

}