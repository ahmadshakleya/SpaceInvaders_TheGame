package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

/**
 * Represents the health label in the CUBE game.
 * This class extends the AbstractLabel class.
 *
 * @author Ahmad Shakleya
 */
public class HealthCUBE extends AbstractLabel {
    GraphicsContextCUBE grCtx;

    /**
     * Constructs a HealthCUBE object with the specified health value and GraphicsContextCUBE.
     *
     * @param health The health value.
     * @param grCtx  The GraphicsContextCUBE object.
     */
    public HealthCUBE(int health, GraphicsContextCUBE grCtx) {
        super(grCtx.getScreenWidth() / (2 * grCtx.getSize()), 1, grCtx.getScreenWidth() / 300, grCtx.getScreenHeight() / 200, health, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size * getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        g2d.drawString("Health:", getPositionComponent().getX() * size, getPositionComponent().getY() * size + 5);
        g2d.setColor(new Color(170, 0, 0));
        int offsetx = 5;
        for (int healthValue = 1; healthValue <= getLabelValueComponent().getLabelValue(); healthValue++) {
            g2d.fillRect((offsetx + super.getPositionComponent().getX() + 4 * healthValue) * size, (super.getPositionComponent().getY() - 1) * size, getCollisionComponent().getHitboxWidth() * size, getCollisionComponent().getHitboxHeight() * size);
        }
    }
}
