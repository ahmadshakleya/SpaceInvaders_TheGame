package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static java.lang.Math.max;

public class J2DPlayer extends AbstractPlayer {
    private J2DGraphicsContext grCtx;
    private BufferedImage image = null;
    private Clip clip;
    private Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    private File file;

    public J2DPlayer(J2DGraphicsContext grCtx) {
        super(1, 90*grCtx.getScreenHeight()/(100*grCtx.getSize()), 0, 0, 0, grCtx.getScreenWidth()/100, grCtx.getScreenHeight()/200, 3, 0, grCtx.getScreenWidth(), grCtx.getScreenHeight(), grCtx.getSize(), grCtx.getGameCellsX(), grCtx.getGameCellsY(), 0, "\\src\\resource\\Audio\\spacesound.wav");
        this.grCtx = grCtx;
        image = grCtx.resizeImage(grCtx.playerSprite, getCollisionComponent().getHitboxWidth()*grCtx.getSize(), getCollisionComponent().getHitboxHeight()*grCtx.getSize());
        try {
            file = new File(path + getSoundComponent().getSound());
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the audio clip continuously
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void draw() {
        Graphics2D g2d = grCtx.getG2d();
        int size = grCtx.getSize();
        g2d.drawImage(image, super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, null);
        //g2d.setColor(new Color(170,0,0));
        //g2d.fillRect(super.getPositionComponent().getX()*size, super.getPositionComponent().getY()*size, getCollisionComponent().getHitboxWidth(), getCollisionComponent().getHitboxHeight());
    }
}
