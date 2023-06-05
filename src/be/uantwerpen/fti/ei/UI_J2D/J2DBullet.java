package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Represents a bullet in the J2D UI.
 *
 * @author Ahmad Shakleya
 */
public class J2DBullet extends AbstractBullet {
    private final J2DGraphicsContext grCtx;
    private final BufferedImage image;

    private FloatControl volumeControl; // Added FloatControl reference

    /**
     * Constructs a J2DBullet object with the specified coordinates and graphics context.
     *
     * @param x     The x-coordinate of the bullet.
     * @param y     The y-coordinate of the bullet.
     * @param dy    The vertical velocity of the bullet.
     * @param grCtx The J2DGraphicsContext object.
     */
    public J2DBullet(int x, int y, int dy, J2DGraphicsContext grCtx) {
        super(x, y, 0, dy, 0, grCtx.getScreenWidth() / 500, grCtx.getScreenHeight() / 200, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), "\\src\\resource\\Audio\\bulletSound.wav");
        this.grCtx = grCtx;
        if (dy > 0) {
            image = grCtx.resizeImage(grCtx.enemyBulletSprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
        } else {
            image = grCtx.resizeImage(grCtx.playerBulletSprite, getCollisionComponent().getHitboxWidth() * grCtx.getSize(), getCollisionComponent().getHitboxHeight() * grCtx.getSize());
        }
        Clip clip;
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            File file = new File(path + getSoundComponent().getSound());
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        float gain = (float) (Math.log10(0.1) * 20);
        volumeControl.setValue(gain);
        clip.start();
    }

    /**
     * Draws the bullet on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.drawImage(image, super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, null);
    }
}
