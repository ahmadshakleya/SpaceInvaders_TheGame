package be.uantwerpen.fti.ei.Game;

import be.uantwerpen.fti.ei.Game.Components.PositionComponent;
import be.uantwerpen.fti.ei.Game.Entities.*;
import be.uantwerpen.fti.ei.Game.Systems.*;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private boolean isRunning;
    private boolean isPaused;
    private ArrayList<AbstractBonus> bonuses;
    private BonusMovementSystem bonusMovementSystem;
    private int GameCellsX = 60;
    private int GameCellsY = 60;
    private AbstractFactory factory;

    private boolean EndGame = false;

    private ArrayList<AbstractFigure> gameObjects = new ArrayList<>();
    public Game(AbstractFactory abstractFactory) {
        this.factory = abstractFactory;
    }

    private void initGame(){
        bonusMovementSystem = new BonusMovementSystem(bonuses);
    }

    public void run() {
        factory.setGameDimensions(GameCellsX, GameCellsY);
        initGame();
        isRunning = true;
        //inputSystem.setPaused(false);
        while (isRunning) {
            //inputSystem.updateInput();
            //if (!inputSystem.isPaused() && !EndGame) {
            if (!EndGame) {
                updateGame();
                factory.render();
            }
            try {   // fixed delay
                Thread.sleep(15);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    public void updateGame(){
        updateEntities();
        drawEntities();
    }

    public void updateEntities() {
        updateMovements();
        updateBonus();

    }
    public void drawEntities() {
        if (bonuses != null) {
            for (var bonus: bonuses) {
                bonus.draw();
            }
        }
    }

    public void updateBonus() {
        if (bonuses == null) {
            bonusShine();
        } else {
            for (var bonus: bonusMovementSystem.getBonuses()) {
                if (bonus.getSizeComponent().isReachedEnd()){
                    bonuses.get(bonusMovementSystem.getBonuses().indexOf(bonus)).getHealthComponent().setDead(true);
                    removeGameObjects(bonus);
                }
            }
            for (int i = 0; i < bonuses.size(); i++) {
                if (!gameObjects.contains(bonuses.get(i))) {
                    bonuses.remove(bonuses.get(i));
                    i--;
                }
            }
            if (bonuses.size() == 0) {
                bonuses = null;
                bonusMovementSystem.setBonuses(null);
            }
        }
    }
    public void updateMovements() {
        bonusMovementSystem.updateBonusMovement();
    }

    public void bonusShine() {
        Random rand = new Random();
        if (rand.nextInt(100) + 1 == 2 && bonuses == null) {
            bonuses = factory.createBonus();
            for (var bonus: bonuses) {
                updateGameObjects(bonus);
            }
            bonusMovementSystem.setBonuses(bonuses);
        }
    }



    public void updateGameObjects(AbstractFigure abstractFigures) {
        gameObjects.add(abstractFigures);
    }
    public void removeGameObjects(AbstractFigure abstractFigure) {
        gameObjects.remove(abstractFigure);
    }

}
