package be.uantwerpen.fti.ei.Game.Components;

public class CollisionComponent {
    private int hitboxWidth;
    private int hitboxHeight;

    public CollisionComponent(int hitboxWidth, int hitboxHeight) {
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
    }

    public int getHitboxWidth() {
        return hitboxWidth;
    }

    public void setHitboxWidth(int hitboxWidth) {
        this.hitboxWidth = hitboxWidth;
    }

    public int getHitboxHeight() {
        return hitboxHeight;
    }

    public void setHitboxHeight(int hitboxHeight) {
        this.hitboxHeight = hitboxHeight;
    }
}
