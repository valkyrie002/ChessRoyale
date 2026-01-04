package GameLogic.Components.Cards;

import GameLogic.Components.Card;
import Util.Coordinate;
import Util.CoordinateFunctions;

import java.util.Set;

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
    public Set<Coordinate> getAttack(Coordinate ref) {
        return CoordinateFunctions.bitArrayToCoord(attack,ref);
    }

    @Override
    public int getCost() {
        return cost;
    }
}
