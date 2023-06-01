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

public class Player extends AbstractPlayer {
    private GraphicsContext grCtx;

    public Player(GraphicsContext grCtx) {
        super(120, grCtx.getScreenHeight()/ grCtx.getSize() - 10, 0, 0, 1, 10, 5, 3, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize());
        this.grCtx = grCtx;
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/resource/player-sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, size*getCollisionComponent().getHitboxWidth(), size* getCollisionComponent().getHitboxHeight(), null);
    }
}
