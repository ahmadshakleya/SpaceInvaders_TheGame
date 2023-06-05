package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractInput;
import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import java.util.ArrayList;

/**
 * The InputSystem class is responsible for updating the input and managing player actions.
 * It handles input events, such as movement and firing bullets.
 *
 * @author Ahmad Shakleya
 */
public class InputSystem {
    private final AbstractInput input;
    private ArrayList<AbstractPlayer> player;
    private boolean isPaused;
    private boolean createBullet = false;

    /**
     * Constructs an InputSystem object with the specified input, player entities, and pause state.
     *
     * @param input    The input source.
     * @param player   The list of player entities.
     * @param isPaused The pause state.
     */
    public InputSystem(AbstractInput input,
                       ArrayList<AbstractPlayer> player,
                       boolean isPaused) {
        this.input = input;
        this.player = player;
        this.isPaused = isPaused;
    }

    /**
     * Updates the input and manages player actions based on the input events.
     */
    public void updateInput() {
        createBullet = false;

        if (input.inputAvailable()) {
            AbstractInput.Inputs direction = input.getInput();

            if (direction == AbstractInput.Inputs.SPACE) {
                createBullet = true;
            }

            if (direction == AbstractInput.Inputs.P) {
                isPaused = !isPaused;
            } else {
                if (player != null) {
                    for (var playerElement : player) {
                        if (!playerElement.isDirectionChanged()) {
                            playerElement.setDirection(direction);
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the list of player entities.
     *
     * @param player The list of player entities.
     */
    public void setPlayer(ArrayList<AbstractPlayer> player) {
        this.player = player;
    }

    /**
     * Returns the pause state.
     *
     * @return The pause state.
     */
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Sets the pause state.
     *
     * @param paused The pause state.
     */
    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    /**
     * Returns whether a bullet should be created.
     *
     * @return True if a bullet should be created, false otherwise.
     */
    public boolean isCreateBullet() {
        return createBullet;
    }
}
