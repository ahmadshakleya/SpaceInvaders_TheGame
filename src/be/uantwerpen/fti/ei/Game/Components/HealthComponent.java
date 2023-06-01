package be.uantwerpen.fti.ei.Game.Components;

public class HealthComponent {
    private int healthValue;

    private boolean dead = false;

    public HealthComponent(int healthValue) {
        this.healthValue = healthValue;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public boolean isDead() {
        dead = (healthValue == 0);
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
