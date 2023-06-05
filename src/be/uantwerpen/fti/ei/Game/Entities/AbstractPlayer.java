package be.uantwerpen.fti.ei.Game.Entities;

import be.uantwerpen.fti.ei.Game.Components.CollisionComponent;
import be.uantwerpen.fti.ei.Game.Components.LevelComponent;
import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;

public abstract class AbstractPlayer extends AbstractFigure{
    private LevelComponent levelComponent;
    private boolean directionChanged = false;
    int GameCellsX;
    int GameCellsY;

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
                          int GameCellsX,
                          int GameCellsY,
                          int level,
                          String soundFile) {
        super(x, y, dx, dy, traagheid, hitboxWidth, hitboxHeight, healthValue, HighScore, screenWidth, screenHeight, size, soundFile);
        this.GameCellsX = GameCellsX;
        this.GameCellsY = GameCellsY;
        this.levelComponent = new LevelComponent(level);
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

    public abstract void draw();
    ///public abstract void update();
    public void setDirection(AbstractInput.Inputs direction) {
        switch (direction) {
            case LEFT  -> { super.getMovementComponent().setDx(-GameCellsX/20);}
            case RIGHT -> { super.getMovementComponent().setDx(GameCellsX/20);}
            case IDLE -> { super.getMovementComponent().setDx(0);}
        }
        directionChanged = true;
    }

    public boolean isDirectionChanged() {
        return directionChanged;
    }

    public void setDirectionChanged(boolean directionChanged) {
        this.directionChanged = directionChanged;
    }

    public LevelComponent getLevelComponent() {
        return levelComponent;
    }

    public void setLevelComponent(LevelComponent levelComponent) {
        this.levelComponent = levelComponent;
    }
}
