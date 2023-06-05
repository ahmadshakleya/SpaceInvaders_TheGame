package be.uantwerpen.fti.ei.UI_CUBE;

import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Represents the player in the CUBE UI.
 *
 * @author Ahmad Shakleya
 */
public class PlayerCUBE extends AbstractPlayer {
    private final GraphicsContextCUBE grCtx;

    /**
     * Constructs a PlayerCUBE object with the specified graphics context.
     *
     * @param grCtx The GraphicsContextCUBE object.
     */
    public PlayerCUBE(GraphicsContextCUBE grCtx) {
        super(1, 90 * grCtx.getScreenHeight() / (100 * grCtx.getSize()), 0, 0, 0, grCtx.getScreenWidth() / 100, grCtx.getScreenHeight() / 200, 3, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), 0, "\\src\\resource\\Audio\\spacesound.wav");
        this.grCtx = grCtx;
        try {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            File file = new File(path + getSoundComponent().getSound());
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the audio clip continuously
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Draws the player on the graphics context.
     */
    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.setColor(new Color(170, 0, 0));
        g2d.fillRect(super.getPositionComponent().getX() * size, super.getPositionComponent().getY() * size, getCollisionComponent().getHitboxWidth() * size, getCollisionComponent().getHitboxHeight() * size);
    }
}
