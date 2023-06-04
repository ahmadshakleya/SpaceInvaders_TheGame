package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;
import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;
import be.uantwerpen.fti.ei.Game.Entities.AbstractInput;
import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import java.util.ArrayList;

public class InputSystem {
    private AbstractInput input;
    private ArrayList<AbstractPlayer> player;
    private boolean isPaused = false;

    private boolean createBullet = false;

    public InputSystem(AbstractInput input,
                       ArrayList<AbstractPlayer> player,
                       boolean isPaused) {
        this.input = input;
        this.player = player;
        this.isPaused = isPaused;
    }
    public void updateInput() {
        createBullet = false;
        if (input.inputAvailable()){
            AbstractInput.Inputs direction = input.getInput();
            if (direction == AbstractInput.Inputs.SPACE) {
                createBullet = true;
            }
            if (direction == AbstractInput.Inputs.P) {
                isPaused = !isPaused;
            }
            else {
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

    public AbstractInput getInput() {
        return input;
    }

    public void setInput(AbstractInput input) {
        this.input = input;
    }

    public ArrayList<AbstractPlayer> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<AbstractPlayer> player) {
        this.player = player;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public boolean isCreateBullet() {
        return createBullet;
    }

    public void setCreateBullet(boolean createBullet) {
        this.createBullet = createBullet;
    }
}
