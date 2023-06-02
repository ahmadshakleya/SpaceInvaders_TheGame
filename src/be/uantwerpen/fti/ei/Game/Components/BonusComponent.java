package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a bonus component in the Space Invaders game.
 * The bonus component indicates whether a bonus is active or not.
 *
 * @author Ahmad Shakleya
 */
public class BonusComponent {
    /**
     * Indicates whether the bonus is active or not.
     */
    private boolean bonusActief;
    /**
     * Constructs a new BonusComponent with the specified active state.
     *
     * @param bonusActief the initial active state of the bonus
     */
    public BonusComponent(boolean bonusActief) {
        this.bonusActief = bonusActief;
    }
    /**
     * Checks if the bonus is currently active.
     *
     * @return true if the bonus is active, false otherwise
     */
    public boolean isBonusActief() {
        return bonusActief;
    }
    /**
     * Sets the active state of the bonus.
     *
     * @param bonusActief the new active state of the bonus
     */
    public void setBonusActief(boolean bonusActief) {
        this.bonusActief = bonusActief;
    }
}
