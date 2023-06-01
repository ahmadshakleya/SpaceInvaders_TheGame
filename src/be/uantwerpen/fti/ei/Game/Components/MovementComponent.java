package be.uantwerpen.fti.ei.Game.Components;

public class MovementComponent {
    private int dx;
    private int dy;

    private int traagheid;

    public MovementComponent(int dx, int dy, int traagheid) {
        this.dx = dx;
        this.dy = dy;
        this.traagheid = traagheid;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getTraagheid() {
        return traagheid;
    }

    public void setTraagheid(int traagheid) {
        this.traagheid = traagheid;
    }
}
