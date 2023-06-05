package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;

import java.util.ArrayList;

public class EnemyMovementSystem {
    private ArrayList<AbstractEnemy> enemyArrayList;

    private boolean directionChange = false;

    private int teller = 0;
    private int enemyLaagsteX = 0;
    private int enemyHoogsteX;

    public EnemyMovementSystem(ArrayList<AbstractEnemy> enemy) {
        this.enemyArrayList = enemy;
        enemyHoogsteX = enemyArrayList.size() - 1;
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
            for (var enemy: enemyArrayList) {
                if (enemyHoogsteX > enemyArrayList.size()-1) {
                    enemyHoogsteX = enemyArrayList.size()-1;
                }
                if (enemyLaagsteX >= enemyArrayList.size()) {
                    enemyLaagsteX = 0;
                }
                if (enemy.x() < enemyArrayList.get(enemyLaagsteX).x()) {
                    enemyLaagsteX = enemyArrayList.indexOf(enemy);
                }
                if (enemy.x() > enemyArrayList.get(enemyHoogsteX).x()) {
                    enemyHoogsteX = enemyArrayList.indexOf(enemy);
                }
            }
            if (enemyArrayList.get(enemyLaagsteX).x() + enemyArrayList.get(enemyLaagsteX).dx() < 1) {
                directionChange = true;
            }
            if (enemyArrayList.get(enemyHoogsteX).x() + enemyArrayList.get(enemyHoogsteX).dx() > enemyArrayList.get(enemyHoogsteX).getSizeComponent().getScreenwidth() / enemyArrayList.get(enemyHoogsteX).getSizeComponent().getSize() - enemyArrayList.get(enemyHoogsteX).getCollisionComponent().getHitboxWidth()) {
                directionChange = true;
            }
            if (directionChange) {
                for (var enemy : enemyArrayList) {
                    enemy.getMovementComponent().setDx(enemy.getMovementComponent().getDx() * (-1));
                    enemy.getPositionComponent().setY(enemy.getPositionComponent().getY() + 1);
                    directionChange = false;
                }
            }
            if (enemyArrayList.get(enemyArrayList.size() - 1).y() + enemyArrayList.get(enemyArrayList.size() - 1).dy() >= enemyArrayList.get(enemyArrayList.size() - 1).getSizeComponent().getScreenHeight() / enemyArrayList.get(enemyArrayList.size() - 1).getSizeComponent().getSize() - enemyArrayList.get(enemyArrayList.size() - 1).getCollisionComponent().getHitboxHeight()*3) {
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
