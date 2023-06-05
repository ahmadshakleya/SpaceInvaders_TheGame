package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.LevelComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;

/**
 * Represents an abstract player in the game.
 * The player is a type of figure with additional properties and behaviors specific to players.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractPlayer extends AbstractFigure {
    private final LevelComponent levelComponent;
    private boolean directionChanged = false;

    /**
     * Constructs an AbstractPlayer object.
     *
     * @param x             The x-coordinate of the player's position.
     * @param y             The y-coordinate of the player's position.
     * @param dx            The initial x velocity of the player.
     * @param dy            The initial y velocity of the player.
     * @param traagheid     The traagheid value of the player.
     * @param hitboxWidth   The width of the player's hitbox.
     * @param hitboxHeight  The height of the player's hitbox.
     * @param healthValue   The initial health value of the player.
     * @param HighScore     The high score value of the player.
     * @param screenWidth  The width of the game screen.
     * @param screenHeight The height of the game screen.
     * @param size          The size of the player.
     * @param level         The level of the player.
     * @param soundFile     The sound file associated with the player.
     */
    public AbstractPlayer(int x,
                          int y,
                          int dx,
                          int dy,
                          int traagheid,
                          int hitboxWidth,
                          int hitboxHeight,
                          int healthValue,
                          int HighScore,
                          int screenWidth,
                          int screenHeight,
                          int size,
                          int level,
                          String soundFile) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, healthValue, HighScore, screenWidth, screenHeight, size, soundFile);
        this.levelComponent = new LevelComponent(level);
    }

    /**
     * Retrieves the position component of the player.
     *
     * @return The position component of the player.
     */
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    /**
     * Sets the position component of the player.
     *
     * @param positionComponent The position component to set.
     */
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    /**
     * Retrieves the movement component of the player.
     *
     * @return The movement component of the player.
     */
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    /**
     * Sets the movement component of the player.
     *
     * @param movementComponent The movement component to set.
     */
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    /**
     * Retrieves the collision component of the player.
     *
     * @return The collision component of the player.
     */
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    /**
     * Sets the collision component of the player.
     *
     * @param collisionComponent The collision component to set.
     */
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }

    /**
     * Draws the player.
     * This method should be implemented in the concrete player classes.
     */
    public abstract void draw();

    /**
     * Sets the direction of the player based on the given input.
     *
     * @param direction The direction input.
     */
    public void setDirection(AbstractInput.Inputs direction) {
        switch (direction) {
            case LEFT  -> super.getMovementComponent().setDx(-3);
            case RIGHT -> super.getMovementComponent().setDx(3);
            case IDLE  -> super.getMovementComponent().setDx(0);
        }
        directionChanged = true;
    }

    /**
     * Checks if the direction of the player has changed.
     *
     * @return True if the direction has changed, false otherwise.
     */
    public boolean isDirectionChanged() {
        return directionChanged;
    }

    /**
     * Sets whether the direction of the player has changed.
     *
     * @param directionChanged True if the direction has changed, false otherwise.
     */
    public void setDirectionChanged(boolean directionChanged) {
        this.directionChanged = directionChanged;
    }

    /**
     * Retrieves the level component of the player.
     *
     * @return The level component of the player.
     */
    public LevelComponent getLevelComponent() {
        return levelComponent;
    }
}
