package be.uantwerpen.fti.ei.Game.Components;
/**
 * Represents a collision component in the Space Invaders game.
 * The collision component defines the dimensions of the hitbox for collision detection.
 *
 * @author Ahmad Shakleya
 */
public class CollisionComponent {
    /**
     * The width of the hitbox for collision detection.
     */
    private int hitboxWidth;
    /**
     * The height of the hitbox for collision detection.
     */
    private int hitboxHeight;
    /**
     * Constructs a new CollisionComponent with the specified hitbox dimensions.
     *
     * @param hitboxWidth the width of the hitbox
     * @param hitboxHeight the height of the hitbox
     */
    public CollisionComponent(int hitboxWidth, int hitboxHeight) {
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
    }

    /**
     * Retrieves the width of the hitbox.
     *
     * @return the width of the hitbox
     */
    public int getHitboxWidth() {
        return hitboxWidth;
    }
    /**
     * Sets the width of the hitbox.
     *
     * @param hitboxWidth the new width of the hitbox
     */
    public void setHitboxWidth(int hitboxWidth) {
        this.hitboxWidth = hitboxWidth;
    }
    /**
     * Retrieves the height of the hitbox.
     *
     * @return the height of the hitbox
     */
    public int getHitboxHeight() {
        return hitboxHeight;
    }
    /**
     * Sets the height of the hitbox.
     *
     * @param hitboxHeight the new height of the hitbox
     */
    public void setHitboxHeight(int hitboxHeight) {
        this.hitboxHeight = hitboxHeight;
    }
}
