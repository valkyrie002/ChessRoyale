package GameLogic.Components;

import Util.Coordinate;

import java.util.Set;

public interface Card {
    Set<Coordinate> getAttack(Coordinate ref);
    int getCost();
}
