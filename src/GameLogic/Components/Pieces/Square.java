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
 * BTO - Be there or be square...
 * vertical/horizontal mover
 * low medium capacity
 */
public class Square extends Piece {
    private final static int[][] MOVEMENT = {
            {0,0,1,0,0},
            {0,0,1,0,0},
            {1,1,0,1,1},
            {0,0,1,0,0},
            {0,0,1,0,0}
    };
    public Square(int playerID){
        super(playerID, Pieces.SQUARE.getCapacity(), MOVEMENT);
    }
}
