package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

/**
 * Represents a level label in the CUBE UI.
 *
 * @author Ahmad Shakleya
 */
public class LevelCUBE extends AbstractLabel {
    GraphicsContextCUBE grCtx;

    /**
     * Constructs a LevelCUBE object with the specified level and graphics context.
     *
     * @param level  The level value.
     * @param grCtx  The GraphicsContextCUBE object.
     */
    public LevelCUBE(int level, GraphicsContextCUBE grCtx) {
        super(grCtx.getScreenWidth() / (4 * grCtx.getSize()), 1, grCtx.getScreenWidth() / 300, grCtx.getScreenHeight() / 200, level, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    /**
     * Draws the level label on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        g2d.setFont(new Font("Arial", Font.BOLD, getSizeComponent().getSize() * getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);
        int size = grCtx.getSize();
        g2d.drawString("Level: " + getLabelValueComponent().getLabelValue(), getPositionComponent().getX() * getSizeComponent().getSize(), (getPositionComponent().getY() + getCollisionComponent().getHitboxHeight()) * size);
    }
}
