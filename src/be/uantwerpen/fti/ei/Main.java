package be.uantwerpen.fti.ei;

import be.uantwerpen.fti.ei.Game.AbstractFactory;
import be.uantwerpen.fti.ei.Game.Game;
import be.uantwerpen.fti.ei.UI.Factory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory AF = new Factory("\\src\\be\\uantwerpen\\fti\\ei\\configFile.txt");
        Game game = new Game(AF);
        game.run();
    }
}