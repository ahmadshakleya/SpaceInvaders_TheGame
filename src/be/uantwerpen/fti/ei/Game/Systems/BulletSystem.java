package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import java.util.ArrayList;

/**
 * The BulletSystem class manages the movement and position updates of bullets in the game.
 * It maintains a list of bullets and provides methods to update their positions.
 *
 * @author Ahmad Shakleya
 */
public class BulletSystem {
    private ArrayList<AbstractBullet> bullets;

    /**
     * Constructs a BulletSystem object.
     *
     * @param bullets The list of bullets to be managed by the system.
     */
    public BulletSystem(ArrayList<AbstractBullet> bullets) {
        this.bullets = bullets;
    }

    /**
     * Updates the position of the bullets.
     * This method should be called every frame or time step to update the bullet positions.
     */
    public void updateBulletPosition() {
        if (this.bullets != null) {
            for (var bullet : this.bullets) {
                bullet.getPositionComponent().setY(bullet.getPositionComponent().getY() + bullet.getMovementComponent().getDy());
                if (bullet.y() + bullet.dy() < 1 || bullet.y() + bullet.dy() > bullet.getSizeComponent().getScreenHeight() / bullet.getSizeComponent().getSize()) {
                    bullet.getSizeComponent().setReachedEnd(true);
                }
            }
        }
    }

    /**
     * Retrieves the list of bullets managed by the system.
     *
     * @return The list of bullets.
     */
    public ArrayList<AbstractBullet> getBullets() {
        return bullets;
    }

    /**
     * Sets the list of bullets to be managed by the system.
     *
     * @param bullets The list of bullets.
     */
    public void setBullets(ArrayList<AbstractBullet> bullets) {
        this.bullets = bullets;
    }
}
