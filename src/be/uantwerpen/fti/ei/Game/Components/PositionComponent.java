package be.uantwerpen.fti.ei.Game.Components;

public class PositionComponent {
    private int x;
    private int y;

    private int initialX;
    private int initialY;


    public PositionComponent(int x, int y) {
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getInitialX() {
        return initialX;
    }


    public int getInitialY() {
        return initialY;
    }

    public void resetPosition() {
        this.x = initialX;
        this.y = initialY;
    }

}
