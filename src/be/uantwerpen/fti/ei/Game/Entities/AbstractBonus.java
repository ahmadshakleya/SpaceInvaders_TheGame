package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

/**
 * Represents an abstract bonus in the Space Invaders game.
 * An abstract bonus is a special type of figure that provides bonuses to the player.
 * This class extends the AbstractFigure class and adds a bonus component.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractBonus extends AbstractFigure {
    private final BonusComponent bonusComponent;

    /**
     * Constructs a new AbstractBonus with the specified parameters.
     *
     * @param x              the initial x-coordinate of the bonus
     * @param y              the initial y-coordinate of the bonus
     * @param dx             the horizontal speed of the bonus
     * @param dy             the vertical speed of the bonus
     * @param traagheid      the inertia of the bonus's movement
     * @param hitboxWidth    the width of the bonus's collision hitbox
     * @param hitboxHeight   the height of the bonus's collision hitbox
     * @param typeBonus      the type of bonus
     * @param score          the score of the bonus
     * @param screenWidth   the width of the game screen
     * @param screenHeight  the height of the game screen
     * @param size           the size of the bonus
     * @param soundFile      the sound file associated with the bonus
     */
    public AbstractBonus(int x,
                         int y,
                         int dx,
                         int dy,
                         int traagheid,
                         int hitboxWidth,
                         int hitboxHeight,
                         String typeBonus,
                         int score,
                         int screenWidth,
                         int screenHeight,
                         int size,
                         String soundFile) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, 1, score, screenWidth, screenHeight, size, soundFile);
        bonusComponent = new BonusComponent(typeBonus);
    }

    /**
     * Retrieves the position component of the bonus.
     *
     * @return the position component
     */
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    /**
     * Sets the position component of the bonus.
     *
     * @param positionComponent the position component to set
     */
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    /**
     * Retrieves the movement component of the bonus.
     *
     * @return the movement component
     */
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    /**
     * Sets the movement component of the bonus.
     *
     * @param movementComponent the movement component to set
     */
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    /**
     * Retrieves the bonus component of the bonus.
     *
     * @return the bonus component
     */
    public BonusComponent getBonusComponent() {
        return bonusComponent;
    }

    /**
     * Retrieves the collision component of the bonus.
     *
     * @return the collision component
     */
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    /**
     * Sets the collision component of the bonus.
     *
     * @param collisionComponent the collision component to set
     */
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }

    /**
     * Retrieves the sound component of the bonus.
     *
     * @return the sound component
     */
    @Override
    public SoundComponent getSoundComponent() {
        return super.getSoundComponent();
    }

    /**
     * Sets the sound component of the bonus.
     *
     * @param soundComponent the sound component to set
     */
    @Override
    public void setSoundComponent(SoundComponent soundComponent) {
        super.setSoundComponent(soundComponent);
    }
}
