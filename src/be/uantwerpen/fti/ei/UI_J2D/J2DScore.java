package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

/**
 * The J2DScore class represents a score label in a Java 2D-based game.
 * It extends the AbstractLabel class and is responsible for rendering the score on the screen.
 *
 * @author Ahmad Shakleya
 */
public class J2DScore extends AbstractLabel {
    private final J2DGraphicsContext grCtx;

    /**
     * Constructs a J2DScore object with the specified score value and graphics context.
     *
     * @param score The score value to display.
     * @param grCtx The J2DGraphicsContext object for rendering the score.
     */
    public J2DScore(int score, J2DGraphicsContext grCtx) {
        super(1, 1, grCtx.getScreenWidth() / 300, grCtx.getScreenHeight() / 200, score, grCtx.getScreenWidth(),
                grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    /**
     * Renders the score on the screen.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size * getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        g2d.drawString("Score: " + getLabelValueComponent().getLabelValue(), getPositionComponent().getX() * size,
                (getPositionComponent().getY() + getCollisionComponent().getHitboxHeight()) * size);
    }
}
