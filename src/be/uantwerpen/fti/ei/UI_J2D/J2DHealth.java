package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;
import be.uantwerpen.fti.ei.UI_CUBE.GraphicsContextCUBE;

import java.awt.*;
import java.awt.image.BufferedImage;

public class J2DHealth extends AbstractLabel {
    private J2DGraphicsContext grCtx;
    private BufferedImage image = null;

    public J2DHealth(int health, J2DGraphicsContext grCtx) {
        super(40, 1, grCtx.getScreenWidth()/300, grCtx.getScreenHeight()/200, health, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.playerSprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size*getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        // Draw the score in the upper left corner
        g2d.drawString("Health:", getPositionComponent().getX()*size, getPositionComponent().getY()*size + 5);
        g2d.setColor(new Color(170,0,0));
        int offsetx = 5;
        for (int healthValue = 1; healthValue <= getScoreComponent().getScore(); healthValue++) {
            g2d.drawImage(image, (offsetx + super.getPositionComponent().getX() + 4*healthValue)*size, (super.getPositionComponent().getY() - 1)*size, null);
        }
    }
}
