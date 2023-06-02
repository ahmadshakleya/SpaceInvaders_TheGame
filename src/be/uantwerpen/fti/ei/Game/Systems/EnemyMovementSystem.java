package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.util.ArrayList;

public class EnemyMovementSystem {
    private ArrayList<AbstractEnemy> enemyArrayList;

    private boolean directionChange = false;

    private int teller = 0;

    public EnemyMovementSystem(ArrayList<AbstractEnemy> enemy) {
        this.enemyArrayList = enemy;

    }

    public void updateEnemyMovement() {
        if (enemyArrayList != null) {
            if (teller >= enemyArrayList.get(0).snelheid()) {
                for (var enemy : enemyArrayList) {
                    enemy.getPositionComponent().setX(enemy.getPositionComponent().getX() + enemy.getMovementComponent().getDx());
                }
                teller = 0;
            } else {
                teller++;
            }
            if (enemyArrayList.get(0).x() + enemyArrayList.get(0).dx() < 1) {
                directionChange = true;
            }
            if (enemyArrayList.get(enemyArrayList.size() - 1).x() + enemyArrayList.get(enemyArrayList.size() - 1).dx() > enemyArrayList.get(0).getSizeComponent().getScreenwidth() / enemyArrayList.get(0).getSizeComponent().getSize() - enemyArrayList.get(0).getCollisionComponent().getHitboxWidth()/2) {
                directionChange = true;
            }
            if (directionChange) {
                for (var enemy : enemyArrayList) {
                    enemy.getMovementComponent().setDx(enemy.getMovementComponent().getDx() * (-1));
                    enemy.getPositionComponent().setY(enemy.getPositionComponent().getY() + 1);
                    directionChange = false;
                }
            }
            if (enemyArrayList.get(enemyArrayList.size() - 1).y() + enemyArrayList.get(enemyArrayList.size() - 1).dy() >= enemyArrayList.get(enemyArrayList.size() - 1).getSizeComponent().getScreenHeight() / enemyArrayList.get(enemyArrayList.size() - 1).getSizeComponent().getSize() - enemyArrayList.get(enemyArrayList.size() - 1).getCollisionComponent().getHitboxHeight()/2) {
                for (var enemy : enemyArrayList) {
                    enemy.getSizeComponent().setReachedEnd(true);
                }
            }
        }
    }

    public ArrayList<AbstractEnemy> getEnemyArrayList() {
        return enemyArrayList;
    }

    public void setEnemyArrayList(ArrayList<AbstractEnemy> enemyArrayList) {
        this.enemyArrayList = enemyArrayList;
    }
}
