package GameLogic.Components;

import Util.Coordinate;

import java.util.List;
import java.util.Set;

public interface Piece {
    // TODO, have a get position, but no setPosition (do we want pieces tracking their own position,
    // it may be better to have board do that?)
    //TODO: pieces should be associated with player (add constructor to all Pieces which takes in int)
    Coordinate getPosition();
    Set<Coordinate> getMovement();
    Set<Coordinate> getAttack();
    List<Card> getWeapons();
    void takeDamage();
}
