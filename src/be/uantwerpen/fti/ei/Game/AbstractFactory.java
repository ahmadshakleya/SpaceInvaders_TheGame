package be.uantwerpen.fti.ei.Game;

import be.uantwerpen.fti.ei.Game.Entities.*;

import java.util.ArrayList;

public abstract class AbstractFactory {
    public abstract ArrayList<AbstractPlayer> createPlayer();

    public abstract ArrayList<AbstractBarrier> createBarrier();
    public abstract ArrayList<AbstractEnemy> createEnemy();
    public abstract AbstractInput createInput();
    public abstract ArrayList<AbstractBullet> createBullet(int x, int y, int dy);
    public abstract void addBullet(ArrayList<AbstractBullet> bulletArrayList, int x, int y, int dy);
    public abstract ArrayList<AbstractBonus> createBonus(int x);
    public abstract ArrayList<AbstractLabel> createScore(int score);
    public abstract ArrayList<AbstractLabel> createLevel(int level);
    public abstract void setGameDimensions(int GameCellsX, int GameCellsY);
    public abstract void render();
}
