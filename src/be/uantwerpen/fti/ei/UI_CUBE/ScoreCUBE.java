package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

/**
 * Represents the score label in the CUBE UI.
 *
 * @author Ahmad Shakleya
 */
public class ScoreCUBE extends AbstractLabel {
    private final GraphicsContextCUBE grCtx;

    /**
     * Constructs a ScoreCUBE object with the specified score and graphics context.
     *
     * @param score The score value.
     * @param grCtx The GraphicsContextCUBE object.
     */
    public ScoreCUBE(int score, GraphicsContextCUBE grCtx) {
        super(1, 1, grCtx.getScreenWidth() / 300, grCtx.getScreenHeight() / 200, score, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    /**
     * Draws the score label on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size * getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        g2d.drawString("Score: " + getLabelValueComponent().getLabelValue(), getPositionComponent().getX() * size, (getPositionComponent().getY() + getCollisionComponent().getHitboxHeight()) * size);
    }
}
