package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;

public abstract class AbstractBarrier extends AbstractFigure{
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
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, healthValue, 0, screenWidth, screenHeight, size);
    }

    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }

}
