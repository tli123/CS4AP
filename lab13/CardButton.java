

/**
 * CardButton.java
 *
 * The card button to be added to the game.
 *
 *
 * File:
 *	$Id: CardButton.java,v 1.0 2015/11/19 01:27:28 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: CardButton.java,v $
 *	Initial revision
 *
 */

/**
 * The button for Concentration.
 *
 * @author Tommy Li
 */

import java.awt.*;
import javax.swing.*;

public class CardButton extends JButton {

    /**
     * The position of the card.
     */
    private int pos;

    /**
     * The number that is on the card.
     */
    private int number;

    /**
     * Constructs a CardButton object.
     * @param pos - The position or index of the represented card 
     *              in the model.
     */
    public CardButton(int pos, int number) {
        super();
        this.pos = pos;
        this.number = number;
    }

    /**
     * Get the position of the card.
     * @return An integer that is the position or index of the 
     *         represented card in the model.
     */
    public int getPos() {
        return pos;
    }

    /**
     * Get the number that is on the card. 
     * @return The number on the card.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Checks if two CardButtons are equal.
     * @param other - The CardButton that this is being compared to.
     * @return True if they are equal, false otherwise.
     */
    public boolean equals(CardButton other) {
        if (this.number == other.getNumber() && this.pos == other.getPos()) {
            return true;
	}
        return false;
    }
}
