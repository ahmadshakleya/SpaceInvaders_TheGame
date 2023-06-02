package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.Components.MovementComponent;
import be.uantwerpen.fti.ei.Game.Components.PositionComponent;
import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;
import be.uantwerpen.fti.ei.Game.Systems.PlayerMovementSystem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.max;

public class Player extends AbstractPlayer {
    private GraphicsContext grCtx;
    private BufferedImage image = null;

    public Player(GraphicsContext grCtx) {
        super(1, 90*grCtx.getScreenHeight()/(100*grCtx.getSize()), 0, 0, 0, grCtx.getScreenWidth()/30, grCtx.getScreenHeight()/30, 3, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), grCtx.getGameCellsX(), grCtx.getGameCellsY());
        this.grCtx = grCtx;
        try {
            image = ImageIO.read(new File("src/resource/player-sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        //g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight(), null);
        g2d.setColor(new Color(170,0,0));
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight());
    }
}
