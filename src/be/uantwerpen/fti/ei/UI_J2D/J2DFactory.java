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

public class J2DFactory extends AbstractFactory {
    private J2DGraphicsContext grCtx;
    private Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    public J2DFactory(String configFile) {
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
        grCtx = new J2DGraphicsContext(screenWidth, screenHeight);
    }


    @Override
    public ArrayList<AbstractPlayer> createPlayer() {
        ArrayList<AbstractPlayer> list = new ArrayList<>();
        list.add(new J2DPlayer(grCtx));
        return list;
    }

    @Override
    public ArrayList<AbstractBarrier> createBarrier() {
        ArrayList<AbstractBarrier> list = new ArrayList<>();
        int breedte_veld = grCtx.getScreenWidth()/(grCtx.getSize()*4);
        int offsetx = breedte_veld/2;
        int spacingx = breedte_veld;
        for (int i = 0; i < 4; i++){
            list.add(new J2DBarrier(offsetx+(spacingx*(i%5)), grCtx));
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
            list.add(new J2DEnemy(offsetx+(spacingx*(i%10)), offsety + spacingy*(i / 10), grCtx));
        }
        return list;
    }

    @Override
    public AbstractInput createInput() {
        return new J2DInput(grCtx);
    }

    @Override
    public ArrayList<AbstractBullet> createBullet(int x, int y, int dy) {
        ArrayList<AbstractBullet> list = new ArrayList<>();
        list.add(new J2DBullet(x,y,dy,grCtx));
        return list;
    }

    @Override
    public void addBullet(ArrayList<AbstractBullet> bulletArrayList, int x, int y, int dy) {
        bulletArrayList.add(new J2DBullet(x,y,dy,grCtx));
    }

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

    @Override
    public ArrayList<AbstractLabel> createScore(int score) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new J2DScore(score, grCtx));
        return list;
    }
    @Override
    public ArrayList<AbstractLabel> createLevel(int level) {
        ArrayList<AbstractLabel> list = new ArrayList<>();
        list.add(new J2DLevel(level, grCtx));
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
