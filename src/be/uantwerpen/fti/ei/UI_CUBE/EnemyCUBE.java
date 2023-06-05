package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyCUBE extends AbstractEnemy {
    private GraphicsContextCUBE grCtx;

    public EnemyCUBE(int x, int y, GraphicsContextCUBE grCtx) {
        super(x, y, grCtx.getGameCellsX()/20, grCtx.getGameCellsY()/20, 20, grCtx.getScreenWidth()/200, grCtx.getScreenHeight()/250, 1, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(0, 170,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
    }
}
