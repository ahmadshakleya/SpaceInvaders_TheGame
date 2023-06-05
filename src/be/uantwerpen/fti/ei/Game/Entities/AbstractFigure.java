package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

/**
 * Represents an abstract figure in the Space Invaders game.
 * An abstract figure has position, movement, collision, health, score, size, and sound components.
 * This class provides a base implementation for entities in the game.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractFigure {
    private PositionComponent positionComponent;
    private MovementComponent movementComponent;
    private CollisionComponent collisionComponent;
    private HealthComponent healthComponent;
    private ScoreComponent scoreComponent;
    private SizeComponent sizeComponent;
    private SoundComponent soundComponent;

    /**
     * Constructs a new AbstractFigure with the specified parameters.
     *
     * @param x              the initial x-coordinate of the figure
     * @param y              the initial y-coordinate of the figure
     * @param dx             the horizontal speed of the figure
     * @param dy             the vertical speed of the figure
     * @param traagheid      the inertia of the figure's movement
     * @param hitboxWidth    the width of the figure's collision hitbox
     * @param hitboxHeight   the height of the figure's collision hitbox
     * @param healthValue    the health value of the figure
     * @param score          the score of the figure
     * @param screenWidth   the width of the game screen
     * @param screenHeight  the height of the game screen
     * @param size           the size of the figure
     * @param soundFile      the sound file associated with the figure
     */
    public AbstractFigure(int x, int y, int dx, int dy, int traagheid, int hitboxWidth, int hitboxHeight,
                          int healthValue, int score, int screenWidth, int screenHeight, int size, String soundFile) {
        this.positionComponent = new PositionComponent(x, y);
        this.movementComponent = new MovementComponent(dx, dy, traagheid);
        this.collisionComponent = new CollisionComponent(hitboxWidth, hitboxHeight);
        this.healthComponent = new HealthComponent(healthValue);
        this.scoreComponent = new ScoreComponent(score);
        this.sizeComponent = new SizeComponent(screenWidth, screenHeight, size);
        this.soundComponent = new SoundComponent(soundFile);
    }

    // Getter and setter methods for the components

    /**
     * Retrieves the position component of the figure.
     *
     * @return the position component
     */
    public PositionComponent getPositionComponent() {
        return positionComponent;
    }

    /**
     * Sets the position component of the figure.
     *
     * @param positionComponent the position component to set
     */
    public void setPositionComponent(PositionComponent positionComponent) {
        this.positionComponent = positionComponent;
    }

    /**
     * Retrieves the movement component of the figure.
     *
     * @return the movement component
     */
    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    /**
     * Sets the movement component of the figure.
     *
     * @param movementComponent the movement component to set
     */
    public void setMovementComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }

    /**
     * Retrieves the collision component of the figure.
     *
     * @return the collision component
     */
    public CollisionComponent getCollisionComponent() {
        return collisionComponent;
    }

    /**
     * Sets the collision component of the figure.
     *
     * @param collisionComponent the collision component to set
     */
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        this.collisionComponent = collisionComponent;
    }

    /**
     * Retrieves the health component of the figure.
     *
     * @return the health component
     */
    public HealthComponent getHealthComponent() {
        return healthComponent;
    }

    /**
     * Sets the health component of the figure.
     *
     * @param healthComponent the health component to set
     */
    public void setHealthComponent(HealthComponent healthComponent) {
        this.healthComponent = healthComponent;
    }

    /**
     * Retrieves the score component of the figure.
     *
     * @return the score component
     */
    public ScoreComponent getScoreComponent() {
        return scoreComponent;
    }

    /**
     * Sets the score component of the figure.
     *
     * @param scoreComponent the score component to set
     */
    public void setScoreComponent(ScoreComponent scoreComponent) {
        this.scoreComponent = scoreComponent;
    }

    /**
     * Retrieves the size component of the figure.
     *
     * @return the size component
     */
    public SizeComponent getSizeComponent() {
        return sizeComponent;
    }

    /**
     * Sets the size component of the figure.
     *
     * @param sizeComponent the size component to set
     */
    public void setSizeComponent(SizeComponent sizeComponent) {
        this.sizeComponent = sizeComponent;
    }

    /**
     * Retrieves the sound component of the figure.
     *
     * @return the sound component
     */
    public SoundComponent getSoundComponent() {
        return soundComponent;
    }

    /**
     * Sets the sound component of the figure.
     *
     * @param soundComponent the sound component to set
     */
    public void setSoundComponent(SoundComponent soundComponent) {
        this.soundComponent = soundComponent;
    }

    // Helper methods to retrieve figure properties

    /**
     * Retrieves the x-coordinate of the figure.
     *
     * @return the x-coordinate
     */
    public int x() {
        return positionComponent.getX();
    }

    /**
     * Retrieves the y-coordinate of the figure.
     *
     * @return the y-coordinate
     */
    public int y() {
        return positionComponent.getY();
    }

    /**
     * Retrieves the horizontal speed of the figure.
     *
     * @return the horizontal speed
     */
    public int dx() {
        return movementComponent.getDx();
    }

    /**
     * Retrieves the vertical speed of the figure.
     *
     * @return the vertical speed
     */
    public int dy() {
        return movementComponent.getDy();
    }

    /**
     * Retrieves the inertia of the figure's movement.
     *
     * @return the inertia
     */
    public int snelheid() {
        return movementComponent.getTraagheid();
    }

    /**
     * Retrieves the width of the figure's collision hitbox.
     *
     * @return the hitbox width
     */
    public int w() {
        return collisionComponent.getHitboxWidth();
    }

    /**
     * Retrieves the height of the figure's collision hitbox.
     *
     * @return the hitbox height
     */
    public int h() {
        return collisionComponent.getHitboxHeight();
    }

    /**
     * Abstract method to draw the figure.
     */
    public abstract void draw();
}
