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
