package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.*;

public abstract class AbstractFigure {
    private PositionComponent positionComponent;
    private MovementComponent movementComponent;
    private CollisionComponent collisionComponent;
    private HealthComponent healthComponent;

    private ScoreComponent scoreComponent;

    private SizeComponent sizeComponent;

    public AbstractFigure(int x,
                          int y,
                          int dx,
                          int dy,
                          int traagheid,
                          int hitboxWidth,
                          int hitboxHeight,
                          int healthValue,
                          int score,
                          int screenWidth,
                          int screenHeight,
                          int size) {
        this.positionComponent = new PositionComponent(x,y);
        this.movementComponent = new MovementComponent(dx, dy, traagheid);
        this.collisionComponent = new CollisionComponent(hitboxWidth, hitboxHeight);
        this.healthComponent = new HealthComponent(healthValue);
        this.scoreComponent = new ScoreComponent(score);
        this.sizeComponent = new SizeComponent(screenWidth, screenHeight, size);
    }

    public PositionComponent getPositionComponent() {
        return positionComponent;
    }

    public void setPositionComponent(PositionComponent positionComponent) {
        this.positionComponent = positionComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public void setMovementComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }

    public CollisionComponent getCollisionComponent() {
        return collisionComponent;
    }

    public void setCollisionComponent(CollisionComponent collisionComponent) {
        this.collisionComponent = collisionComponent;
    }

    public HealthComponent getHealthComponent() {
        return healthComponent;
    }

    public void setHealthComponent(HealthComponent healthComponent) {
        this.healthComponent = healthComponent;
    }

    public ScoreComponent getScoreComponent() {
        return scoreComponent;
    }

    public void setScoreComponent(ScoreComponent scoreComponent) {
        this.scoreComponent = scoreComponent;
    }


    public SizeComponent getSizeComponent() {
        return sizeComponent;
    }

    public void setSizeComponent(SizeComponent sizeComponent) {
        this.sizeComponent = sizeComponent;
    }

    public int x() {
        return positionComponent.getX();
    }
    public int y() {
        return positionComponent.getY();
    }

    public int dx() {
        return movementComponent.getDx();
    }
    public int dy() {
        return movementComponent.getDy();
    }

    public int snelheid() {
        return movementComponent.getTraagheid();
    }
    public int w() {
        return collisionComponent.getHitboxWidth();
    }
    public int h() {
        return collisionComponent.getHitboxHeight();
    }

    public abstract void draw();
    ///public abstract void update();


}
