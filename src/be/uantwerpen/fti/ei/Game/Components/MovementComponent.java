package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a movement component in the Space Invaders game.
 * The movement component defines the velocity and inertia of an entity.
 *
 * @author Ahmad Shakleya
 */
public class MovementComponent {
    /**
     * The velocity of the entity along the x-axis.
     */
    private int dx;

    /**
     * The velocity of the entity along the y-axis.
     */
    private int dy;

    /**
     * The inertia or resistance to changes in velocity of the entity.
     */
    private final int traagheid;

    /**
     * Constructs a new MovementComponent with the specified velocities and inertia.
     *
     * @param dx        the velocity of the entity along the x-axis
     * @param dy        the velocity of the entity along the y-axis
     * @param traagheid the inertia or resistance to changes in velocity
     */
    public MovementComponent(int dx, int dy, int traagheid) {
        this.dx = dx;
        this.dy = dy;
        this.traagheid = traagheid;
    }

    /**
     * Retrieves the velocity of the entity along the x-axis.
     *
     * @return the velocity along the x-axis
     */
    public int getDx() {
        return dx;
    }

    /**
     * Sets the velocity of the entity along the x-axis.
     *
     * @param dx the new velocity along the x-axis
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * Retrieves the velocity of the entity along the y-axis.
     *
     * @return the velocity along the y-axis
     */
    public int getDy() {
        return dy;
    }

    /**
     * Sets the velocity of the entity along the y-axis.
     *
     * @param dy the new velocity along the y-axis
     */
    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * Retrieves the inertia or resistance to changes in velocity of the entity.
     *
     * @return the inertia of the entity
     */
    public int getTraagheid() {
        return traagheid;
    }
}
