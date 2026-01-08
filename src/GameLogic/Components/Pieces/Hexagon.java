package GameLogic.Components.Pieces;

import GameLogic.Components.Piece;
import Util.Pieces;

/**
 * The amazon
 * a fierce warrior with little weapon wielding ability
 */
public class Hexagon extends Piece {
    private final static int[][] MOVEMENT = {
            {1,0,1,0,1},
            {0,1,2,1,0},
            {1,2,0,2,1},
            {0,1,2,1,0},
            {1,0,1,0,1}
    };
    public Hexagon(int playerID){
        super(playerID, Pieces.HEXAGON.getCapacity(), MOVEMENT);
    }
}
