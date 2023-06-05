package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The J2DPositiveBonus class represents a positive bonus entity in a Java 2D-based game.
 * It extends the AbstractBonus class and is responsible for rendering the bonus on the screen.
 *
 * @author Ahmad Shakleya
 */
public class J2DPositiveBonus extends AbstractBonus {
    private final J2DGraphicsContext grCtx;
    private final BufferedImage image;

    /**
     * Constructs a J2DPositiveBonus object with the specified x-coordinate and graphics context.
     *
     * @param x     The x-coordinate of the bonus.
     * @param grCtx The J2DGraphicsContext object for rendering the bonus.
     */
    public J2DPositiveBonus(int x, J2DGraphicsContext grCtx) {
        super(x, grCtx.getScreenHeight() / (grCtx.getSize() * 7), 0, 1, 2, grCtx.getScreenWidth() / 200,
                grCtx.getScreenHeight() / 250, "+", 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(),
                grCtx.getSize(), null);
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.positiveBonusSprite,
                getCollisionComponent().getHitboxWidth() * grCtx.getSize(),
                getCollisionComponent().getHitboxHeight() * grCtx.getSize());
    }

    /**
     * Renders the bonus on the screen.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.drawImage(image, super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, null);
    }
}
