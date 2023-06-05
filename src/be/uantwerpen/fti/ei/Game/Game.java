package be.uantwerpen.fti.ei.Game;

import be.uantwerpen.fti.ei.Game.Entities.*;
import be.uantwerpen.fti.ei.Game.Systems.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
/**
 * The main class representing the game.
 *
 * @author Ahmad Shakleya
 */
public class Game {
    // Singleton instance
    private static Game single_instance = null;
    private long lastUpdateTime = System.currentTimeMillis();
    long currentTime, elapsedTime, sleepTime;
    private ArrayList<AbstractBonus> bonuses;
    private ArrayList<AbstractPlayer> players;
    private ArrayList<AbstractBarrier> barriers;
    private ArrayList<AbstractBullet> playerBullets;
    private ArrayList<AbstractEnemy> enemies;
    private ArrayList<AbstractBullet> enemyBullets;
    private ArrayList<AbstractLabel> scores;
    private ArrayList<AbstractLabel> levels;

    private ArrayList<AbstractLabel> healths;
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
    private final AbstractFactory factory;

    private boolean EndGame = false;
    private int level = 1;
    private int initialHealthvalue;

    private final ArrayList<AbstractFigure> gameObjects = new ArrayList<>();
    /**
     * Private constructor for the Game class.
     * @param abstractFactory The abstract factory to use for creating game entities.
     */
    private Game(AbstractFactory abstractFactory) {
        this.factory = abstractFactory;
    }
    /**
     * Get the singleton instance of the Game class.
     * @param abstractFactory The abstract factory to use for creating game entities.
     * @return The singleton instance of the Game class.
     */
    public static Game getInstance(AbstractFactory abstractFactory) {
        if (single_instance == null) {
            single_instance = new Game(abstractFactory);
        }
        return single_instance;
    }
    /**
     * Initialize the game.
     */
    private void initGame(){
        players = factory.createPlayer();
        players.get(0).getLevelComponent().setLevel(level);
        initialHealthvalue = players.get(0).getHealthComponent().getHealthValue();
        for (var player: players) {
            updateGameObjects(player);
        }
        scores = factory.createScore(players.get(0).getScoreComponent().getScore());
        levels = factory.createLevel(players.get(0).getLevelComponent().getLevel());
        healths = factory.createHealthIndication(players.get(0).getHealthComponent().getHealthValue());
        for (var score: scores) {
            updateGameObjects(score);
        }
        for (var level: levels) {
            updateGameObjects(level);
        }
        for (var health: healths) {
            updateGameObjects(health);
        }
        AbstractInput input = factory.createInput();
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
        boolean isPaused = false;
        inputSystem = new InputSystem(input, players, isPaused);
        playerBulletSystem = new BulletSystem(null);
        enemyBulletSystem = new BulletSystem(null);
        enemyMovementSystem = new EnemyMovementSystem(enemies);
        collisionSystemPlayerBullet_Bonus = new CollisionSystem(null, null);
        collisionSystemPlayerBullet_Enemies = new CollisionSystem(null, new ArrayList<>(enemies));
        collisionSystemEnemyBullet_Player = new CollisionSystem(null, new ArrayList<>(players));
        collisionSystemEnemyBullet_Barrier = new CollisionSystem(null, new ArrayList<>(barriers));
    }
    /**
     * Loads a new level in the game.
     * This method updates the game state to load a new level, including removing existing game objects, resetting positions and sizes,
     * and updating the level label value.
     */
    private void loadNewLevel() {
        // Increase the level label value
        levels.get(0).getLabelValueComponent().setLabelValue(levels.get(0).getLabelValueComponent().getLabelValue() + 1);

        // Remove existing game objects
        if (bonuses != null) {
            gameObjects.removeAll(bonuses);
            bonuses = null;
        }
        if (barriers != null) {
            gameObjects.removeAll(barriers);
            barriers = null;
        }
        if (playerBullets != null) {
            gameObjects.removeAll(playerBullets);
            playerBullets = null;
        }
        if (enemyBullets != null) {
            gameObjects.removeAll(enemyBullets);
            enemyBullets = null;
        }

        // Reset system components
        bonusMovementSystem.setBonuses(null);
        playerBulletSystem.setBullets(null);
        enemyBulletSystem.setBullets(null);
        collisionSystemPlayerBullet_Bonus.setFigures1(null);
        collisionSystemPlayerBullet_Bonus.setFigures2(null);
        collisionSystemPlayerBullet_Enemies.setFigures1(null);
        collisionSystemPlayerBullet_Enemies.setFigures2(null);
        collisionSystemEnemyBullet_Player.setFigures1(null);
        collisionSystemEnemyBullet_Barrier.setFigures1(null);
        collisionSystemEnemyBullet_Barrier.setFigures2(null);

        // Adjust level position and size
        int initialx = levels.get(0).x();
        int initialy = levels.get(0).y();
        int initialSize = levels.get(0).getSizeComponent().getSize();
        levels.get(0).getPositionComponent().setX(levels.get(0).getSizeComponent().getScreenwidth() / (3 * levels.get(0).getSizeComponent().getSize()));
        levels.get(0).getPositionComponent().setY(levels.get(0).getSizeComponent().getScreenHeight() / (2 * levels.get(0).getSizeComponent().getSize()));
        levels.get(0).getSizeComponent().setSize(initialSize * 3);

        // Render the game entities
        drawEntities();

        // Reset level position and size to initial values
        levels.get(0).getPositionComponent().setX(initialx);
        levels.get(0).getPositionComponent().setY(initialy);
        levels.get(0).getSizeComponent().setSize(initialSize);
    }

    /**
     * Loads a new game round.
     * This method updates the game state to start a new game round, including increasing the level,
     * resetting player health, creating new enemies and barriers, and initializing movement and collision systems.
     */
    private void loadNewGame() {
        // Increase the level
        level++;

        // Reset player health
        players.get(0).getHealthComponent().setHealthValue(3);
        healths.get(0).getHealthComponent().setHealthValue(players.get(0).getHealthComponent().getHealthValue());
        healths.get(0).getLabelValueComponent().setLabelValue(healths.get(0).getHealthComponent().getHealthValue());

        // Create new enemies and update game objects
        enemies = factory.createEnemy();
        for (var enemy : enemies) {
            updateGameObjects(enemy);
        }

        // Update enemy movement system and collision system
        enemyMovementSystem.setEnemyArrayList(enemies);
        collisionSystemPlayerBullet_Enemies.setFigures2(new ArrayList<>(enemies));

        // Update player level
        players.get(0).getLevelComponent().setLevel(level);

        // Create new barriers and update game objects
        barriers = factory.createBarrier();
        for (var barrier : barriers) {
            updateGameObjects(barrier);
        }

        // Initialize bonus movement system
        bonusMovementSystem = new BonusMovementSystem(bonuses);

        // Initialize enemy movement system and collision systems
        enemyMovementSystem = new EnemyMovementSystem(enemies);
        collisionSystemPlayerBullet_Enemies.setFigures2(new ArrayList<>(enemies));
        collisionSystemEnemyBullet_Barrier.setFigures2(new ArrayList<>(barriers));
    }


    /**
     * Main game loop.
     */
    public void run() {
        int gameCellsX = 60;
        int gameCellsY = 60;
        factory.setGameDimensions(gameCellsX, gameCellsY);
        initGame();
        boolean isRunning = true;
        inputSystem.setPaused(false);
        while (isRunning) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastUpdateTime;
            lastUpdateTime = currentTime;

            inputSystem.updateInput();
            if (!inputSystem.isPaused() && !EndGame) {
                if (levels.get(0).getLabelValueComponent().getLabelValue() == level) {
                    updateGame();
                } else {
                    loadNewGame();
                }
                factory.render();
            }
            if (EndGame) {
                gameObjects.clear();
                updateGame();
                factory.render();
                isRunning = false;
            }
            try {
                sleepTime = 150 - elapsedTime;
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                } else {
                    Thread.sleep(60);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        factory.closeWindow();
    }
    /**
     * Draw and update the game entities and systems.
     */
    public void updateGame(){
        drawEntities();
        updateEntities();
    }

    /**
     * Updates the entities in the game.
     * This method updates the game entities by invoking various update methods,
     * including collision updates, movement updates, bonus updates, barrier updates,
     * player bullet updates, enemy updates, player updates, and enemy bullet updates.
     */
    public void updateEntities() {
        // Update collisions
        updateCollisions();

        // Update movements
        updateMovements();

        // Update bonuses
        updateBonus();

        // Update barriers
        updateBarrier();

        // Update player bullets
        updatePlayerBullets();

        // Update enemies
        updateEnemies();

        // Update player
        updatePlayer();

        // Update enemy bullets
        updateEnemyBullet();
    }

    /**
     * Draw/render the game entities.
     */
    public void drawEntities() {
        for (var figure: gameObjects) {
            figure.draw();
        }
    }

    /**
     * Updates the bonuses in the game.
     * If there are no bonuses, invokes the bonusShine() method.
     * Otherwise, checks each bonus for reaching the end or being dead,
     * removes dead bonuses from the game objects, and updates the bonus lists and collision system accordingly.
     */
    public void updateBonus() {
        if (bonuses == null) {
            bonusShine();
        } else {
            for (var bonus : bonusMovementSystem.getBonuses()) {
                if (bonus.getSizeComponent().isReachedEnd() || bonus.getHealthComponent().isDead()) {
                    int bonusIndex = bonusMovementSystem.getBonuses().indexOf(bonus);
                    bonuses.get(bonusIndex).getHealthComponent().setDead(true);
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

    /**
     * Updates the player in the game.
     * Checks each player for being dead, removes dead players from the game objects,
     * and updates the player lists, movement system, input system, and game state accordingly.
     */
    public void updatePlayer() {
        if (players != null) {
            for (var player : players) {
                if (player.getHealthComponent().isDead()) {
                    removeGameObjects(player);
                }
            }

            for (int i = 0; i < players.size(); i++) {
                if (!gameObjects.contains(players.get(i))) {
                    players.remove(players.get(i));
                    i--;
                }
            }

            if (players.size() == 0) {
                players = null;
                playerMovementSystem.setPlayers(null);
                inputSystem.setPlayer(null);
                EndGame = true;
            }
        }
    }

    /**
     * Updates the barriers in the game.
     * Checks each barrier for being destroyed, removes destroyed barriers from the game objects,
     * and updates the barrier list and collision system accordingly.
     */
    public void updateBarrier() {
        if (barriers != null) {
            for (var barrier : barriers) {
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

    /**
     * Updates the player bullets in the game.
     * Handles bullet creation, updates the bullet list, and updates the collision systems.
     * Removes dead bullets from the game objects and adjusts the bullet lists and collision systems accordingly.
     */
    public void updatePlayerBullets() {
        if (players != null) {
            if (playerBullets == null) {
                if (inputSystem.isCreateBullet()) {
                    playerBullets = factory.createBullet(players.get(0).x() + players.get(0).w() / 2, players.get(0).y() - 2, -3);
                    for (var bullet : playerBullets) {
                        updateGameObjects(bullet);
                    }
                    playerBulletSystem.setBullets(playerBullets);
                    collisionSystemPlayerBullet_Bonus.setFigures1(new ArrayList<>(playerBullets));
                    collisionSystemPlayerBullet_Enemies.setFigures1(new ArrayList<>(playerBullets));
                }
            } else {
                if (level >= 2) {
                    if (inputSystem.isCreateBullet()) {
                        factory.addBullet(playerBullets, players.get(0).x() + players.get(0).w() / 2, players.get(0).y() - 2, -3);
                        for (var bullet : playerBullets) {
                            if (!gameObjects.contains(bullet)) {
                                updateGameObjects(bullet);
                            }
                        }
                        playerBulletSystem.setBullets(playerBullets);
                        collisionSystemPlayerBullet_Bonus.setFigures1(new ArrayList<>(playerBullets));
                        collisionSystemPlayerBullet_Enemies.setFigures1(new ArrayList<>(playerBullets));
                    }
                }
                for (var bullet : playerBulletSystem.getBullets()) {
                    if (bullet.getSizeComponent().isReachedEnd() || bullet.getHealthComponent().isDead()) {
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
    }

    /**
     * Updates the enemy entities in the game.
     * Handles enemy movement, checks if enemies have reached the end, updates player health when enemies reach the end,
     * removes dead enemies from the game objects, and loads a new level if all enemies are defeated.
     */
    public void updateEnemies() {
        if (enemies != null) {
            boolean endReached = false;
            for (var enemy : enemyMovementSystem.getEnemyArrayList()) {
                if (enemy.getSizeComponent().isReachedEnd()) {
                    enemy.getPositionComponent().resetPosition();
                    if (enemyMovementSystem.getEnemyArrayList().indexOf(enemy) < enemies.size()) {
                        enemies.get(enemyMovementSystem.getEnemyArrayList().indexOf(enemy)).getPositionComponent().resetPosition();
                        enemies.get(enemyMovementSystem.getEnemyArrayList().indexOf(enemy)).getSizeComponent().setReachedEnd(false);
                    }
                    enemy.getSizeComponent().setReachedEnd(false);
                    endReached = true;
                }
            }
            if (endReached) {
                players.get(0).getHealthComponent().setHealthValue(players.get(0).getHealthComponent().getHealthValue() - 1);
                healths.get(0).getHealthComponent().setHealthValue(players.get(0).getHealthComponent().getHealthValue());
                healths.get(0).getLabelValueComponent().setLabelValue(healths.get(0).getHealthComponent().getHealthValue());
            }
            for (var enemy : enemies) {
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
                loadNewLevel();
            }
        }
    }

    /**
     * Updates the enemy bullet entities in the game.
     * Handles enemy firing, removes bullets that have reached the end or are marked as dead,
     * and clears the enemy bullet objects when there are no more active bullets.
     */
    public void updateEnemyBullet() {
        enemyFire();
        if (enemyBullets != null) {
            for (var bullet : enemyBulletSystem.getBullets()) {
                if (bullet.getSizeComponent().isReachedEnd() || bullet.getHealthComponent().isDead()) {
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

    /**
     * Updates the movements of various entities in the game.
     * This includes updating the movement of bonuses, players, player bullets, enemies, and enemy bullets.
     */
    public void updateMovements() {
        bonusMovementSystem.updateBonusMovement();
        playerMovementSystem.updatePlayerMovement();
        playerBulletSystem.updateBulletPosition();
        enemyMovementSystem.updateEnemyMovement();
        enemyBulletSystem.updateBulletPosition();
    }

    /**
     * Updates the collisions between entities in the game.
     * This includes detecting and handling collisions between player bullets and bonuses,
     * player bullets and enemies, enemy bullets and barriers, and enemy bullets and players.
     * Updates the game state and entity properties accordingly.
     */
    public void updateCollisions() {
        if (collisionSystemPlayerBullet_Bonus.CollisionDetected()) {
            if (bonuses != null) {
                if (Objects.equals(bonuses.get(0).getBonusComponent().getTypeBonus(), "+") && players.get(0).getHealthComponent().getHealthValue() < initialHealthvalue) {
                    players.get(0).getHealthComponent().setHealthValue(players.get(0).getHealthComponent().getHealthValue() + 1);
                } else if (Objects.equals(bonuses.get(0).getBonusComponent().getTypeBonus(), "-") && players.get(0).getHealthComponent().getHealthValue() > 0) {
                    players.get(0).getHealthComponent().setHealthValue(players.get(0).getHealthComponent().getHealthValue() - 1);
                }
                healths.get(0).getHealthComponent().setHealthValue(players.get(0).getHealthComponent().getHealthValue());
                healths.get(0).getLabelValueComponent().setLabelValue(healths.get(0).getHealthComponent().getHealthValue());
            }
        }
        if (collisionSystemPlayerBullet_Enemies.CollisionDetected()) {
            scores.get(0).getLabelValueComponent().setLabelValue(scores.get(0).getLabelValueComponent().getLabelValue() + collisionSystemPlayerBullet_Enemies.getFigures2().get(0).getScoreComponent().getScore());
        }
        collisionSystemEnemyBullet_Barrier.CollisionDetected();
        if (collisionSystemEnemyBullet_Player.CollisionDetected()) {
            healths.get(0).getLabelValueComponent().setLabelValue(players.get(0).getHealthComponent().getHealthValue());
        }
    }


    /**
     * Triggers the appearance of a bonus in the game.
     * Randomly generates a bonus type (+ or -) and positions it within the player's screen width.
     * Updates the game state and entity properties accordingly.
     */
    public void bonusShine() {
        Random rand = new Random();
        int getal = rand.nextInt(50) + 1;
        if (getal == 2 && bonuses == null) {
            int type = rand.nextInt(100) + 1;
            if (players != null) {
                if (type % 2 == 0) {
                    bonuses = factory.createBonus(rand.nextInt(players.get(0).getSizeComponent().getScreenwidth() / players.get(0).getSizeComponent().getSize() - players.get(0).getCollisionComponent().getHitboxWidth()), "+");
                } else {
                    bonuses = factory.createBonus(rand.nextInt(players.get(0).getSizeComponent().getScreenwidth() / players.get(0).getSizeComponent().getSize() - players.get(0).getCollisionComponent().getHitboxWidth()) + 1, "-");
                }
                for (var bonus: bonuses) {
                    updateGameObjects(bonus);
                }
                bonusMovementSystem.setBonuses(bonuses);
                collisionSystemPlayerBullet_Bonus.setFigures2(new ArrayList<>(bonuses));
            }
        }
    }

    /**
     * Handles enemy firing behavior in the game.
     * Randomly selects an enemy to fire based on the current level.
     * Determines the probability of firing based on the level.
     * Creates enemy bullets and updates the game state and entity properties accordingly.
     */
    public void enemyFire() {
        Random rand = new Random();
        if (enemies != null) {
            int enemyNumber = rand.nextInt(enemies.size());
            int fireGetal = 22 - 2 * level;
            if (fireGetal < 4) {
                fireGetal = 4;
            }
            if (rand.nextInt(fireGetal) + 1 == 1) {
                if (enemyBullets == null) {
                    enemyBullets = factory.createBullet(enemies.get(enemyNumber).x() + enemies.get(enemyNumber).w() / 2, enemies.get(enemyNumber).y() + 1, 3);
                    for (var bullet : enemyBullets) {
                        updateGameObjects(bullet);
                    }
                    enemyBulletSystem.setBullets(enemyBullets);
                    collisionSystemEnemyBullet_Player.setFigures1(new ArrayList<>(enemyBullets));
                    collisionSystemEnemyBullet_Barrier.setFigures1(new ArrayList<>(enemyBullets));
                } else {
                    if (level >= 2) {
                        factory.addBullet(enemyBullets, enemies.get(enemyNumber).x() + enemies.get(enemyNumber).w() / 2, enemies.get(enemyNumber).y() + 1, 3);
                        for (var bullet : enemyBullets) {
                            if (!gameObjects.contains(bullet)) {
                                updateGameObjects(bullet);
                            }
                        }
                        enemyBulletSystem.setBullets(enemyBullets);
                        collisionSystemEnemyBullet_Player.setFigures1(new ArrayList<>(enemyBullets));
                        collisionSystemEnemyBullet_Barrier.setFigures1(new ArrayList<>(enemyBullets));
                    }
                }
            }
        }
    }




    /**
     * Adds an AbstractFigure object to the gameObjects list.
     * @param abstractFigure The AbstractFigure object to add.
     */
    public void updateGameObjects(AbstractFigure abstractFigure) {
        gameObjects.add(abstractFigure);
    }

    /**
     * Removes an AbstractFigure object from the gameObjects list.
     * @param abstractFigure The AbstractFigure object to remove.
     */
    public void removeGameObjects(AbstractFigure abstractFigure) {
        gameObjects.remove(abstractFigure);
    }


}