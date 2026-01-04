package GameLogic.Components.Pieces;

import GameLogic.Components.Card;
import GameLogic.Components.Piece;
import Util.Coordinate;
import Util.CoordinateFunctions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BTO - Be there or be square...
 * vertical/horizontal mover
 * low medium capacity
 */
public class Square implements Piece {
    private Coordinate position;
    private final int capacity = 2;
    private final int[][] movement = {
            {0,0,1,0,0},
            {0,0,1,0,0},
            {1,1,0,1,1},
            {0,0,1,0,0},
            {0,0,1,0,0}
    };
    private List<Card> weapons;

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public Set<Coordinate> getMovement() {
        return CoordinateFunctions.bitArrayToCoord(movement,position);
    }

    @Override
    public Set<Coordinate> getAttack() {
        Set<Coordinate> attack = new HashSet<>();
        for (Card c : weapons) {
            attack.addAll(c.getAttack(position));
        }
        return attack;
    }

    @Override
    public List<Card> getWeapons() {
        return weapons;
    }

    @Override
    public void takeDamage() {
        weapons.remove(0);
        //TODO: Move to discard?
    }
}
