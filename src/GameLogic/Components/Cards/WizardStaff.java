package GameLogic.Components.Cards;

import GameLogic.Components.Card;
import Util.CoordinateFunctions;

/**
 * The ultimate weapon
 */
public class WizardStaff implements Card {
    private final int cost = 4;
    private final int[][] attack = {
            {2,0,2,0,2},
            {0,1,1,1,0},
            {2,1,0,1,2},
            {0,1,1,1,0},
            {2,0,2,0,2}
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
