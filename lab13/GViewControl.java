/**
 * GViewControl.java
 *
 * Hold the GUI version of concentration.
 *
 *
 * File:
 *	$Id: GViewControl.java,v 1.0 2015/11/19 01:24:22 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: GViewControl.java,v $
 *	Initial revision
 *
 */

/**
 * The GUI Concentration game.
 *
 * @author Tommy Li
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.util.Collections;

public class GViewControl extends JFrame implements Observer {

    /**
     * The model for the view and controller.
     */
    private ConcentrationModel model;

    /**
     * The CardButtons in the game.
     */
    private ArrayList<CardButton> cardButtons;

    /**
     * The label that has the status of the game.
     */
    private JLabel topLine;

    /**
     * Holds the potential colors of all of the CardButtons.
     */
    private Color[] color = new Color[]{Color.BLUE, Color.CYAN, Color.DARK_GRAY,
                                       Color.GREEN, Color.MAGENTA, Color.ORANGE,
                                        Color.PINK, Color.RED};

    /**
     * Constucts a GViewControl object.
     * @param model - The model for the view and controller.
     */
    public GViewControl(ConcentrationModel model) {
        //Set up the window.
        super("Tommy Li: Concentration Game");
        this.setSize(400, 400);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Set up the model, and set its observer to the GUI.
        this.model = model;
        cardButtons = new ArrayList<CardButton>();
        model.addObserver(this);
        
        //Sets the layout for the entire frame.
        this.getContentPane().setLayout(new BorderLayout());

        //Sets the top label up.
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        topLine = new JLabel("Moves: 0  Select the first card.");
        top.add(topLine);
        this.add(top, BorderLayout.NORTH);

        //Sets the cards up.
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(model.BOARD_SIZE, model.BOARD_SIZE));
        //The buttonListener for all the buttons.
        ButtonListener buttonListener = new ButtonListener();
        for (int i = 0; i < model.NUM_CARDS; i++) {
            CardButton button = new CardButton(i);
            button.addActionListener(buttonListener);
            button.setBorderPainted(true);
	    button.setContentAreaFilled(true);
	    button.setOpaque(false);
            middle.add(button);
            cardButtons.add(button);
	}
        this.add(middle);

        //Set the last 3 buttons up.
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] bottomButtons = new String[]{"Reset", "Cheat", "Undo"};
        for (int i = 0; i < bottomButtons.length; i++) {
            JButton button = new JButton(bottomButtons[i]);
            button.addActionListener(buttonListener);
            bottom.add(button);
	}
        this.add(bottom, BorderLayout.SOUTH);

        //Make the GUI visible.
        this.setVisible(true);
    }

    /**
     * Private class that implements a Button Listener. Acts
     * as the primary button listener for all buttons in the
     * GUI.
     */
    private class ButtonListener implements ActionListener {
	/**
	 * Checks for any Button actions, and depending on what
	 * button is pressed, gives the appropriate action.
	 * @param e - The ActionEvent.
	 */
        public void actionPerformed(ActionEvent e) {
	    //CardButton
            if (e.getSource() instanceof CardButton) {
                model.selectCard(((CardButton)e.getSource()).getPos());
	    } else if (e.getActionCommand().equals("Cheat")) {
		//Chest
                ArrayList<CardButton> cheat = new ArrayList<CardButton>();
                ArrayList<CardFace> cardFaces = model.cheat();
                for (CardFace cardFace : cardFaces) {
                    CardButton cheatButton = new CardButton(cardFace.getNumber());
                    cheatButton.setText(cardFace.getNumber() + "");
                    cheatButton.setBackground(color[cardFace.getNumber()]);
                    cheatButton.setEnabled(false);
                    cheatButton.setBorderPainted(false);
	            cheatButton.setContentAreaFilled(false);
	            cheatButton.setOpaque(true);
		    cheat.add(cheatButton);
		}
                CheatFrame cheatFrame = new CheatFrame(cheat, model.BOARD_SIZE);
	    } else if (e.getActionCommand().equals("Reset")) {
		//Reset
                model.reset();
	    } else if (e.getActionCommand().equals("Undo")) {
		//Undo
                model.undo();
	    }
	}
    }

    /**
     * Update the window when the model indicates an update is
     * required. Update changes the color and string content of
     * a CardButton based on the CardFaces in the model, and it
     * changes the text in the label based on the model state.
     * @param t - An Observable -- not used.
     * @param o - An Object -- not used.
     */
    public void update(Observable t, Object o) {
        ArrayList<CardFace> cards = model.getCards();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isFaceUp()) {
                cardButtons.get(i).setText(cards.get(i).getNumber() + "");
                cardButtons.get(i).setBackground(color[cards.get(i).getNumber()]);
                cardButtons.get(i).setEnabled(false);
                cardButtons.get(i).setBorderPainted(false);
	        cardButtons.get(i).setContentAreaFilled(false);
	        cardButtons.get(i).setOpaque(true);
	    } else {
                cardButtons.get(i).setText("");
                cardButtons.get(i).setBackground(null);
                cardButtons.get(i).setEnabled(true);
                cardButtons.get(i).setBorderPainted(true);
	        cardButtons.get(i).setContentAreaFilled(true);
	        cardButtons.get(i).setOpaque(false);
	    }
	}
        int faceUp = model.howManyCardsUp();
        String text;
        if (faceUp == 2) {
            text = " No Match: Undo or select a card.";
	} else {
	    text = " Select the" + (faceUp % 2 == 0 ? " first " : " second ") + "card";
	}
	topLine.setText("Moves: " + model.getMoveCount() + text);
        validate();
    }

    /**
     * The main method used to play a game.
     * @param args - Command line arguments -- unused
     */
    public static void main(String[] args) {
        GViewControl game = new GViewControl(new ConcentrationModel());
    }
}
