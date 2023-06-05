package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a level component in the Space Invaders game.
 * The level component stores the current level of the game.
 *
 *
 * @author Ahmad Shakleya
 */
public class LevelComponent {
    /**
     * The current level of the game.
     */
    private int level;

    /**
     * Constructs a new LevelComponent with the specified level.
     *
     * @param level the current level of the game
     */
    public LevelComponent(int level) {
        this.level = level;
    }

    /**
     * Retrieves the current level of the game.
     *
     * @return the current level of the game
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the current level of the game.
     *
     * @param level the new level to be set
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
