package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Components.BulletComponent;
import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet extends AbstractBullet {
    private GraphicsContext grCtx;

    public Bullet(int x, int y, int dy, GraphicsContext grCtx) {
        super(x, y, 0, dy,0, grCtx.getScreenWidth()/50, grCtx.getScreenHeight()/20, true, 0,  grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        //g2d.setColor(new Color(0, 0, 170));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, size* getCollisionComponent().getHitboxWidth(), size* getCollisionComponent().getHitboxHeight());
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/resource/bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight(), null);
    }

}
