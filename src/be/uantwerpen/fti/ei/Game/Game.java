package be.uantwerpen.fti.ei.Game;

import be.uantwerpen.fti.ei.Game.Entities.*;
import be.uantwerpen.fti.ei.Game.Systems.*;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private boolean isRunning;
    private boolean isPaused;
    private ArrayList<AbstractBonus> bonuses;
    private ArrayList<AbstractPlayer> players;
    private ArrayList<AbstractBarrier> barriers;
    private ArrayList<AbstractBullet> playerBullets;
    private AbstractInput input;
    private BonusMovementSystem bonusMovementSystem;
    private PlayerMovementSystem playerMovementSystem;
    private InputSystem inputSystem;
    private BulletSystem playerBulletSystem;
    private int GameCellsX = 60;
    private int GameCellsY = 60;
    private AbstractFactory factory;

    private boolean EndGame = false;

    private ArrayList<AbstractFigure> gameObjects = new ArrayList<>();
    public Game(AbstractFactory abstractFactory) {
        this.factory = abstractFactory;
    }

    private void initGame(){
        players = factory.createPlayer();
        for (var player: players) {
            updateGameObjects(player);
        }
        input = factory.createInput();
        barriers = factory.createBarrier();
        for (var barrier: barriers) {
            updateGameObjects(barrier);
        }
        bonusMovementSystem = new BonusMovementSystem(bonuses);
        playerMovementSystem = new PlayerMovementSystem(players);
        inputSystem = new InputSystem(input, players, isPaused);
        playerBulletSystem = new BulletSystem(null);
    }

    public void run() {
        factory.setGameDimensions(GameCellsX, GameCellsY);
        initGame();
        isRunning = true;
        inputSystem.setPaused(false);
        while (isRunning) {
            inputSystem.updateInput();
            if (!inputSystem.isPaused() && !EndGame) {
                updateGame();
                factory.render();
            }
            try {
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
        updatePlayer();
        updateBarrier();
        updatePlayerBullets();
    }
    public void drawEntities() {
        for (var figure: gameObjects) {
            figure.draw();
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
    public void updatePlayer() {
        if (players != null) {
            if (players.size() == 0) {
                players = null;
                playerMovementSystem.setPlayers(null);
                inputSystem.setPlayer(null);
            }
        }
    }
    public void updateBarrier() {
        if (barriers != null) {
            for (var barrier: barriers) {
                if (barrier.getHealthComponent().isDead()) {
                    removeGameObjects(barrier);
                }
            }
            for (int i = 0; i < barriers.size(); i++) {
                if (!gameObjects.contains(barriers.get(i))) {
                    barriers.remove(barriers.get(i));
                    i--;
                }
            }
            if (barriers.size() == 0) {
                barriers = null;
            }
        }
    }
    public void updatePlayerBullets() {
        if (playerBullets ==  null) {
            if (inputSystem.isCreateBullet()) {
                playerBullets = factory.createBullet(players.get(0).x(), players.get(0).y() - 2, -1);
                for (var bullet: playerBullets) {
                    updateGameObjects(bullet);
                }
                playerBulletSystem.setBullets(playerBullets);
            }
        } else {
            for (var bullet: playerBulletSystem.getBullets()) {
                if (bullet.getSizeComponent().isReachedEnd()){
                    playerBullets.get(playerBulletSystem.getBullets().indexOf(bullet)).getHealthComponent().setDead(true);
                    removeGameObjects(bullet);
                }
            }
            for (int i = 0; i < playerBullets.size(); i++) {
                if (!gameObjects.contains(playerBullets.get(i))) {
                    playerBullets.remove(playerBullets.get(i));
                    i--;
                }
            }
            if (playerBullets.size() == 0) {
                playerBullets = null;
                playerBulletSystem.setBullets(null);
            }
        }
    }
    public void updateMovements() {
        bonusMovementSystem.updateBonusMovement();
        playerMovementSystem.updatePlayerMovement();
        playerBulletSystem.updateBulletPosition();
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
