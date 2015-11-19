/**
 * CardFace.java
 *
 * File:
 *	$Id: CardFace.java,v 1.1 2013/11/19 17:50:42 csci140 Exp $
 *
 * Revisions:
 *	$Log: CardFace.java,v $
 *	Revision 1.1  2013/11/19 17:50:42  csci140
 *	Initial revision
 *
 */

/**
 * The interface that unites Cards and CardBacks.
 *
 * @author: Arthur Nunes-Harwitt
 */

public interface CardFace {
    
    /**
     * Get the value indicating whether or not the card is face-up.
     *
     * @return A boolean indicating whether or not the card is face-up.
     */
    public boolean isFaceUp();
    
    /**
     * Get the number on the card.
     *
     * @return An integer that is the number on the card.
     */
    public int getNumber();

}