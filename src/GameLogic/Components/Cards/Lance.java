package GameLogic.Components.Cards;

/**
 * Radial Ranged Weapon
 */
public class Lance implements Card {
    private final int cost = 3;
    private final int[][] attack = {
            {0,0,1,0,0},
            {0,1,0,1,0},
            {1,0,0,0,1},
            {0,1,0,1,0},
            {0,0,1,0,0}
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
