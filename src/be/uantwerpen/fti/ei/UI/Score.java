package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Entities.AbstractScore;

import java.awt.*;

public class Score extends AbstractScore {
    private GraphicsContext grCtx;
    public Score(int score, GraphicsContext grCtx) {
        super(1, 1, grCtx.getScreenWidth()/300, grCtx.getScreenHeight()/200, score, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, size*getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        // Draw the score in the upper left corner
        g2d.drawString("Score: " + getScoreComponent().getScore(), getPositionComponent().getX()*size, getPositionComponent().getY()*size + 5);
    }
}
