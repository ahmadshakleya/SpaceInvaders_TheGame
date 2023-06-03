package be.uantwerpen.fti.ei.Game.Systems;

import be.uantwerpen.fti.ei.Game.Entities.AbstractPlayer;

import java.util.ArrayList;

public class PlayerMovementSystem {
    private ArrayList<AbstractPlayer> players;

    public PlayerMovementSystem(ArrayList<AbstractPlayer> players) {
        this.players = players;
    }
    public void updatePlayerMovement() {
        for (var player: players) {
            player.getPositionComponent().setX((player.getPositionComponent().getX() + player.getMovementComponent().getDx()));
            if ((player.getPositionComponent().getX() + player.getMovementComponent().getDx()) > player.getSizeComponent().getScreenwidth() / player.getSizeComponent().getSize() - player.getCollisionComponent().getHitboxWidth()) {
                player.getPositionComponent().setX(player.getSizeComponent().getScreenwidth() / player.getSizeComponent().getSize() - player.getCollisionComponent().getHitboxWidth());
            }
            if ((player.getPositionComponent().getX() + player.getMovementComponent().getDx()) < 1) {
                player.getPositionComponent().setX(2);
            }
            player.setDirectionChanged(false);
        }
    }

    public ArrayList<AbstractPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<AbstractPlayer> players) {
        this.players = players;
    }
}
