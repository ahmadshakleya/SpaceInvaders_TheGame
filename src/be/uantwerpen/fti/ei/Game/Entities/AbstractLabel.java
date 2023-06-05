package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

/**
 * Abstract class representing a label entity in the game.
 * Extends the AbstractFigure class.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractLabel extends AbstractFigure {
    private LabelValueComponent labelValueComponent;

    /**
     * Constructs an AbstractLabel object.
     *
     * @param x            The initial x-coordinate of the label.
     * @param y            The initial y-coordinate of the label.
     * @param breedte      The width of the label.
     * @param lengte       The height of the label.
     * @param labelValue   The value associated with the label.
     * @param screenWidth  The width of the game screen.
     * @param screenHeight The height of the game screen.
     * @param size         The size of the label.
     */
    public AbstractLabel(int x,
                         int y,
                         int breedte,
                         int lengte,
                         int labelValue,
                         int screenWidth,
                         int screenHeight,
                         int size) {
        super(x, y, 0, 0, 0, breedte, lengte, 1, 0, screenWidth, screenHeight, size, null);
        this.labelValueComponent = new LabelValueComponent(labelValue);
    }

    /**
     * Retrieves the position component of the label.
     *
     * @return The position component.
     */
    @Override
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    /**
     * Sets the position component of the label.
     *
     * @param positionComponent The position component to set.
     */
    @Override
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    /**
     * Retrieves the movement component of the label.
     *
     * @return The movement component.
     */
    @Override
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    /**
     * Sets the movement component of the label.
     *
     * @param movementComponent The movement component to set.
     */
    @Override
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    /**
     * Retrieves the collision component of the label.
     *
     * @return The collision component.
     */
    @Override
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    /**
     * Sets the collision component of the label.
     *
     * @param collisionComponent The collision component to set.
     */
    @Override
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }

    /**
     * Retrieves the health component of the label.
     *
     * @return The health component.
     */
    @Override
    public HealthComponent getHealthComponent() {
        return super.getHealthComponent();
    }

    /**
     * Sets the health component of the label.
     *
     * @param healthComponent The health component to set.
     */
    @Override
    public void setHealthComponent(HealthComponent healthComponent) {
        super.setHealthComponent(healthComponent);
    }

    /**
     * Retrieves the score component of the label.
     *
     * @return The score component.
     */
    @Override
    public ScoreComponent getScoreComponent() {
        return super.getScoreComponent();
    }

    /**
     * Sets the score component of the label.
     *
     * @param scoreComponent The score component to set.
     */
    @Override
    public void setScoreComponent(ScoreComponent scoreComponent) {
        super.setScoreComponent(scoreComponent);
    }

    /**
     * Retrieves the size component of the label.
     *
     * @return The size component.
     */
    @Override
    public SizeComponent getSizeComponent() {
        return super.getSizeComponent();
    }

    /**
     * Sets the size component of the label.
     *
     * @param sizeComponent The size component to set.
     */
    @Override
    public void setSizeComponent(SizeComponent sizeComponent) {
        super.setSizeComponent(sizeComponent);
    }

    /**
     * Retrieves the label value component of the label.
     *
     * @return The label value component.
     */
    public LabelValueComponent getLabelValueComponent() {
        return labelValueComponent;
    }

    /**
     * Sets the label value component of the label.
     *
     * @param labelValueComponent The label value component to set.
     */
    public void setLabelValueComponent(LabelValueComponent labelValueComponent) {
        this.labelValueComponent = labelValueComponent;
    }
}
