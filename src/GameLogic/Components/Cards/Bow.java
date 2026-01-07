package GameLogic.Components.Cards;

import GameLogic.Components.Card;
import Util.CoordinateFunctions;

/**
 * Diagonal Sniper
 */
public class Bow implements Card{
    private final int cost = 2;
    private final int[][] attack = {
            {1,0,0,0,1},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
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
