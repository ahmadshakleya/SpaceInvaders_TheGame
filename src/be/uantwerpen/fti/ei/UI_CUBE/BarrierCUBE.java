package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBarrier;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BarrierCUBE extends AbstractBarrier {
    private GraphicsContextCUBE grCtx;

    public BarrierCUBE(int x, GraphicsContextCUBE grCtx) {
        super(x, 70*grCtx.getScreenHeight()/(grCtx.getSize()*100), 0, 0, 0, grCtx.getScreenWidth()/80, grCtx.getScreenHeight()/70, 5, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(170,170,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
    }
}