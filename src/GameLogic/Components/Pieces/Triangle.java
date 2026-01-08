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
 * Evil Little Guy
 * Foot Soldier Unit
 * Limited movement and capacity
 */
public class Triangle extends Piece {
    private final static int[][] MOVEMENT = {
        {0,0,0,0,0},
        {0,0,1,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0}
    };
    public Triangle(int playerID) {
        super(playerID, Pieces.TRIANGLE.getCapacity(), MOVEMENT);
    }
}
