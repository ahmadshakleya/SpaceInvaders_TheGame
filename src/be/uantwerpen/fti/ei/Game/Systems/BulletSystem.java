package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;

import java.util.ArrayList;

public class BulletSystem {
    private ArrayList<AbstractBullet> bullets;

    public BulletSystem(ArrayList<AbstractBullet> bullets) {
        this.bullets = bullets;
    }

    public void updateBulletPosition() {
        if (this.bullets != null) {
            for (var bullet : this.bullets) {
                bullet.getPositionComponent().setY(bullet.getPositionComponent().getY() + bullet.getMovementComponent().getDy());
                if (bullet.y() + bullet.dy() < 1 || bullet.y() + bullet.dy() > bullet.getSizeComponent().getScreenHeight()/bullet.getSizeComponent().getSize()) {
                    bullet.getSizeComponent().setReachedEnd(true);
                }
            }
        }
    }

    public ArrayList<AbstractBullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<AbstractBullet> bullets) {
        this.bullets = bullets;
    }

}
