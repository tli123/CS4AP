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
     * The undo stack of the game.
     */
    private ArrayList<CardButton> undoStack;

    /**
     * The number of moves that were made.
     */
    private int moveCount;

    /**
     * The label on the top of the game.
     */
    private JLabel topLine;

    /**
     * The middle JPanel, that holds the buttons.
     */
    private JPanel middle;

    /**
     * Constucts a GViewControl object.
     * @param model - The model for the view and controller.
     */
    public GViewControl(final ConcentrationModel model) {
        //Sets the title.
        super("Tommy Li: Concentration Model");

        //Initializes some of the necessary instance variables.
        this.model = model;
        model.addObserver(this); //Add the view and controller as a observer.
        undoStack = new ArrayList<CardButton>();
        
        //Sets the layout for the entire frame.
        this.getContentPane().setLayout(new BorderLayout());

        //Sets the top label up.
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        topLine = new JLabel("Moves: 0  Select the first card.");
        top.add(topLine);
        this.add(top, BorderLayout.NORTH);

        //Sets the cardButtons up in the center pane.
        middle = new JPanel();
        middle.setLayout(new GridLayout(model.BOARD_SIZE, model.BOARD_SIZE));
        ArrayList<CardButton> cardButtons = new ArrayList<CardButton>();
        for (double i = 0; (int)i < model.NUM_PAIRS; i += 0.5) {
            final CardButton card = new CardButton((int)(i * 2), (int)i);
            //Add an Action Listener to each button.
            card.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    switch(undoStack.size() % 2) {
		    //If no cards are flipped, then add card to undo stack.
                    case(0):
                        refreshButtons();
                        undoStack.clear();
                        undoStack.add(card);
                        card.setBackground(getColor(card.getNumber()));
                        card.setText(card.getNumber() + "");
                        card.setEnabled(false);
                        moveCount++;
                        break;
                    case(1):
                        undoStack.add(card);
                        card.setBackground(getColor(card.getNumber()));
                        card.setText(card.getNumber() + "");
                        card.setEnabled(false);
                        moveCount++;
                        if (undoStack.get(0).getNumber() == undoStack.get(1).getNumber()) {
                            undoStack.clear();
                        }
                        break;
                    }
                    //Let model know that the view was changed.
                    model.setChanged();
                    model.notifyObservers(card);
                }
	    });
            cardButtons.add(card);
        }
        Collections.shuffle(cardButtons);
        for (CardButton cardButton : cardButtons) {
            middle.add(cardButton);
        }
        this.add(middle);

        //Sets up the bottom three buttons.
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton reset = new JButton("Reset"); //Reset Button
        //Add Action Listener to reset.
        reset.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
                resetButtons();
	    }
	});
        JButton cheat = new JButton("Cheat"); //Cheat Button
        //Add Action Listener to cheat.
        final ArrayList<CardButton> CardButtons = cardButtons;
        cheat.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
                for (CardButton cardButton : CardButtons) {
                    cardButton.setText(cardButton.getNumber() + "");
                    cardButton.setBackground(getColor(cardButton.getNumber()));
                    cardButton.setEnabled(false);
                }
                CheatFrame cheater = new CheatFrame(CardButtons, model.BOARD_SIZE);
                cheater.setVisible(true);
                model.setChanged();
                model.notifyObservers();
	    }
	});
        JButton undo = new JButton("Undo"); //Undo Button
        //Add Action Listener to undo.
        undo.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
                if (undoStack.size() > 0) {
                    undo();
                    undoStack.remove(undoStack.size() - 1);
		}
	    }
	});
        bottom.add(reset);
        bottom.add(cheat);
        bottom.add(undo);
        this.add(bottom, BorderLayout.SOUTH);

        //Sets up the properties of the window.
        this.setSize(400, 400);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Start the concentration game.
     */
    private void startGame() {

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
        String numCard = "";
        if (undoStack.size()%2 == 0) {
            numCard = "first";
	} else if (undoStack.size()%2 == 1) {
            numCard = "second";
	}
        topLine.setText("Moves: " + moveCount + "Select the " + numCard + " card.");
        revalidate();
    }

    /**
     * Retrieves the color for the number.
     * @param The number on the card.
     * @return The color.
     */
    private Color getColor(int cardNum) {
        Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.DARK_GRAY,
                                     Color.GREEN, Color.MAGENTA, Color.ORANGE,
                                     Color.PINK, Color.RED};
        return cardNum <= 7 ? colors[cardNum] : null;
    }

    /**
     * Undoes the last two moves if two cards were chosen and they
     * do not match.
     */
    private void refreshButtons() {
        Component[] components = middle.getComponents();
        for (int i = 0; undoStack.size() == 2 && i < components.length; i++) {
            if (components[i] instanceof CardButton) {
                if (undoStack.get(0).equals(components[i]) || undoStack.get(1).equals(components[i])) {
                    CardButton component = (CardButton)(components[i]);
                    component.setText("");
                    component.setBackground(null);
                    component.setEnabled(true);
                    components[i] = (Component)component;
		}
	    }
	}
        model.setChanged();
        model.notifyObservers(middle);
    }

    /**
     * Resets all of the buttons in the game.
     */
    private void resetButtons() {
        Component[] components = middle.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof CardButton) {
                CardButton component = (CardButton)(components[i]);
                component.setText("");
                component.setBackground(null);
                component.setEnabled(true);
                components[i] = (Component)component;
	    }
	}
        moveCount = 0;
        undoStack.clear();
        model.setChanged();
        model.notifyObservers(middle);
    }

    /**
     * Undoes the last move.
     */
    public void undo() {
        Component[] components = middle.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof CardButton) {
                if (undoStack.get(undoStack.size() - 1).equals(components[i])) {
                    CardButton component = (CardButton)(components[i]);
                    component.setText("");
                    component.setBackground(null);
                    component.setEnabled(true);
                    components[i] = (Component)component;
                    break;
		}
	    }
	}
        moveCount--;
        model.setChanged();
        model.notifyObservers(middle);
    }

    /**
     * The main method used to play a game.
     * @param args - Command line arguments -- unused
     */
    public static void main(String[] args) {
        GViewControl game = new GViewControl(new ConcentrationModel());
    }
}
