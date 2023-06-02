package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bonus extends AbstractBonus {
    private GraphicsContext grCtx;


    public Bonus(GraphicsContext grCtx) {
        super((int) (grCtx.getGameCellsX()*(7.5/ grCtx.getSize())), grCtx.getGameCellsY()/8, -10, 0, 1, grCtx.getScreenWidth()/50,grCtx.getScreenHeight()/30, false, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        //g2d.setColor(new Color(0, 170,0));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, size* getCollisionComponent().getHitboxWidth(), size* getCollisionComponent().getHitboxHeight());
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/resource/bonus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight(), null);
    }

}
