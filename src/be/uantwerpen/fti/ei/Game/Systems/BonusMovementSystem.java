package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.util.ArrayList;

/**
 * The BonusMovementSystem class is responsible for updating the movement of bonuses in the game.
 * It keeps track of the bonuses and their movement properties.
 *
 * @author Ahmad Shakleya
 */
public class BonusMovementSystem {
    private ArrayList<AbstractBonus> bonuses;
    private int teller = 0;
    private boolean overflow = false;

    /**
     * Constructs a BonusMovementSystem object.
     *
     * @param bonuses The list of bonuses to be managed by the system.
     */
    public BonusMovementSystem(ArrayList<AbstractBonus> bonuses) {
        this.bonuses = bonuses;
    }

    /**
     * Updates the movement of the bonuses.
     * This method should be called every frame or time step to update the bonus positions.
     */
    public void updateBonusMovement() {
        if (bonuses != null) {
            for (var bonus : bonuses) {
                if (teller >= bonus.snelheid()) {
                    bonus.getPositionComponent().setY(bonus.y() + bonus.dy());
                    overflow = true;
                }
                if (bonus.y() + bonus.dy() >= bonus.getSizeComponent().getScreenHeight() / bonus.getSizeComponent().getSize() - bonus.getCollisionComponent().getHitboxHeight() / 2) {
                    bonus.getSizeComponent().setReachedEnd(true);
                }
            }
            updateTeller();
        }
    }

    /**
     * Updates the teller value used for bonus movement.
     * If there was an overflow in the previous iteration, the teller is reset to 0.
     * Otherwise, the teller is incremented by 1.
     */
    public void updateTeller() {
        if (overflow) {
            teller = 0;
            overflow = false;
        } else {
            teller++;
        }
    }

    /**
     * Retrieves the list of bonuses managed by the system.
     *
     * @return The list of bonuses.
     */
    public ArrayList<AbstractBonus> getBonuses() {
        return bonuses;
    }

    /**
     * Sets the list of bonuses to be managed by the system.
     *
     * @param bonuses The list of bonuses.
     */
    public void setBonuses(ArrayList<AbstractBonus> bonuses) {
        this.bonuses = bonuses;
    }
}
