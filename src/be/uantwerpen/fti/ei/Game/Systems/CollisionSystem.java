package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractBullet;
import be.uantwerpen.fti.ei.Game.Entities.AbstractEnemy;
import be.uantwerpen.fti.ei.Game.Entities.AbstractFigure;

import java.util.ArrayList;

/**
 * @author Ahmad Shakleya
 * Klasse voor testen op collision
 * Health van 2de parameter wordt verminderd.
 */
public class CollisionSystem {
    private ArrayList<AbstractFigure> figures1;
    private ArrayList<AbstractFigure> figures2;
    private boolean collision = false;


    public CollisionSystem(ArrayList<AbstractFigure> abstractFigures1, ArrayList<AbstractFigure> abstractFigures2) {
        figures1 = abstractFigures1;
        figures2 = abstractFigures2;
    }

    public boolean CollisionDetected() {
        if (this.figures1 != null && this.figures2 != null) {
            for (AbstractFigure figure1 : figures1) {
                for (AbstractFigure figure2 : figures2) {
                    collision = false;
                    if (figure1.getHealthComponent().getHealthValue() > 0 && figure2.getHealthComponent().getHealthValue() > 0) {
                        if (figure1.x() <= figure2.x() + figure2.w()
                                && figure2.x() <= figure1.x() + figure1.w()
                                && figure1.y() <= figure2.y() + figure2.h()
                                && figure2.y() <= figure1.y() + figure1.h()) {
                            collision = true;
                            figure1.getHealthComponent().setHealthValue(figure1.getHealthComponent().getHealthValue() - 1);
                            figure2.getHealthComponent().setHealthValue(figure2.getHealthComponent().getHealthValue() - 1);
                        }
                    }
                    if (figure1.getHealthComponent().getHealthValue() == 0) {
                        figure1.getHealthComponent().setDead(true);
                    }
                    if (figure2.getHealthComponent().getHealthValue() == 0) {
                        figure2.getHealthComponent().setDead(true);
                    }
                }
            }
        }

        return collision;
    }

    public ArrayList<AbstractFigure> getFigures1() {
        return figures1;
    }

    public void setFigures1(ArrayList<AbstractFigure> figures1) {
        this.figures1 = figures1;
    }

    public ArrayList<AbstractFigure> getFigures2() {
        return figures2;
    }

    public void setFigures2(ArrayList<AbstractFigure> figures2) {
        this.figures2 = figures2;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

}
