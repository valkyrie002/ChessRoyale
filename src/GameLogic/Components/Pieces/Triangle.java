package GameLogic.Components.Pieces;

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
        super(playerID, PieceType.TRIANGLE, MOVEMENT);
    }
}
