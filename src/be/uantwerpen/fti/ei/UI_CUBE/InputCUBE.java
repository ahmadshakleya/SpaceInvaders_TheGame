package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * Represents the input handler for the CUBE game.
 * This class extends the AbstractInput class.
 *
 * @author Ahmad Shakleya
 */
public class InputCUBE extends AbstractInput {
    private final LinkedList<Inputs> keyInputs;

    /**
     * Constructs an InputCUBE object with the specified GraphicsContextCUBE.
     *
     * @param gr The GraphicsContextCUBE object.
     */
    public InputCUBE(GraphicsContextCUBE gr) {
        gr.getFrame().addKeyListener(new KeyInputAdapter());
        this.keyInputs = super.getKeyInputs();
    }

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
