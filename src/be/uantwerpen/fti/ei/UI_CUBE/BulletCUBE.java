package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Represents a bullet entity in the CUBE game.
 * Extends the AbstractBullet class.
 *
 * @author Ahmad Shakleya
 */
public class BulletCUBE extends AbstractBullet {
    private final GraphicsContextCUBE grCtx;
    private FloatControl volumeControl; // Added FloatControl reference

    /**
     * Constructs a new BulletCUBE object.
     *
     * @param x     The x-coordinate of the bullet.
     * @param y     The y-coordinate of the bullet.
     * @param dy    The change in y-coordinate per frame.
     * @param grCtx The graphics context associated with the bullet.
     */
    public BulletCUBE(int x, int y, int dy, GraphicsContextCUBE grCtx) {
        super(x, y, 0, dy, 0, grCtx.getScreenWidth() / 500, grCtx.getScreenHeight() / 200, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), "\\src\\resource\\Audio\\bulletSound.wav");
        this.grCtx = grCtx;
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
     * Draws the bullet on the screen.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        if (getMovementComponent().getDy() > 0) {
            g2d.setColor(new Color(170, 0, 0));
        } else {
            g2d.setColor(new Color(0, 0, 170));
        }
        g2d.fillRect(super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, getCollisionComponent().getHitboxWidth() * size, getCollisionComponent().getHitboxHeight() * size);
    }
}
