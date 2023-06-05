package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBarrier;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents a barrier in the J2D UI.
 *
 * @author Ahmad Shakleya
 */
public class J2DBarrier extends AbstractBarrier {
    private final J2DGraphicsContext grCtx;
    private BufferedImage image;

    int initialHealthValue;

    /**
     * Constructs a J2DBarrier object with the specified coordinates and graphics context.
     *
     * @param x     The x-coordinate of the barrier.
     * @param grCtx The J2DGraphicsContext object.
     */
    public J2DBarrier(int x, J2DGraphicsContext grCtx) {
        super(x, 70 * grCtx.getScreenHeight() / (grCtx.getSize() * 100), 0, 0, 0, grCtx.getScreenWidth() / 80, grCtx.getScreenHeight() / 70, 5, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.barrierSprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
        initialHealthValue = getHealthComponent().getHealthValue();
    }

    /**
     * Draws the barrier on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        image = grCtx.resizeImage(image, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), (int) (getHealthComponent().getHealthValue() * 100.0 * getCollisionComponent().getHitboxHeight() / (100.0 * initialHealthValue) * grCtx.getSize()));
        g2d.drawImage(image, super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, null);
    }
}
