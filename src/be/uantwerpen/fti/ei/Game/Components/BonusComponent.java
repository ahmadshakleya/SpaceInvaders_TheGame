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
    private String typeBonus;

    public BonusComponent(String typeBonus) {
        this.typeBonus = typeBonus;
    }

    public String getTypeBonus() {
        return typeBonus;
    }

    public void setTypeBonus(String typeBonus) {
        this.typeBonus = typeBonus;
    }
}
