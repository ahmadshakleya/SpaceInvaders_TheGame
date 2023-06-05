package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents an enemy in the J2D UI.
 *
 * @author Ahmad Shakleya
 */
public class J2DEnemy extends AbstractEnemy {
    private final J2DGraphicsContext grCtx;
    private final BufferedImage image;

    /**
     * Constructs a J2DEnemy object with the specified coordinates and graphics context.
     *
     * @param x     The x-coordinate of the enemy.
     * @param y     The y-coordinate of the enemy.
     * @param grCtx The J2DGraphicsContext object.
     */
    public J2DEnemy(int x, int y, J2DGraphicsContext grCtx) {
        super(x, y, 3, 3, 20, grCtx.getScreenWidth() / 200, grCtx.getScreenHeight() / 250, 1, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.enemySprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
    }

    /**
     * Draws the enemy on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.drawImage(image, super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, null);
    }
}
