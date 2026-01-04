package GameLogic.Components.Cards;

import GameLogic.Components.Card;
import Util.Coordinate;
import Util.CoordinateFunctions;

import java.util.Set;

/**
 * This one is tricky
 */
public class Boomerang implements Card {
    private final int cost = 3;
    private final int[][] attack = {
            {0,1,0,1,0},
            {1,0,0,0,1},
            {0,0,0,0,0},
            {1,0,0,0,1},
            {0,1,0,1,0}
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
