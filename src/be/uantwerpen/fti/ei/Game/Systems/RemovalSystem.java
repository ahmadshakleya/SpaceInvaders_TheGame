package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractFigure;

import java.util.ArrayList;

public class RemovalSystem {
    private ArrayList<AbstractFigure> abstractFigures;

    private ArrayList<Boolean> removeObjects = new ArrayList<>();
    public RemovalSystem(ArrayList<AbstractFigure> abstractFigures) {
        this.abstractFigures = abstractFigures;
        for (int i = 0; i < this.abstractFigures.size(); i++) {
            removeObjects.add(false);
        }
    }

    public void removeEntities() {
        if (abstractFigures != null) {
            for (var figure: abstractFigures) {
                if (figure.getHealthComponent().isDead()) {
                    removeObjects.set(abstractFigures.indexOf(figure), true);
                }
            }
        }
    }

    public void updateRemovalSystem() {
        for (var object: removeObjects) {
            if (object) {
                removeObjects.remove(object);
            }
        }
    }

    public ArrayList<AbstractFigure> getAbstractFigures() {
        return abstractFigures;
    }

    public void setAbstractFigures(ArrayList<AbstractFigure> abstractFigures) {
        this.abstractFigures = abstractFigures;
        removeObjects = new ArrayList<>();
        for (int i = 0; i < this.abstractFigures.size(); i++) {
            removeObjects.add(false);
        }
    }

    public ArrayList<Boolean> getRemoveObjects() {
        return removeObjects;
    }

    public void setRemoveObjects(ArrayList<Boolean> removeObjects) {
        this.removeObjects = removeObjects;
    }
}
