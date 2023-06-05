package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

/**
 * The J2DLevel class represents a level label in a Java 2D-based game.
 * It extends the AbstractLabel class and is responsible for rendering the level information on the screen.
 *
 * @author Ahmad Shakleya
 */
public class J2DLevel extends AbstractLabel {
    private final J2DGraphicsContext grCtx;

    /**
     * Constructs a J2DLevel object with the specified level and graphics context.
     *
     * @param level The level value to be displayed.
     * @param grCtx The J2DGraphicsContext object for rendering the level label.
     */
    public J2DLevel(int level, J2DGraphicsContext grCtx) {
        super(grCtx.getScreenWidth() / (4 * grCtx.getSize()), 1, grCtx.getScreenWidth() / 300,
                grCtx.getScreenHeight() / 200, level, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    /**
     * Renders the level label on the screen.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, getSizeComponent().getSize() * getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        g2d.drawString("Level: " + getLabelValueComponent().getLabelValue(),
                getPositionComponent().getX() * size, (getPositionComponent().getY() + getCollisionComponent().getHitboxHeight()) * size);
    }
}
