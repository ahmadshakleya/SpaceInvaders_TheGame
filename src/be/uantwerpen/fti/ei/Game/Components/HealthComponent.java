package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a health component in the Space Invaders game.
 * The health component maintains the health value of an entity and determines if it is dead.
 *
 *
 * @author Ahmad Shakleya
 */
public class HealthComponent {
    /**
     * The current health value of the entity.
     */
    private int healthValue;

    /**
     * Indicates whether the entity is dead or not.
     */
    private boolean dead = false;

    /**
     * Constructs a new HealthComponent with the specified health value.
     *
     * @param healthValue the initial health value of the entity
     */
    public HealthComponent(int healthValue) {
        this.healthValue = healthValue;
    }

    /**
     * Retrieves the current health value of the entity.
     *
     * @return the health value of the entity
     */
    public int getHealthValue() {
        return healthValue;
    }

    /**
     * Sets the current health value of the entity.
     *
     * @param healthValue the new health value of the entity
     */
    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    /**
     * Checks if the entity is dead.
     * An entity is considered dead when its health value reaches zero.
     *
     * @return true if the entity is dead, false otherwise
     */
    public boolean isDead() {
        dead = (healthValue == 0);
        return dead;
    }

    /**
     * Sets the dead state of the entity.
     *
     * @param dead the new dead state of the entity
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
