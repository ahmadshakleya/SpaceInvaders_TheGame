package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractLabel;

import java.awt.*;

public class J2DLevel extends AbstractLabel {
    J2DGraphicsContext grCtx;

    public J2DLevel(int level, J2DGraphicsContext grCtx) {
        super(grCtx.getScreenWidth()/ (4*grCtx.getSize()), 1, grCtx.getScreenWidth()/300, grCtx.getScreenHeight()/200, level, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setFont(new Font("Arial", Font.BOLD, getSizeComponent().getSize()*getCollisionComponent().getHitboxWidth()));
        g2d.setColor(Color.WHITE);

        // Draw the score in the upper left corner
        g2d.drawString("Level: " + getLabelValueComponent().getLabelValue(), getPositionComponent().getX()*size, getPositionComponent().getY()*size + 5);
    }
}
