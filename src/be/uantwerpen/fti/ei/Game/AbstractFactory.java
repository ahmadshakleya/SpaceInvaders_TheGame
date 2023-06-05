package be.uantwerpen.fti.ei.Game;

import be.uantwerpen.fti.ei.Game.Entities.*;

import java.util.ArrayList;

/**
 * Abstract factory class for creating game entities and components.
 * This abstract class provides a set of abstract methods that can be implemented
 * by subclasses to create specific entities and components in a game.
 *
 * @author Ahmad Shakleya
 */
public abstract class AbstractFactory {
    /**
     * Creates a list of players.
     *
     * @return The list of players.
     */
    public abstract ArrayList<AbstractPlayer> createPlayer();

    /**
     * Creates a list of barriers.
     *
     * @return The list of barriers.
     */
    public abstract ArrayList<AbstractBarrier> createBarrier();

    /**
     * Creates a list of enemies.
     *
     * @return The list of enemies.
     */
    public abstract ArrayList<AbstractEnemy> createEnemy();

    /**
     * Creates an input object.
     *
     * @return The input object.
     */
    public abstract AbstractInput createInput();

    /**
     * Creates a list of bullets with the specified parameters.
     *
     * @param x  The x-coordinate of the bullet.
     * @param y  The y-coordinate of the bullet.
     * @param dy The change in y-coordinate of the bullet.
     * @return The list of bullets.
     */
    public abstract ArrayList<AbstractBullet> createBullet(int x, int y, int dy);

    /**
     * Adds a bullet to the specified list of bullets with the specified parameters.
     *
     * @param bulletArrayList The list of bullets.
     * @param x               The x-coordinate of the bullet.
     * @param y               The y-coordinate of the bullet.
     * @param dy              The change in y-coordinate of the bullet.
     */
    public abstract void addBullet(ArrayList<AbstractBullet> bulletArrayList, int x, int y, int dy);

    /**
     * Creates a list of bonuses with the specified parameters.
     *
     * @param x    The x-coordinate of the bonus.
     * @param type The type of the bonus.
     * @return The list of bonuses.
     */
    public abstract ArrayList<AbstractBonus> createBonus(int x, String type);

    /**
     * Creates a list of labels for displaying the score.
     *
     * @param score The score to display.
     * @return The list of score labels.
     */
    public abstract ArrayList<AbstractLabel> createScore(int score);

    /**
     * Creates a list of labels for displaying the level.
     *
     * @param level The level to display.
     * @return The list of level labels.
     */
    public abstract ArrayList<AbstractLabel> createLevel(int level);

    /**
     * Creates a list of labels for displaying the health indication.
     *
     * @param health The health to display.
     * @return The list of health labels.
     */
    public abstract ArrayList<AbstractLabel> createHealthIndication(int health);

    /**
     * Sets the dimensions of the game.
     *
     * @param gameCellsX The number of cells in the x-direction.
     * @param gameCellsY The number of cells in the y-direction.
     */
    public abstract void setGameDimensions(int gameCellsX, int gameCellsY);

    /**
     * Renders the game.
     */
    public abstract void render();
    /**
     * Closes the game.
     */
    public abstract void closeWindow();
}
