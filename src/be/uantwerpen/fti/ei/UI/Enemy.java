package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends AbstractEnemy {
    private GraphicsContext grCtx;
    private int GameCellsX;
    private int GameCellsY;


    public Enemy(int x, int y, GraphicsContext grCtx) {
        super(x, y, grCtx.getGameCellsX()/20, grCtx.getGameCellsY()/20, 2, grCtx.getScreenWidth()/60, grCtx.getScreenHeight()/50, 1, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
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
            image = ImageIO.read(new File("src/resource/enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight(), null);
    }
}
