package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.awt.*;

public class Enemy extends AbstractEnemy {
    private GraphicsContext grCtx;
    private int GameCellsX;
    private int GameCellsY;


    public Enemy(int x, int y, GraphicsContext grCtx) {
        super(x, y, 1, 1, 0, 2, 2, 1, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(0, 170,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, size* getCollisionComponent().getHitboxWidth(), size* getCollisionComponent().getHitboxHeight());
    }
}
