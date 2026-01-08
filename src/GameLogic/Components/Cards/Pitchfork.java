package GameLogic.Components.Cards;

import GameLogic.Components.Card;
import Util.CoordinateFunctions;

/**
 * This one attacks like a pawn
 */
public class Pitchfork implements Card {
    private final int cost = 1;
    private final int[][] attack = {
            {0,0,0,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };
    @Override
    public int[][] getAttack() {
        return attack;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
