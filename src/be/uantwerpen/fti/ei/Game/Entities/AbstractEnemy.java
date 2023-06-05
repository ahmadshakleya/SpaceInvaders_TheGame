package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

/**
 * Abstract class representing an enemy entity in the game.
 * Extends the AbstractFigure class.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractEnemy extends AbstractFigure {
    /**
     * Constructs an AbstractEnemy object.
     *
     * @param x              The initial x-coordinate of the enemy.
     * @param y              The initial y-coordinate of the enemy.
     * @param dx             The horizontal velocity of the enemy.
     * @param dy             The vertical velocity of the enemy.
     * @param traagheid      The friction or deceleration of the enemy.
     * @param hitboxWidth    The width of the enemy's hitbox.
     * @param hitboxHeight   The height of the enemy's hitbox.
     * @param healthValue    The health value of the enemy.
     * @param enemyPoints    The points value associated with the enemy.
     * @param screenWidth   The width of the game screen.
     * @param screenHeight  The height of the game screen.
     * @param size           The size of the enemy.
     * @param soundFile      The sound file associated with the enemy.
     */
    public AbstractEnemy(int x,
                         int y,
                         int dx,
                         int dy,
                         int traagheid,
                         int hitboxWidth,
                         int hitboxHeight,
                         int healthValue,
                         int enemyPoints,
                         int screenWidth,
                         int screenHeight,
                         int size,
                         String soundFile) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, healthValue, enemyPoints, screenWidth, screenHeight, size, soundFile);
    }

    /**
     * Get the position component of the enemy.
     *
     * @return The position component.
     */
    @Override
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    /**
     * Set the position component of the enemy.
     *
     * @param positionComponent The position component to set.
     */
    @Override
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    /**
     * Get the movement component of the enemy.
     *
     * @return The movement component.
     */
    @Override
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    /**
     * Set the movement component of the enemy.
     *
     * @param movementComponent The movement component to set.
     */
    @Override
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    /**
     * Get the collision component of the enemy.
     *
     * @return The collision component.
     */
    @Override
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    /**
     * Set the collision component of the enemy.
     *
     * @param collisionComponent The collision component to set.
     */
    @Override
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }

    /**
     * Get the health component of the enemy.
     *
     * @return The health component.
     */
    @Override
    public HealthComponent getHealthComponent() {
        return super.getHealthComponent();
    }

    /**
     * Set the health component of the enemy.
     *
     * @param healthComponent The health component to set.
     */
    @Override
    public void setHealthComponent(HealthComponent healthComponent) {
        super.setHealthComponent(healthComponent);
    }

    /**
     * Get the score component of the enemy.
     *
     * @return The score component.
     */
    @Override
    public ScoreComponent getScoreComponent() {
        return super.getScoreComponent();
    }

    /**
     * Set the score component of the enemy.
     *
     * @param scoreComponent The score component to set.
     */
    @Override
    public void setScoreComponent(ScoreComponent scoreComponent) {
        super.setScoreComponent(scoreComponent);
    }

    /**
     * Get the size component of the enemy.
     *
     * @return The size component.
     */
    @Override
    public SizeComponent getSizeComponent() {
        return super.getSizeComponent();
    }

    /**
     * Set the size component of the enemy.
     *
     * @param sizeComponent The size component to set.
     */
    @Override
    public void setSizeComponent(SizeComponent sizeComponent) {
        super.setSizeComponent(sizeComponent);
    }

    /**
     * Get the sound component of the enemy.
     *
     * @return The sound component.
     */
    @Override
    public SoundComponent getSoundComponent() {
        return super.getSoundComponent();
    }

    /**
     * Set the sound component of the enemy.
     *
     * @param soundComponent The sound component to set.
     */
    @Override
    public void setSoundComponent(SoundComponent soundComponent) {
        super.setSoundComponent(soundComponent);
    }
}
