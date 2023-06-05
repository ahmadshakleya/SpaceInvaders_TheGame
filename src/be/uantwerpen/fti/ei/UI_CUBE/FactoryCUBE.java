package be.uantwerpen.fti.ei.UI_CUBE;

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
 * Represents a factory for creating game entities in the CUBE game.
 * Extends the AbstractFactory class.
 *
 * @author Ahmad Shakleya
 */
public class FactoryCUBE extends AbstractFactory {
    private final GraphicsContextCUBE grCtx;

    /**
     * Constructs a new FactoryCUBE object.
     *
     * @param configFile The path to the configuration file.
     */
    public FactoryCUBE(String configFile) {
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
        grCtx = new GraphicsContextCUBE(screenWidth, screenHeight);
    }

    /**
     * Creates the player entity.
     *
     * @return An ArrayList containing the player entity.
     */
    @Override
    public ArrayList<AbstractPlayer> createPlayer() {
        ArrayList<AbstractPlayer> list = new ArrayList<>();
        list.add(new PlayerCUBE(grCtx));
        return list;
    }

    /**
     * Creates the barrier entities.
     *
     * @return An ArrayList containing the barrier entities.
     */
    @Override
    public ArrayList<AbstractBarrier> createBarrier() {
        ArrayList<AbstractBarrier> list = new ArrayList<>();
        int breedte_veld = grCtx.getScreenWidth() / (grCtx.getSize() * 4);
        int offsetx = breedte_veld / 2;
        for (int i = 0; i < 4; i++) {
            list.add(new BarrierCUBE(offsetx + (breedte_veld * (i % 5)), grCtx));
        }
        return list;
    }

    /**
     * Creates the enemy entities.
     *
     * @return An ArrayList containing the enemy entities.
     */
    @Override
    public ArrayList<AbstractEnemy> createEnemy() {
        ArrayList<AbstractEnemy> list = new ArrayList<>();
        int offsetx = 1;
        int offsety = grCtx.getScreenHeight() / (grCtx.getSize() * 5);
        int spacingx = grCtx.getScreenWidth() / (grCtx.getSize() * 15);
        int spacingy = grCtx.getScreenHeight() / (grCtx.getSize() * 20);
        for (int i = 0; i < 50; i++) {
            list.add(new EnemyCUBE(offsetx + (spacingx * (i % 10)), offsety + spacingy * (i / 10), grCtx));
        }
        return list;
    }

    /**
     * Creates the input handler.
     *
     * @return The input handler object.
     */
    @Override
    public AbstractInput createInput() {
        return new InputCUBE(grCtx);
    }

    /**
     * Creates a bullet entity.
     *
     * @param x  The x-coordinate of the bullet.
     * @param y  The y-coordinate of the bullet.
     * @param dy The vertical velocity of the bullet.
     * @return An ArrayList containing the bullet entity.
     */
    @Override
    public ArrayList<AbstractBullet> createBullet(int x, int y, int dy) {
        ArrayList<AbstractBullet> list = new ArrayList<>();
        list.add(new BulletCUBE(x, y, dy, grCtx));
        return list;
    }

    /**
     * Adds a bullet entity to the existing list of bullets.
     *
     * @param bulletArrayList The list of bullets.
     * @param x               The x-coordinate of the bullet.
     * @param y               The y-coordinate of the bullet.
     * @param dy              The vertical velocity of the bullet.
     */
    @Override
    public void addBullet(ArrayList<AbstractBullet> bulletArrayList, int x, int y, int dy) {
        bulletArrayList.add(new BulletCUBE(x, y, dy, grCtx));
    }

    /**
     * Creates a bonus entity.
     *
     * @param x    The x-coordinate of the bonus.
     * @param type The type of the bonus.
     * @return An ArrayList containing the bonus entity.
     */
    @Override
    public ArrayList<AbstractBonus> createBonus(int x, String type) {
        ArrayList<AbstractBonus> list = new ArrayList<>();
        if (Objects.equals(type, "+")) {
            list.add(new PositiveBonusCUBE(x, grCtx));
        } else if (Objects.equals(type, "-")) {
            list.add(new NegativeBonusCube(x, grCtx));
        }
        return list;
    }

    /**
     * Creates the score label entity.
     *
     * @param score The current score.
     * @return An ArrayList containing the score label entity.
     */
    @Override
    public ArrayList<AbstractLabel> createScore(int score) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new ScoreCUBE(score, grCtx));
        return list;
    }

    /**
     * Creates the level label entity.
     *
     * @param level The current level.
     * @return An ArrayList containing the level label entity.
     */
    @Override
    public ArrayList<AbstractLabel> createLevel(int level) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new LevelCUBE(level, grCtx));
        return list;
    }

    /**
     * Creates the health indication label entity.
     *
     * @param health The current health.
     * @return An ArrayList containing the health indication label entity.
     */
    @Override
    public ArrayList<AbstractLabel> createHealthIndication(int health) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new HealthCUBE(health, grCtx));
        return list;
    }

    /**
     * Sets the dimensions of the game grid.
     *
     * @param GameCellsX The number of cells in the x-direction.
     * @param GameCellsY The number of cells in the y-direction.
     */
    @Override
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        grCtx.setGameDimensions(GameCellsX, GameCellsY);
    }

    /**
     * Renders the game graphics.
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
