package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The J2DHealth class represents a health label in a Java 2D-based game.
 * It extends the AbstractLabel class and handles the rendering of the health label on the screen.
 *
 * @author Ahmad Shakleya
 */
public class J2DHealth extends AbstractLabel {
    private final J2DGraphicsContext grCtx;
    private final BufferedImage image;

    /**
     * Constructs a J2DHealth object with the specified health value and graphics context.
     *
     * @param health The initial health value.
     * @param grCtx  The J2DGraphicsContext object for rendering.
     */
    public J2DHealth(int health, J2DGraphicsContext grCtx) {
        super(grCtx.getScreenWidth() / (2 * grCtx.getSize()), 1, grCtx.getScreenWidth() / 300, grCtx.getScreenHeight() / 200, health, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.playerSprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
    }

    /**
     * Draws the health label on the screen using the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size * getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        g2d.drawString("Health:", getPositionComponent().getX() * size, (getPositionComponent().getY() + getCollisionComponent().getHitboxHeight()) * size);
        g2d.setColor(new Color(170, 0, 0));
        int offsetx = getCollisionComponent().getHitboxWidth();
        for (int healthValue = 1; healthValue <= getLabelValueComponent().getLabelValue(); healthValue++) {
            g2d.drawImage(image, (offsetx + super.getPositionComponent().getX() + getCollisionComponent().getHitboxWidth() * 3 * healthValue) * size, ((getPositionComponent().getY() + getCollisionComponent().getHitboxHeight()) - 1) * size, null);
        }
    }
}
