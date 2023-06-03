package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.util.ArrayList;

public class BonusMovementSystem {
    private ArrayList<AbstractBonus> bonuses;
    private int teller = 0;
    private boolean overflow = false;

    public BonusMovementSystem(ArrayList<AbstractBonus> bonuses) {
        this.bonuses = bonuses;
    }

    public void updateBonusMovement() {
        if (bonuses != null) {
            for (var bonus: bonuses) {
                if (teller >= bonus.snelheid()) {
                    bonus.getPositionComponent().setX(bonus.x() + bonus.dx());
                    overflow = true;
                }
                if (bonus.x() + bonus.dx() < 1) {
                    bonus.getSizeComponent().setReachedEnd(true);
                }
            }
            updateTeller();

        }
    }

    public void updateTeller() {
        if (overflow) {
            teller = 0;
            overflow = false;
        } else {
            teller++;
        }
    }

    public ArrayList<AbstractBonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(ArrayList<AbstractBonus> bonuses) {
        this.bonuses = bonuses;
    }
}
