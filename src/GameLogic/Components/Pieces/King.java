package GameLogic.Components.Pieces;

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
        super(playerID, PieceType.KING, MOVEMENT);
    }
}
