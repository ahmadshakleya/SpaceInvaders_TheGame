package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a bonus component in the Space Invaders game.
 * The bonus component indicates whether a bonus is active or not.
 *
 * @author Ahmad Shakleya
 */
public class BonusComponent {
    /**
     * Indicates the type of bonus that is active.
     */
    private final String typeBonus;

    /**
     * Constructs a BonusComponent object with the specified type of bonus.
     *
     * @param typeBonus the type of bonus
     */
    public BonusComponent(String typeBonus) {
        this.typeBonus = typeBonus;
    }

    /**
     * Gets the type of bonus that is active.
     *
     * @return the type of bonus
     */
    public String getTypeBonus() {
        return typeBonus;
    }
}
