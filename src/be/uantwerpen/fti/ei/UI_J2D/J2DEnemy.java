package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2DEnemy extends AbstractEnemy {
    private J2DGraphicsContext grCtx;
    private int GameCellsX;
    private int GameCellsY;
    private BufferedImage image = null;

    public J2DEnemy(int x, int y, J2DGraphicsContext grCtx) {
        super(x, y, grCtx.getGameCellsX()/20, grCtx.getGameCellsY()/20, 20, grCtx.getScreenWidth()/200, grCtx.getScreenHeight()/250, 1, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.enemySprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        //g2d.setColor(new Color(0, 170,0));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, null);
    }
}
