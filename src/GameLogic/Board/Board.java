package GameLogic.Board;

import GameLogic.Components.Pieces.Piece;
import Util.Coordinate;

import java.util.Set;

public interface Board {
    Coordinate getDimensions();
    Set<Coordinate> getObstacles();

    /**
     * Moves a piece on the board
     *
     * @param source coordinate
     * @param target coordinate
     * @return 0 - success
     * 1 - target obstructed
     * 2 - source invalid
     * 3 - target invalid
     */
    int movePiece(Coordinate source, Coordinate target);
    void removePiece(Coordinate coordinate);
    int getTerritorySize();
    Piece getPiece(Coordinate coordinate);
    int attack(Coordinate source, Coordinate target);
}
