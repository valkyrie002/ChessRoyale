package GameLogic.Components;

import Util.Coordinate;

import java.util.Set;

public interface Board {
    Coordinate getDimensions();
    Set<Coordinate> getObstacles();
    void movePiece(int player, Coordinate source, Coordinate target);
    void removePiece(Piece piece);
}
