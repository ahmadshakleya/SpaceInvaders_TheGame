package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBonus;

import java.awt.*;

/**
 * Represents a positive bonus in the CUBE UI.
 *
 * @author Ahmad Shakleya
 */
public class PositiveBonusCUBE extends AbstractBonus {
    private final GraphicsContextCUBE grCtx;

    /**
     * Constructs a PositiveBonusCUBE object with the specified coordinates and graphics context.
     *
     * @param x     The x-coordinate of the bonus.
     * @param grCtx The GraphicsContextCUBE object.
     */
    public PositiveBonusCUBE(int x, GraphicsContextCUBE grCtx) {
        super(x, grCtx.getScreenHeight() / (grCtx.getSize() * 7), 0, 1, 2, grCtx.getScreenWidth() / 200, grCtx.getScreenHeight() / 250, "+", 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
    }

    /**
     * Draws the positive bonus on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(0, 170, 0));
        g2d.fillRect(super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, getCollisionComponent().getHitboxWidth() * size, getCollisionComponent().getHitboxHeight() * size);
    }
}
