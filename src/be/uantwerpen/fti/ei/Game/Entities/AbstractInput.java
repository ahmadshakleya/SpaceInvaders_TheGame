package be.uantwerpen.fti.ei.Game.Entities;

import java.util.LinkedList;

/**
 * Abstract class representing input handling in the game.
 * Extend this class to implement custom input logic.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractInput {
    public enum Inputs {LEFT, RIGHT, SPACE, IDLE, P}
    private final LinkedList<AbstractInput.Inputs> keyInputs;

    /**
     * Constructs an AbstractInput object.
     */
    public AbstractInput() {
        this.keyInputs = new LinkedList<>();
    }

    /**
     * Checks if there is an input available.
     *
     * @return True if there is an input available, false otherwise.
     */
    public boolean inputAvailable() {
        if (keyInputs.size() == 0) {
            keyInputs.add(AbstractInput.Inputs.IDLE);
            return false;
        }
        return true;
    }

    /**
     * Retrieves the next input and removes it from the list.
     * If no input is available, it returns the IDLE input.
     *
     * @return The next input.
     */
    public AbstractInput.Inputs getInput() {
        keyInputs.poll();
        if (keyInputs.size() == 0) {
            keyInputs.add(AbstractInput.Inputs.IDLE);
        }
        return keyInputs.get(0);
    }

    /**
     * Retrieves the list of key inputs.
     *
     * @return The list of key inputs.
     */
    public LinkedList<Inputs> getKeyInputs() {
        return keyInputs;
    }
}
