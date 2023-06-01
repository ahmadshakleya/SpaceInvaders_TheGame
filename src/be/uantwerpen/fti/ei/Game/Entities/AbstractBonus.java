package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.BonusComponent;
import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;

public abstract class AbstractBonus extends AbstractFigure {
    private BonusComponent bonusComponent;
    public AbstractBonus(int x,
                         int y,
                         int dx,
                         int dy,
                         int traagheid,
                         int hitboxWidth,
                         int hitboxHeight,
                         boolean bonusActief,
                         int score,
                         int screenWidth,
                         int screenHeight,
                         int size) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, 1, score, screenWidth, screenHeight, size);
        bonusComponent = new BonusComponent(bonusActief);
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

    public BonusComponent getBonusComponent() {
        return bonusComponent;
    }

    public void setBonusComponent(BonusComponent bonusComponent) {
        this.bonusComponent = bonusComponent;
    }
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }
}
