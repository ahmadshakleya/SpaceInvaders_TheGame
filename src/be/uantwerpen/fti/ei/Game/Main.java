package be.uantwerpen.fti.ei.Game;

import be.uantwerpen.fti.ei.UI.Factory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory AF = new Factory(700, 500);
        Game game = new Game(AF);
        game.run();
    }
}