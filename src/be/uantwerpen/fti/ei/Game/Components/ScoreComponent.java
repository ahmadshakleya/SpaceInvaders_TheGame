package be.uantwerpen.fti.ei.Game.Components;
/**
 * Represents a score component in the Space Invaders game.
 * The score component stores the score value achieved by the player.
 *
 * @author Ahmad Shakleya
 */
public class ScoreComponent {
    /**
     * The score value achieved by the player.
     */
    private int score;
    /**
     * Constructs a new ScoreComponent with the specified score value.
     *
     * @param score the score value to set
     */
    public ScoreComponent(int score) {
        this.score = score;
    }
    /**
     * Retrieves the score value.
     *
     * @return the score value
     */
    public int getScore() {
        return score;
    }
    /**
     * Sets the score value.
     *
     * @param score the score value to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
