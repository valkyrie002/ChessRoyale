package GameLogic.Components.Cards;

/**
 * This one is tricky
 */
public class Boomerang implements Card {
    private final int cost = 3;
    private final int[][] attack = {
            {0,2,0,2,0},
            {2,0,0,0,2},
            {0,0,0,0,0},
            {2,0,0,0,2},
            {0,2,0,2,0}
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
