package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class InputCUBE extends AbstractInput {
    private LinkedList<Inputs> keyInputs;
    public InputCUBE(GraphicsContextCUBE gr) {
        gr.getFrame().addKeyListener(new KeyInputAdapter());
        this.keyInputs = super.getKeyInputs();
    }

    class KeyInputAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT : keyInputs.add(Inputs.LEFT);  break;
                case KeyEvent.VK_RIGHT: keyInputs.add(Inputs.RIGHT); break;
                case KeyEvent.VK_DOWN : keyInputs.add(Inputs.DOWN);  break;
                case KeyEvent.VK_UP   : keyInputs.add(Inputs.UP);    break;
                case KeyEvent.VK_SPACE: keyInputs.add(Inputs.SPACE); break;
                case KeyEvent.VK_P: keyInputs.add(Inputs.P); break;
                case KeyEvent.VK_B: keyInputs.add(Inputs.B); break;
            }
        }
    }
}
