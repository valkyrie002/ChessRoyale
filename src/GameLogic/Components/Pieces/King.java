package GameLogic.Components.Pieces;

import GameLogic.Components.Card;
import GameLogic.Components.Piece;
import Util.Coordinate;
import Util.CoordinateFunctions;
import Util.Pieces;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The big boy himself
 */
public class King extends Piece {
    private static final int[][] MOVEMENT = {
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,1,0,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0}
    };
    public King(int playerID){
        super(playerID, Pieces.KING.getCapacity(), MOVEMENT);
    }
}
