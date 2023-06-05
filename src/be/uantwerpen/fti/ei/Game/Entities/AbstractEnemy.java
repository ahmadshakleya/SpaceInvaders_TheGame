package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

public abstract class AbstractEnemy extends AbstractFigure{
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

    @Override
    public SoundComponent getSoundComponent() {
        return super.getSoundComponent();
    }

    @Override
    public void setSoundComponent(SoundComponent soundComponent) {
        super.setSoundComponent(soundComponent);
    }
}
