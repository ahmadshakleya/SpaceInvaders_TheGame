package be.uantwerpen.fti.ei.Game.Components;
/**
 * Represents a bullet component in the Space Invaders game.
 * The bullet component indicates whether a bullet is active or not.
 *
 * @author Ahmad Shakleya
 */
public class BulletComponent {
    /**
     * Indicates whether the bullet is active or not.
     */
    private boolean BulletActief;
    /**
     * Constructs a new BulletComponent with the specified active state.
     *
     * @param bulletActief the initial active state of the bullet
     */
    public BulletComponent(boolean bulletActief) {
        BulletActief = bulletActief;
    }
    /**
     * Checks if the bullet is currently active.
     *
     * @return true if the bullet is active, false otherwise
     */
    public boolean isBulletActief() {
        return BulletActief;
    }
    /**
     * Sets the active state of the bullet.
     *
     * @param bulletActief the new active state of the bullet
     */
    public void setBulletActief(boolean bulletActief) {
        BulletActief = bulletActief;
    }
}
