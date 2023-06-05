package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBarrier;

import java.awt.*;

/**
 * Represents a barrier entity in the CUBE game.
 * Extends the AbstractBarrier class.
 *
 * @author Ahmad Shakleya
 */
public class BarrierCUBE extends AbstractBarrier {
    private final GraphicsContextCUBE grCtx;
    private final int initialHealthValue;

    /**
     * Constructs a new BarrierCUBE object.
     *
     * @param x     The x-coordinate of the barrier.
     * @param grCtx The graphics context associated with the barrier.
     */
    public BarrierCUBE(int x, GraphicsContextCUBE grCtx) {
        super(x, 70 * grCtx.getScreenHeight() / (grCtx.getSize() * 100), 0, 0, 0, grCtx.getScreenWidth() / 80, grCtx.getScreenHeight() / 70, 5, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
        initialHealthValue = getHealthComponent().getHealthValue();
    }

    /**
     * Draws the barrier on the screen.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(170, 170, 0));
        g2d.fillRect(super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, getCollisionComponent().getHitboxWidth() * size, (int) ((10.0 * getHealthComponent().getHealthValue() / (10.0 * initialHealthValue)) * getCollisionComponent().getHitboxHeight()) * size);
    }
}
