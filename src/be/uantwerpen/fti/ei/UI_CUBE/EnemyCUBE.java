package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.awt.*;

/**
 * Represents an enemy entity in the CUBE game.
 * Extends the AbstractEnemy class.
 *
 * @author Ahmad Shakleya
 */
public class EnemyCUBE extends AbstractEnemy {
    private final GraphicsContextCUBE grCtx;

    /**
     * Constructs a new EnemyCUBE object.
     *
     * @param x     The x-coordinate of the enemy.
     * @param y     The y-coordinate of the enemy.
     * @param grCtx The graphics context associated with the enemy.
     */
    public EnemyCUBE(int x, int y, GraphicsContextCUBE grCtx) {
        super(x, y, 3, 3, 20, grCtx.getScreenWidth() / 200, grCtx.getScreenHeight() / 250, 1, 10, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), null);
        this.grCtx = grCtx;
    }

    /**
     * Draws the enemy on the screen.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(0, 170, 0));
        g2d.fillRect(super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, getCollisionComponent().getHitboxWidth() * size, getCollisionComponent().getHitboxHeight() * size);
    }
}
