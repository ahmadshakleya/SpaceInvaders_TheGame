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
    private ArrayList<AbstractEnemy> enemies;
    private ArrayList<AbstractBullet> enemyBullets;
    private ArrayList<AbstractLabel> scores;
    private ArrayList<AbstractLabel> levels;
    private AbstractInput input;
    private BonusMovementSystem bonusMovementSystem;
    private PlayerMovementSystem playerMovementSystem;
    private InputSystem inputSystem;
    private BulletSystem playerBulletSystem;
    private EnemyMovementSystem enemyMovementSystem;
    private BulletSystem enemyBulletSystem;

    private CollisionSystem collisionSystemPlayerBullet_Bonus;
    private CollisionSystem collisionSystemPlayerBullet_Enemies;
    private CollisionSystem collisionSystemEnemyBullet_Player;
    private CollisionSystem collisionSystemEnemyBullet_Barrier;
    private int GameCellsX = 60;
    private int GameCellsY = 60;
    private AbstractFactory factory;

    private boolean EndGame = false;
    private int level = 0;

    private ArrayList<AbstractFigure> gameObjects = new ArrayList<>();
    public Game(AbstractFactory abstractFactory) {
        this.factory = abstractFactory;
    }

    private void initGame(){
        players = factory.createPlayer();
        players.get(0).getLevelComponent().setLevel(level);
        for (var player: players) {
            updateGameObjects(player);
        }
        scores = factory.createScore(players.get(0).getScoreComponent().getScore());
        levels = factory.createLevel(players.get(0).getLevelComponent().getLevel());
        for (var score: scores) {
            updateGameObjects(score);
        }
        for (var level: levels) {
            updateGameObjects(level);
        }
        input = factory.createInput();
        barriers = factory.createBarrier();
        for (var barrier: barriers) {
            updateGameObjects(barrier);
        }
        enemies = factory.createEnemy();
        for (var enemy: enemies) {
            updateGameObjects(enemy);
        }
        bonusMovementSystem = new BonusMovementSystem(bonuses);
        playerMovementSystem = new PlayerMovementSystem(players);
        inputSystem = new InputSystem(input, players, isPaused);
        playerBulletSystem = new BulletSystem(null);
        enemyBulletSystem = new BulletSystem(null);
        //enemyMovementSystem = new EnemyMovementSystem(new ArrayList<>(enemies));
        enemyMovementSystem = new EnemyMovementSystem(enemies);
        collisionSystemPlayerBullet_Bonus = new CollisionSystem(null, null);
        collisionSystemPlayerBullet_Enemies = new CollisionSystem(null, new ArrayList<>(enemies));
        collisionSystemEnemyBullet_Player = new CollisionSystem(null, new ArrayList<>(players));
        collisionSystemEnemyBullet_Barrier = new CollisionSystem(null, new ArrayList<>(barriers));
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
                Thread.sleep(60);
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
        updateCollisions();
        updateMovements();
        updateBonus();
        updatePlayer();
        updateBarrier();
        updatePlayerBullets();
        updateEnemies();
        updateEnemyBullet();
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
                if (bonus.getSizeComponent().isReachedEnd() || bonus.getHealthComponent().isDead()){
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
                collisionSystemPlayerBullet_Bonus.setFigures2(null);
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
                collisionSystemEnemyBullet_Barrier.setFigures2(null);
            }
        }
    }
    public void updatePlayerBullets() {
        if (playerBullets ==  null) {
            if (inputSystem.isCreateBullet()) {
                playerBullets = factory.createBullet(players.get(0).x() + players.get(0).w()/2, players.get(0).y() - GameCellsY/20, -3);
                for (var bullet: playerBullets) {
                    updateGameObjects(bullet);
                }
                playerBulletSystem.setBullets(playerBullets);
                collisionSystemPlayerBullet_Bonus.setFigures1(new ArrayList<>(playerBullets));
                collisionSystemPlayerBullet_Enemies.setFigures1(new ArrayList<>(playerBullets));
            }
        } else {
            if (inputSystem.isCreateBullet()) {
                factory.addBullet(playerBullets, players.get(0).x() + players.get(0).w()/2, players.get(0).y() - GameCellsY/20, -3);
                for (var bullet: playerBullets){
                    if (!gameObjects.contains(bullet)) {
                        updateGameObjects(bullet);
                    }
                }
                playerBulletSystem.setBullets(playerBullets);
                collisionSystemPlayerBullet_Bonus.setFigures1(new ArrayList<>(playerBullets));
                collisionSystemPlayerBullet_Enemies.setFigures1(new ArrayList<>(playerBullets));
            }
            for (var bullet: playerBulletSystem.getBullets()) {
                if (bullet.getSizeComponent().isReachedEnd() || bullet.getHealthComponent().isDead()){
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
                collisionSystemPlayerBullet_Bonus.setFigures1(null);
                collisionSystemPlayerBullet_Enemies.setFigures1(null);
            }
        }
    }
    public void updateEnemies() {
        if (enemies != null) {
            for (var enemy: enemyMovementSystem.getEnemyArrayList()){
                if (enemy.getSizeComponent().isReachedEnd()) {
                    enemy.getPositionComponent().resetPosition();
                    if (enemyMovementSystem.getEnemyArrayList().indexOf(enemy) < enemies.size()) {
                        enemies.get(enemyMovementSystem.getEnemyArrayList().indexOf(enemy)).getPositionComponent().resetPosition();
                        enemies.get(enemyMovementSystem.getEnemyArrayList().indexOf(enemy)).getSizeComponent().setReachedEnd(false);
                    }
                    enemy.getSizeComponent().setReachedEnd(false);
                }
            }
            for (var enemy: enemies) {
                if (enemy.getHealthComponent().isDead()) {
                    removeGameObjects(enemy);
                }
            }
            for (int i = 0; i < enemies.size(); i++) {
                if (!gameObjects.contains(enemies.get(i))) {
                    enemies.remove(enemies.get(i));
                    i--;
                }
            }
            if (enemies.size() == 0) {
                enemies = null;
                enemyMovementSystem.setEnemyArrayList(null);
                collisionSystemPlayerBullet_Enemies.setFigures2(null);
                level++;
                //initGame();
                drawEntities();
                drawEntities();
                drawEntities();
                levels.get(0).getScoreComponent().setScore(level);
                enemies = factory.createEnemy();
                for (var enemy: enemies) {
                    updateGameObjects(enemy);
                }
                enemyMovementSystem.setEnemyArrayList(enemies);
                collisionSystemPlayerBullet_Enemies.setFigures2(new ArrayList<>(enemies));

            }
        }
    }
    public void updateEnemyBullet() {
        if (enemyBullets == null) {
            enemyFire();
        } else {
            for (var bullet: enemyBulletSystem.getBullets()) {
                if (bullet.getSizeComponent().isReachedEnd() || bullet.getHealthComponent().isDead()){
                    enemyBullets.get(enemyBulletSystem.getBullets().indexOf(bullet)).getHealthComponent().setDead(true);
                    removeGameObjects(bullet);
                }
            }
            for (int i = 0; i < enemyBullets.size(); i++) {
                if (!gameObjects.contains(enemyBullets.get(i))) {
                    enemyBullets.remove(enemyBullets.get(i));
                    i--;
                }
            }
            if (enemyBullets.size() == 0) {
                enemyBullets = null;
                enemyBulletSystem.setBullets(null);
                collisionSystemEnemyBullet_Player.setFigures1(null);
            }
        }
    }
    public void updateMovements() {
        bonusMovementSystem.updateBonusMovement();
        playerMovementSystem.updatePlayerMovement();
        playerBulletSystem.updateBulletPosition();
        enemyMovementSystem.updateEnemyMovement();
        enemyBulletSystem.updateBulletPosition();
    }
    public void updateCollisions() {
        if (collisionSystemPlayerBullet_Bonus.CollisionDetected()) {
            scores.get(0).getScoreComponent().setScore(scores.get(0).getScoreComponent().getScore() + collisionSystemPlayerBullet_Bonus.getFigures2().get(0).getScoreComponent().getScore());
            if (scores.get(0).getScoreComponent().getScore() < 0) {
                scores.get(0).getScoreComponent().setScore(0);
            }
        }
        if (collisionSystemPlayerBullet_Enemies.CollisionDetected()) {
            scores.get(0).getScoreComponent().setScore(scores.get(0).getScoreComponent().getScore() + collisionSystemPlayerBullet_Enemies.getFigures2().get(0).getScoreComponent().getScore());
        }
        collisionSystemEnemyBullet_Barrier.CollisionDetected();
    }

    public void bonusShine() {
        Random rand = new Random();
        int getal = rand.nextInt(3) + 1;
        if (getal == 2 && bonuses == null) {
            int type = rand.nextInt(100) + 1;
            if (type % 2 == 0) {
                bonuses = factory.createBonus(rand.nextInt(players.get(0).getSizeComponent().getScreenwidth() / players.get(0).getSizeComponent().getSize()) + 1, "+");
            } else {
                bonuses = factory.createBonus(rand.nextInt(players.get(0).getSizeComponent().getScreenwidth() / players.get(0).getSizeComponent().getSize())+1, "-");
            }
            for (var bonus: bonuses) {
                updateGameObjects(bonus);
            }
            bonusMovementSystem.setBonuses(bonuses);
            collisionSystemPlayerBullet_Bonus.setFigures2(new ArrayList<>(bonuses));
        }
    }
    public void enemyFire() {
        Random rand = new Random();
        boolean fire = false;
        if (rand.nextInt(10)+1 == 1 && enemyBullets == null) {
            fire = true;
        }
        if (enemies != null) {
            int enemyNumber = rand.nextInt(enemies.size());
            if (fire) {
                enemyBullets = factory.createBullet(enemies.get(enemyNumber).x() + enemies.get(enemyNumber).w()/2, enemies.get(enemyNumber).y()+1, 3);
                for (var bullet: enemyBullets) {
                    updateGameObjects(bullet);
                }
                enemyBulletSystem.setBullets(enemyBullets);
                collisionSystemEnemyBullet_Player.setFigures1(new ArrayList<>(enemyBullets));
                collisionSystemEnemyBullet_Barrier.setFigures1(new ArrayList<>(enemyBullets));
            }
        }
    }



    public void updateGameObjects(AbstractFigure abstractFigures) {
        gameObjects.add(abstractFigures);
    }
    public void removeGameObjects(AbstractFigure abstractFigure) {
        gameObjects.remove(abstractFigure);
    }

}