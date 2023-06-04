package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bonus extends AbstractBonus {
    private GraphicsContext grCtx;
    private BufferedImage image = null;

    public Bonus(int x, GraphicsContext grCtx) { // x = grCtx.getScreenWidth()/grCtx.getSize()
        super(x, grCtx.getScreenHeight()/(grCtx.getSize()*7), 0, 1, 2, grCtx.getScreenWidth()/200,grCtx.getScreenHeight()/250, false, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.bonusSprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
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
