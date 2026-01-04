package GameLogic.Components.Cards;

import GameLogic.Components.Card;
import Util.Coordinate;
import Util.CoordinateFunctions;

import java.util.Set;

/**
 * As basic as weapons get
 */
public class Dagger implements Card {
    private final int cost = 1;
    private final int[][] attack = {
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
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
