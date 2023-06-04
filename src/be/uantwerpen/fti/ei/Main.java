package be.uantwerpen.fti.ei;

import be.uantwerpen.fti.ei.Game.AbstractFactory;
import be.uantwerpen.fti.ei.Game.Game;
import be.uantwerpen.fti.ei.UI_CUBE.FactoryCUBE;
import be.uantwerpen.fti.ei.UI_J2D.J2DFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory AF = new J2DFactory("\\src\\be\\uantwerpen\\fti\\ei\\configFile.txt");
        //AbstractFactory AF = new FactoryCUBE("\\src\\be\\uantwerpen\\fti\\ei\\configFile.txt");
        Game game = Game.getInstance(AF);
        game.run();
    }
}