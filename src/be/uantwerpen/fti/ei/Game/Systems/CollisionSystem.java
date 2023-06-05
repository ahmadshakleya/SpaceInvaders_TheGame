package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractFigure;

import java.util.ArrayList;

/**
 * The CollisionSystem class is responsible for detecting collisions between figures and updating their health values accordingly.
 * It maintains two lists of figures and provides a method to check for collisions between them.
 * If a collision is detected, the health values of the figures involved are decreased.
 * The CollisionSystem is used for testing collisions and reducing the health value of the second parameter.
 *
 * @author Ahmad Shakleya
 */
public class CollisionSystem {
    private ArrayList<AbstractFigure> figures1;
    private ArrayList<AbstractFigure> figures2;

    /**
     * Constructs a CollisionSystem object with the given lists of figures.
     *
     * @param abstractFigures1 The first list of figures.
     * @param abstractFigures2 The second list of figures.
     */
    public CollisionSystem(ArrayList<AbstractFigure> abstractFigures1, ArrayList<AbstractFigure> abstractFigures2) {
        figures1 = abstractFigures1;
        figures2 = abstractFigures2;
    }

    /**
     * Checks for collisions between the figures and updates their health values if a collision occurs.
     *
     * @return True if a collision is detected, false otherwise.
     */
    public boolean CollisionDetected() {
        boolean collision = false;

        if (figures1 != null && figures2 != null) {
            for (AbstractFigure figure1 : figures1) {
                if (figure1.getHealthComponent().getHealthValue() <= 0) {
                    continue;
                }

                for (AbstractFigure figure2 : figures2) {
                    if (figure2.getHealthComponent().getHealthValue() <= 0) {
                        continue;
                    }

                    if (figure1.x() <= figure2.x() + figure2.w()
                            && figure2.x() <= figure1.x() + figure1.w()
                            && figure1.y() <= figure2.y() + figure2.h()
                            && figure2.y() <= figure1.y() + figure1.h()) {
                        collision = true;
                        figure1.getHealthComponent().setHealthValue(figure1.getHealthComponent().getHealthValue() - 1);
                        figure2.getHealthComponent().setHealthValue(figure2.getHealthComponent().getHealthValue() - 1);

                        if (figure1.getHealthComponent().getHealthValue() == 0) {
                            figure1.getHealthComponent().setDead(true);
                        }

                        if (figure2.getHealthComponent().getHealthValue() == 0) {
                            figure2.getHealthComponent().setDead(true);
                        }

                        break; // Exit the inner loop if a collision occurred
                    }
                }
            }
        }

        return collision;
    }

    /**
     * Sets the first list of figures.
     *
     * @param figures1 The first list of figures.
     */
    public void setFigures1(ArrayList<AbstractFigure> figures1) {
        this.figures1 = figures1;
    }

    /**
     * Retrieves the second list of figures.
     *
     * @return The second list of figures.
     */
    public ArrayList<AbstractFigure> getFigures2() {
        return figures2;
    }

    /**
     * Sets the second list of figures.
     *
     * @param figures2 The second list of figures.
     */
    public void setFigures2(ArrayList<AbstractFigure> figures2) {
        this.figures2 = figures2;
    }

}
