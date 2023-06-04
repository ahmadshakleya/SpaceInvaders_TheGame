package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class BulletCUBE extends AbstractBullet {
    private GraphicsContextCUBE grCtx;
    private Clip clip;
    private Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    private File file;
    public BulletCUBE(int x, int y, int dy, GraphicsContextCUBE grCtx) {
        super(x, y, 0, dy,0, grCtx.getScreenWidth()/500, grCtx.getScreenHeight()/200, true, 0,  grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), "\\src\\resource\\bulletSound.wav");
        this.grCtx = grCtx;
        try {
            file = new File(path + getSoundComponent().getSound());
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        clip.start();
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        if (getMovementComponent().getDy() > 0) {
            g2d.setColor(new Color(170, 0, 0));
        } else {
            g2d.setColor(new Color(0, 0, 170));
        }
        g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
    }

}