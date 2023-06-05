package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
/**
 * The J2DInput class handles user input in a Java 2D-based game.
 * It extends the AbstractInput class and listens for key events to update the input state.
 *
 * @author Ahmad Shakleya
 */
public class J2DInput extends AbstractInput {
    private final LinkedList<J2DInput.Inputs> keyInputs;
    /**
     * Constructs a J2DInput object with the specified graphics context.
     *
     * @param gr The J2DGraphicsContext object for handling user input.
     */
    public J2DInput(J2DGraphicsContext gr) {
        gr.getFrame().addKeyListener(new KeyInputAdapter());
        this.keyInputs = super.getKeyInputs();
    }
    /**
     * A KeyAdapter class that listens for key events and updates the input state accordingly.
     */
    class KeyInputAdapter extends KeyAdapter {
        /**
         * Invoked when a key has been pressed.
         *
         * @param e The KeyEvent object containing information about the key event.
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT -> keyInputs.add(Inputs.LEFT);
                case KeyEvent.VK_RIGHT -> keyInputs.add(Inputs.RIGHT);
                case KeyEvent.VK_SPACE -> keyInputs.add(Inputs.SPACE);
                case KeyEvent.VK_P -> keyInputs.add(Inputs.P);
            }
        }
    }
}
