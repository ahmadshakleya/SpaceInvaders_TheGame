package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerCUBE extends AbstractPlayer {
    private GraphicsContextCUBE grCtx;

    public PlayerCUBE(GraphicsContextCUBE grCtx) {
        super(1, 90*grCtx.getScreenHeight()/(100*grCtx.getSize()), 0, 0, 0, grCtx.getScreenWidth()/100, grCtx.getScreenHeight()/200, 3, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), grCtx.getGameCellsX(), grCtx.getGameCellsY(), 0);
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(170,0,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
    }
}
