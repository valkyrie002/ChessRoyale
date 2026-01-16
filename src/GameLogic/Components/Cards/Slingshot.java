package GameLogic.Components.Cards;

/**
 * Simple ranged attack
 */
public class Slingshot implements Card {
    private final int cost = 1;
    private final int[][] attack = {
            {0,0,2,0,0},
            {0,0,0,0,0},
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
