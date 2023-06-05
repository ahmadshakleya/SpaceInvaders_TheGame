package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2DPositiveBonus extends AbstractBonus {
    private J2DGraphicsContext grCtx;
    private BufferedImage image = null;

    public J2DPositiveBonus(int x, J2DGraphicsContext grCtx) {
        super(x, grCtx.getScreenHeight()/(grCtx.getSize()*7), 0, 1, 2, grCtx.getScreenWidth()/200,grCtx.getScreenHeight()/250, false, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.positiveBonusSprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        //g2d.setColor(new Color(0, 170,0));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight());

        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, null);
    }

}
