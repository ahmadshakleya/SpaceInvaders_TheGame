package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a size component in the Space Invaders game.
 * The size component defines the dimensions and size-related properties of an entity in the game world.
 *
 * @author Ahmad Shakleya
 */
public class SizeComponent {

    /**
     * Indicates whether the entity has reached the end (boundary) of the game.
     */
    private boolean reachedEnd = false;

    /**
     * The width of the game screen.
     */
    private int screenWidth;

    /**
     * The height of the game screen.
     */
    private int screenHeight;

    /**
     * The size property of the entity.
     */
    private int size;

    /**
     * Constructs a new SizeComponent with the specified screen width, screen height, and size.
     *
     * @param screenWidth the width of the game screen
     * @param screenHeight the height of the game screen
     * @param size the size property of the entity
     */
    public SizeComponent(int screenWidth, int screenHeight, int size) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.size = size;
    }

    /**
     * Checks whether the entity has reached the end (boundary) of the game.
     *
     * @return true if the entity has reached the end, false otherwise
     */
    public boolean isReachedEnd() {
        return reachedEnd;
    }

    /**
     * Sets whether the entity has reached the end (boundary) of the game.
     *
     * @param reachedEnd true if the entity has reached the end, false otherwise
     */
    public void setReachedEnd(boolean reachedEnd) {
        this.reachedEnd = reachedEnd;
    }

    /**
     * Retrieves the width of the game screen.
     *
     * @return the screen width
     */
    public int getScreenwidth() {
        return screenWidth;
    }

    /**
     * Sets the width of the game screen.
     *
     * @param screenWidth the new screen width
     */
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    /**
     * Retrieves the height of the game screen.
     *
     * @return the screen height
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * Sets the height of the game screen.
     *
     * @param screenHeight the new screen height
     */
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    /**
     * Retrieves the size property of the entity.
     *
     * @return the size property
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size property of the entity.
     *
     * @param size the new size property
     */
    public void setSize(int size) {
        this.size = size;
    }
}
