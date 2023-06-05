package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a position component in the Space Invaders game.
 * The position component defines the coordinates of an entity in the game world.
 *
 *
 * @author Ahmad Shakleya
 */
public class PositionComponent {
    /**
     * The x-coordinate of the entity.
     */
    private int x;

    /**
     * The y-coordinate of the entity.
     */
    private int y;

    /**
     * The initial x-coordinate of the entity.
     */
    private final int initialX;

    /**
     * The initial y-coordinate of the entity.
     */
    private final int initialY;

    /**
     * Constructs a new PositionComponent with the specified coordinates.
     *
     * @param x the x-coordinate of the entity
     * @param y the y-coordinate of the entity
     */
    public PositionComponent(int x, int y) {
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
    }

    /**
     * Retrieves the x-coordinate of the entity.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the entity.
     *
     * @param x the new x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retrieves the y-coordinate of the entity.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the entity.
     *
     * @param y the new y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Resets the position of the entity to its initial coordinates.
     * This method sets the x and y coordinates to their initial values specified during construction.
     */
    public void resetPosition() {
        this.x = initialX;
        this.y = initialY;
    }
}
