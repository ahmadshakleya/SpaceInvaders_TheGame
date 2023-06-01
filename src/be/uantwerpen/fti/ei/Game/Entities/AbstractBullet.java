package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.BulletComponent;
import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;

public abstract class AbstractBullet extends AbstractFigure {
    private BulletComponent bulletComponent;

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

    public BulletComponent getBulletComponent() {
        return bulletComponent;
    }

    public void setBulletComponent(BulletComponent bulletComponent) {
        this.bulletComponent = bulletComponent;
    }
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }
}
