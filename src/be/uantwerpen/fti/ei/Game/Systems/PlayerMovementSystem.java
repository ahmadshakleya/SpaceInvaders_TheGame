package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import java.util.ArrayList;

/**
 * The PlayerMovementSystem class is responsible for updating the movement of player entities.
 * It updates the position of the players based on their movement component and screen boundaries.
 *
 * @author Ahmad Shakleya
 */
public class PlayerMovementSystem {
    private ArrayList<AbstractPlayer> players;

    /**
     * Constructs a PlayerMovementSystem object with the specified list of players.
     *
     * @param players The list of player entities.
     */
    public PlayerMovementSystem(ArrayList<AbstractPlayer> players) {
        this.players = players;
    }

    /**
     * Updates the movement of the player entities.
     * It updates the position of the players based on their movement component and ensures they stay within the screen boundaries.
     */
    public void updatePlayerMovement() {
        if (players != null) {
            for (var player : players) {
                player.getPositionComponent().setX(player.getPositionComponent().getX() + player.getMovementComponent().getDx());

                if (player.getPositionComponent().getX() + player.getMovementComponent().getDx() > player.getSizeComponent().getScreenwidth() / player.getSizeComponent().getSize() - player.getCollisionComponent().getHitboxWidth()) {
                    player.getPositionComponent().setX(player.getSizeComponent().getScreenwidth() / player.getSizeComponent().getSize() - player.getCollisionComponent().getHitboxWidth());
                }

                if (player.getPositionComponent().getX() + player.getMovementComponent().getDx() < 1) {
                    player.getPositionComponent().setX(2);
                }

                player.setDirectionChanged(false);
            }
        }
    }

    /**
     * Sets the list of player entities.
     *
     * @param players The list of player entities.
     */
    public void setPlayers(ArrayList<AbstractPlayer> players) {
        this.players = players;
    }
}
