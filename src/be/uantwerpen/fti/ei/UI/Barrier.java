package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBarrier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Barrier extends AbstractBarrier {
    private GraphicsContext grCtx;
    private BufferedImage image = null;

    public Barrier(int x, GraphicsContext grCtx) {
        super(x, 70*grCtx.getScreenHeight()/(grCtx.getSize()*100), 0, 0, 0, grCtx.getScreenWidth()/80, grCtx.getScreenHeight()/70, 5, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.barrierSprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
    }
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        //g2d.setColor(new Color(170,170,0));
        //g2d.fillRect(super.getPositionComponent().getX(), super.getPositionComponent().getY(), getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, null);
    }
}
