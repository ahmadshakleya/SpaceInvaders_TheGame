package be.uantwerpen.fti.ei.UI_J2D;

import be.uantwerpen.fti.ei.Game.AbstractFactory;
import be.uantwerpen.fti.ei.Game.Entities.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a factory for creating J2D game entities.
 *
 * @author Ahmad Shakleya
 */
public class J2DFactory extends AbstractFactory {
    private final J2DGraphicsContext grCtx;

    /**
     * Constructs a J2DFactory object with the specified configuration file.
     *
     * @param configFile The path to the configuration file.
     */
    public J2DFactory(String configFile) {
        int screenWidth = 0, screenHeight = 0;
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        try (BufferedReader br = new BufferedReader(new FileReader(path + configFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                int i = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                if (line.startsWith("ScreenWidth:")) {
                    screenWidth = i;
                } else if (line.startsWith("ScreenHeight:")) {
                    screenHeight = i;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        grCtx = new J2DGraphicsContext(screenWidth, screenHeight);
    }

    /**
     * Creates and returns a list of AbstractPlayer objects.
     *
     * @return The list of AbstractPlayer objects.
     */
    @Override
    public ArrayList<AbstractPlayer> createPlayer() {
        ArrayList<AbstractPlayer> list = new ArrayList<>();
        list.add(new J2DPlayer(grCtx));
        return list;
    }


    /**
     * Creates and returns a list of AbstractBarrier objects.
     *
     * @return The list of AbstractBarrier objects.
     */
    @Override
    public ArrayList<AbstractBarrier> createBarrier() {
        ArrayList<AbstractBarrier> list = new ArrayList<>();
        int breedte_veld = grCtx.getScreenWidth() / (grCtx.getSize() * 4);
        int offsetx = breedte_veld / 2;
        for (int i = 0; i < 4; i++) {
            list.add(new J2DBarrier(offsetx + (breedte_veld * (i % 5)), grCtx));
        }
        return list;
    }


    /**
     * Creates and returns a list of AbstractEnemy objects.
     *
     * @return The list of AbstractEnemy objects.
     */
    @Override
    public ArrayList<AbstractEnemy> createEnemy() {
        ArrayList<AbstractEnemy> list = new ArrayList<>();
        int offsetx = 1;
        int offsety = grCtx.getScreenHeight() / (grCtx.getSize() * 5);
        int spacingx = grCtx.getScreenWidth() / (grCtx.getSize() * 15);
        int spacingy = grCtx.getScreenHeight() / (grCtx.getSize() * 20);
        for (int i = 0; i < 50; i++) {
            list.add(new J2DEnemy(offsetx + (spacingx * (i % 10)), offsety + spacingy * (i / 10), grCtx));
        }
        return list;
    }


    /**
     * Creates and returns an instance of AbstractInput for user input handling.
     *
     * @return The AbstractInput instance for user input handling.
     */
    @Override
    public AbstractInput createInput() {
        return new J2DInput(grCtx);
    }


    /**
     * Creates and returns an ArrayList of AbstractBullet objects representing bullets fired in the game.
     *
     * @param x  The x-coordinate of the bullet.
     * @param y  The y-coordinate of the bullet.
     * @param dy The vertical velocity of the bullet.
     * @return An ArrayList of AbstractBullet objects representing the created bullets.
     */
    @Override
    public ArrayList<AbstractBullet> createBullet(int x, int y, int dy) {
        ArrayList<AbstractBullet> list = new ArrayList<>();
        list.add(new J2DBullet(x, y, dy, grCtx));
        return list;
    }


    /**
     * Adds a new bullet to the provided ArrayList of AbstractBullet objects.
     *
     * @param bulletArrayList The ArrayList of AbstractBullet objects to which the new bullet will be added.
     * @param x               The x-coordinate of the bullet.
     * @param y               The y-coordinate of the bullet.
     * @param dy              The vertical velocity of the bullet.
     */
    @Override
    public void addBullet(ArrayList<AbstractBullet> bulletArrayList, int x, int y, int dy) {
        bulletArrayList.add(new J2DBullet(x, y, dy, grCtx));
    }


    /**
     * Creates an ArrayList of AbstractBonus objects based on the given parameters.
     *
     * @param x    The x-coordinate of the bonus.
     * @param type The type of the bonus (either "+" or "-").
     * @return The ArrayList of AbstractBonus objects.
     */
    @Override
    public ArrayList<AbstractBonus> createBonus(int x, String type) {
        ArrayList<AbstractBonus> list = new ArrayList<>();
        if (Objects.equals(type, "+")) {
            list.add(new J2DPositiveBonus(x, grCtx));
        } else if (Objects.equals(type, "-")) {
            list.add(new J2DNegativeBonus(x, grCtx));
        }
        return list;
    }


    /**
     * Creates an ArrayList of AbstractLabel objects for displaying the score.
     *
     * @param score The score value.
     * @return The ArrayList of AbstractLabel objects.
     */
    @Override
    public ArrayList<AbstractLabel> createScore(int score) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new J2DScore(score, grCtx));
        return list;
    }


    /**
     * Creates an ArrayList of AbstractLabel objects for displaying the level.
     *
     * @param level The level value.
     * @return The ArrayList of AbstractLabel objects.
     */
    @Override
    public ArrayList<AbstractLabel> createLevel(int level) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new J2DLevel(level, grCtx));
        return list;
    }


    /**
     * Creates an ArrayList of AbstractLabel objects for displaying the health indication.
     *
     * @param health The health value.
     * @return The ArrayList of AbstractLabel objects.
     */
    @Override
    public ArrayList<AbstractLabel> createHealthIndication(int health) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new J2DHealth(health, grCtx));
        return list;
    }


    /**
     * Sets the game dimensions in the J2DGraphicsContext.
     *
     * @param gameCellsX The number of game cells in the X direction.
     * @param gameCellsY The number of game cells in the Y direction.
     */
    @Override
    public void setGameDimensions(int gameCellsX, int gameCellsY) {
        grCtx.setGameDimensions(gameCellsX, gameCellsY);
    }


    /**
     * Renders the graphics context.
     */
    @Override
    public void render() {
        grCtx.render();
    }
    /**
     * Removes the game graphics.
     */
    @Override
    public void closeWindow() {
        grCtx.close();
    }
}
