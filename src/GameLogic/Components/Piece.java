package GameLogic.Components;

import Util.Coordinate;

import java.util.List;
import java.util.Set;

public interface Piece {
    Coordinate getPosition();
    Set<Coordinate> getMovement();
    Set<Coordinate> getAttack();
    List<Card> getWeapons();
    void takeDamage();
}
