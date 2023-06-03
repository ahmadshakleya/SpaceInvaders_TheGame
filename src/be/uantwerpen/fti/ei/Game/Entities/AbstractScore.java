package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

public abstract class AbstractScore extends AbstractFigure{
    public AbstractScore(int x,
                         int y,
                         int breedte,
                         int lengte,
                         int score,
                         int screenWidth,
                         int screenHeight,
                         int size) {
        super(x, y, 0, 0, 0, breedte, lengte, 1, score, screenWidth, screenHeight, size);
    }
    @Override
    public PositionComponent getPositionComponent() {
        return super.getPositionComponent();
    }

    @Override
    public void setPositionComponent(PositionComponent positionComponent) {
        super.setPositionComponent(positionComponent);
    }

    @Override
    public MovementComponent getMovementComponent() {
        return super.getMovementComponent();
    }

    @Override
    public void setMovementComponent(MovementComponent movementComponent) {
        super.setMovementComponent(movementComponent);
    }

    @Override
    public CollisionComponent getCollisionComponent() {
        return super.getCollisionComponent();
    }

    @Override
    public void setCollisionComponent(CollisionComponent collisionComponent) {
        super.setCollisionComponent(collisionComponent);
    }

    @Override
    public HealthComponent getHealthComponent() {
        return super.getHealthComponent();
    }

    @Override
    public void setHealthComponent(HealthComponent healthComponent) {
        super.setHealthComponent(healthComponent);
    }

    @Override
    public ScoreComponent getScoreComponent() {
        return super.getScoreComponent();
    }

    @Override
    public void setScoreComponent(ScoreComponent scoreComponent) {
        super.setScoreComponent(scoreComponent);
    }

    @Override
    public SizeComponent getSizeComponent() {
        return super.getSizeComponent();
    }

    @Override
    public void setSizeComponent(SizeComponent sizeComponent) {
        super.setSizeComponent(sizeComponent);
    }
}
