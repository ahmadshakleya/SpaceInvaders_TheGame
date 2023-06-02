package be.uantwerpen.fti.ei.UI;

import be.uantwerpen.fti.ei.Game.AbstractFactory;
import be.uantwerpen.fti.ei.Game.Entities.*;

import java.util.ArrayList;

public class Factory extends AbstractFactory {
    private GraphicsContext grCtx;

    public Factory(int screenWidth, int screenHeight) {
        grCtx = new GraphicsContext(screenWidth, screenHeight);
    }


    @Override
    public ArrayList<AbstractPlayer> createPlayer() {
        ArrayList<AbstractPlayer> list = new ArrayList<>();
        list.add(new Player(grCtx));
        return list;
    }

    @Override
    public ArrayList<AbstractBarrier> createBarrier() {
        ArrayList<AbstractBarrier> list = new ArrayList<>();
        int breedte_veld = grCtx.getScreenWidth()/4;
        int offsetx = breedte_veld/2;
        int spacingx = breedte_veld;
        for (int i = 0; i < 4; i++){
            list.add(new Barrier(offsetx+(spacingx*(i%5)), grCtx));
        }
        return list;
    }

    @Override
    public ArrayList<AbstractEnemy> createEnemy() {
        ArrayList<AbstractEnemy> list = new ArrayList<>();
        int offsetx = 1;
        int offsety = grCtx.getGameCellsY()/6;
        int spacingx = grCtx.getGameCellsX()/12;//grCtx.getScreenWidth()/ (grCtx.getSize()*15);
        int spacingy = grCtx.getGameCellsY()/20;//grCtx.getScreenHeight()/(grCtx.getSize()*20);
        for (int i=0; i<30;i++){
            list.add(new Enemy(offsetx+(spacingx*(i%10)), offsety + spacingy*(i / 10), grCtx));
        }
        return list;
    }

    @Override
    public AbstractInput createInput() {
        return new Input(grCtx);
    }

    @Override
    public ArrayList<AbstractBullet> createBullet(int x, int y, int dy) {
        ArrayList<AbstractBullet> list = new ArrayList<>();
        list.add(new Bullet(x,y,dy,grCtx));
        return list;
    }

    @Override
    public ArrayList<AbstractBonus> createBonus() {
        ArrayList<AbstractBonus> list = new ArrayList<>();
        list.add(new Bonus(grCtx));
        return list;
    }

    @Override
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        grCtx.setGameDimensions(GameCellsX, GameCellsY);
    }
    public void render() {
        grCtx.render();
    }
}
