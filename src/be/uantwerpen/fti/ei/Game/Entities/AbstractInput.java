package be.uantwerpen.fti.ei.Game.Entities;

import java.util.LinkedList;

public abstract class AbstractInput {
    public enum Inputs {LEFT, RIGHT, UP, DOWN, SPACE, IDLE, P, B};
    private LinkedList<AbstractInput.Inputs> keyInputs;

    public AbstractInput() {
        this.keyInputs = new LinkedList<Inputs>();
    }

    public boolean inputAvailable() {
        if (keyInputs.size() == 0) {
            keyInputs.add(AbstractInput.Inputs.IDLE);
            return false;
        }
        return true;
    }
    public AbstractInput.Inputs getInput() {
        keyInputs.poll();
        if (keyInputs.size() == 0) {
            keyInputs.add(AbstractInput.Inputs.IDLE);
        }
        return keyInputs.get(0);
    }

    public LinkedList<Inputs> getKeyInputs() {
        return keyInputs;
    }

    public void setKeyInputs(LinkedList<Inputs> keyInputs) {
        this.keyInputs = keyInputs;
    }
}
