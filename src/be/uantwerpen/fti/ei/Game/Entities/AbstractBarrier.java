package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;
import be.uantwerpen.fti.ei.Game.Components.SoundComponent;

/**
 * Represents an abstract barrier in the Space Invaders game.
 * An abstract barrier is a type of figure that provides protection or obstacles for the player.
 * This class extends the AbstractFigure class and inherits its properties and behavior.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractBarrier extends AbstractFigure {
    /**
     * Constructs a new AbstractBarrier with the specified parameters.
     *
     * @param x              the initial x-coordinate of the barrier
     * @param y              the initial y-coordinate of the barrier
     * @param dx             the horizontal speed of the barrier
     * @param dy             the vertical speed of the barrier
     * @param traagheid      the inertia of the barrier's movement
     * @param hitboxWidth    the width of the barrier's collision hitbox
     * @param hitboxHeight   the height of the barrier's collision hitbox
     * @param healthValue    the health value of the barrier
     * @param screenWidth    the width of the game screen
     * @param screenHeight   the height of the game screen
     * @param size           the size of the barrier
     */
    public AbstractBarrier(int x,
                           int y,
                           int dx,
                           int dy,
                           int traagheid,
                           int hitboxWidth,
                           int hitboxHeight,
                           int healthValue,
                           int screenWidth,
                           int screenHeight,
                           int size) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, healthValue, 0, screenWidth, screenHeight, size, null);
    }


    /**
     * Retrieves the position component of the barrier.
     *
     * @return the position component
     */
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    /**
     * Sets the position component of the barrier.
     *
     * @param positionComponent the position component to set
     */
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    /**
     * Retrieves the movement component of the barrier.
     *
     * @return the movement component
     */
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    /**
     * Sets the movement component of the barrier.
     *
     * @param movementComponent the movement component to set
     */
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    /**
     * Retrieves the collision component of the barrier.
     *
     * @return the collision component
     */
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    /**
     * Sets the collision component of the barrier.
     *
     * @param collisionComponent the collision component to set
     */
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }
}
