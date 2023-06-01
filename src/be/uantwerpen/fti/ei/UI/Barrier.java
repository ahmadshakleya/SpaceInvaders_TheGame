package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBarrier;

import java.awt.*;

public class Barrier extends AbstractBarrier {
    private GraphicsContext grCtx;

    public Barrier(int x, GraphicsContext grCtx) {
        super(x, grCtx.getScreenHeight()/ grCtx.getSize() - 20, 0, 0, 0, 12, 5, 20, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(170,170,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, size* getCollisionComponent().getHitboxWidth(), size* getCollisionComponent().getHitboxHeight());
    }
}
