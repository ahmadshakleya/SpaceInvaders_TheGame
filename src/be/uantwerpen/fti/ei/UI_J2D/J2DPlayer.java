package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.max;

public class J2DPlayer extends AbstractPlayer {
    private J2DGraphicsContext grCtx;
    private BufferedImage image = null;

    public J2DPlayer(J2DGraphicsContext grCtx) {
        super(1, 90*grCtx.getScreenHeight()/(100*grCtx.getSize()), 0, 0, 0, grCtx.getScreenWidth()/100, grCtx.getScreenHeight()/200, 3, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), grCtx.getGameCellsX(), grCtx.getGameCellsY(), 0);
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.playerSprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, null);
        //g2d.setColor(new Color(170,0,0));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight());
    }
}
