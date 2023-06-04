package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

public class LevelCUBE extends AbstractLabel {
    GraphicsContextCUBE grCtx;

    public LevelCUBE(int level, GraphicsContextCUBE grCtx) {
        super(20, 1, grCtx.getScreenWidth()/300, grCtx.getScreenHeight()/200, level, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size*getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        // Draw the score in the upper left corner
        g2d.drawString("Level: " + getScoreComponent().getScore(), getPositionComponent().getX()*size, getPositionComponent().getY()*size + 5);
    }
}
