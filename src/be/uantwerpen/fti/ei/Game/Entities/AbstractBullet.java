package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.BulletComponent;
import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;

/**
 * Abstract class representing a bullet entity in the game.
 * Extends the AbstractFigure class.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractBullet extends AbstractFigure {
    private BulletComponent bulletComponent;

    /**
     * Constructs an AbstractBullet object.
     *
     * @param x            The initial x-coordinate of the bullet.
     * @param y            The initial y-coordinate of the bullet.
     * @param dx           The horizontal velocity of the bullet.
     * @param dy           The vertical velocity of the bullet.
     * @param traagheid    The friction or deceleration of the bullet.
     * @param hitboxWidth  The width of the bullet's hitbox.
     * @param hitboxHeight The height of the bullet's hitbox.
     * @param bulletActief Indicates if the bullet is active or not.
     * @param bonusScore   The bonus score value associated with the bullet.
     * @param screenWidth  The width of the game screen.
     * @param screenHeight The height of the game screen.
     * @param size         The size of the bullet.
     */
    public AbstractBullet(int x,
                          int y,
                          int dx,
                          int dy,
                          int traagheid,
                          int hitboxWidth,
                          int hitboxHeight,
                          boolean bulletActief,
                          int bonusScore,
                          int screenWidth,
                          int screenHeight,
                          int size) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, 1, bonusScore, screenWidth, screenHeight, size);
        this.bulletComponent = new BulletComponent(bulletActief);
    }

    /**
     * Get the position component of the bullet.
     *
     * @return The position component.
     */
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    /**
     * Set the position component of the bullet.
     *
     * @param positionComponent The position component to set.
     */
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    /**
     * Get the movement component of the bullet.
     *
     * @return The movement component.
     */
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    /**
     * Set the movement component of the bullet.
     *
     * @param movementComponent The movement component to set.
     */
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    /**
     * Get the bullet component of the bullet.
     *
     * @return The bullet component.
     */
    public BulletComponent getBulletComponent() {
        return bulletComponent;
    }

    /**
     * Set the bullet component of the bullet.
     *
     * @param bulletComponent The bullet component to set.
     */
    public void setBulletComponent(BulletComponent bulletComponent) {
        this.bulletComponent = bulletComponent;
    }

    /**
     * Get the collision component of the bullet.
     *
     * @return The collision component.
     */
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    /**
     * Set the collision component of the bullet.
     *
     * @param collisionComponent The collision component to set.
     */
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }
}
