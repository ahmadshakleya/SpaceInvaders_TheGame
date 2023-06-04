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

public class FactoryCUBE extends AbstractFactory {
    private GraphicsContextCUBE grCtx;
    private Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    public FactoryCUBE(String configFile) {
        int screenWidth = 0, screenHeight = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path+configFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("ScreenWidth:")) {
                    screenWidth = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                } else if (line.startsWith("ScreenHeight:")) {
                    screenHeight = Integer.parseInt(line.substring(line.indexOf(":") + 1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        grCtx = new GraphicsContextCUBE(screenWidth, screenHeight);
    }


    @Override
    public ArrayList<AbstractPlayer> createPlayer() {
        ArrayList<AbstractPlayer> list = new ArrayList<>();
        list.add(new PlayerCUBE(grCtx));
        return list;
    }

    @Override
    public ArrayList<AbstractBarrier> createBarrier() {
        ArrayList<AbstractBarrier> list = new ArrayList<>();
        int breedte_veld = grCtx.getScreenWidth()/(grCtx.getSize()*4);
        int offsetx = breedte_veld/2;
        int spacingx = breedte_veld;
        for (int i = 0; i < 4; i++){
            list.add(new BarrierCUBE(offsetx+(spacingx*(i%5)), grCtx));
        }
        return list;
    }

    @Override
    public ArrayList<AbstractEnemy> createEnemy() {
        ArrayList<AbstractEnemy> list = new ArrayList<>();
        int offsetx = 1;
        int offsety = grCtx.getScreenHeight()/(grCtx.getSize()*5);
        int spacingx = grCtx.getScreenWidth()/ (grCtx.getSize()*15);
        int spacingy = grCtx.getScreenHeight()/(grCtx.getSize()*20);
        for (int i=0; i<50;i++){
            list.add(new EnemyCUBE(offsetx+(spacingx*(i%10)), offsety + spacingy*(i / 10), grCtx));
        }
        return list;
    }

    @Override
    public AbstractInput createInput() {
        return new InputCUBE(grCtx);
    }

    @Override
    public ArrayList<AbstractBullet> createBullet(int x, int y, int dy) {
        ArrayList<AbstractBullet> list = new ArrayList<>();
        list.add(new BulletCUBE(x,y,dy,grCtx));
        return list;
    }

    @Override
    public void addBullet(ArrayList<AbstractBullet> bulletArrayList, int x, int y, int dy) {
        bulletArrayList.add(new BulletCUBE(x,y,dy,grCtx));
    }

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

    @Override
    public ArrayList<AbstractLabel> createScore(int score) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new ScoreCUBE(score, grCtx));
        return list;
    }
    @Override
    public ArrayList<AbstractLabel> createLevel(int level) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new LevelCUBE(level, grCtx));
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
