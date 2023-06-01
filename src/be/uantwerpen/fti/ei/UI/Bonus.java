package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.awt.*;

public class Bonus extends AbstractBonus {
    private GraphicsContext grCtx;


    public Bonus(GraphicsContext grCtx) {
        super(grCtx.getScreenWidth()/ grCtx.getSize(), 2, -1, 0, 1, 2,2, false, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
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
