package GameLogic.Components.Pieces;

import GameLogic.Components.Piece;
import Util.Pieces;

/**
 * Mr potential himself
 * this one has no base movement
 * instead relies on weapons to give him power
 */
public class Circle extends Piece {
    private final static int[][] MOVEMENT = {
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,1,0,1,0},
            {0,0,1,0,0},
            {0,0,0,0,0}
    };

    public Circle(int playerID){
        super(playerID, Pieces.CIRCLE.getCapacity(), MOVEMENT);
    }
}
