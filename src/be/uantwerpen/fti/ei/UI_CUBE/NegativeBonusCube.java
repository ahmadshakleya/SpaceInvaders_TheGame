package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.awt.*;

public class NegativeBonusCube extends AbstractBonus {
    private GraphicsContextCUBE grCtx;

    public NegativeBonusCube(int x, GraphicsContextCUBE grCtx) {
        super(x, grCtx.getScreenHeight()/(grCtx.getSize()*7), 0, 1, 2, grCtx.getScreenWidth()/200,grCtx.getScreenHeight()/250, false, -10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(170, 0,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
    }
}
