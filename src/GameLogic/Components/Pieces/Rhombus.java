package GameLogic.Components.Pieces;

import GameLogic.Components.Piece;

/**
 * The diagonal one
 * med/high capacity
 */
public class Rhombus extends Piece {
    private final static int[][] MOVEMENT = {
            {1,0,0,0,1},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
    };
    public Rhombus(int playerID){
        super(playerID,Pieces.RHOMBUS.getCapacity(), MOVEMENT);
    }
}
