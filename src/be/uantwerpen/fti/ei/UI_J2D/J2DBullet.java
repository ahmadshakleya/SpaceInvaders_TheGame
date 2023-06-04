package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class J2DBullet extends AbstractBullet {
    private J2DGraphicsContext grCtx;
    private BufferedImage image = null;
    private Clip clip;
    private Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    private File file;
    public J2DBullet(int x, int y, int dy, J2DGraphicsContext grCtx) {
        super(x, y, 0, dy,0, grCtx.getScreenWidth()/500, grCtx.getScreenHeight()/200, true, 0,  grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), "\\src\\resource\\bulletSound.wav");
        this.grCtx = grCtx;
        if (dy > 0) {
            image = grCtx.resizeImage(grCtx.enemyBulletSprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
        } else {
            image = grCtx.resizeImage(grCtx.playerBulletSprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
        }
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
        //g2d.setColor(new Color(0, 0, 170));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth()*size, getCollisionComponent().getHitboxHeight()*size);
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, null);
    }

}