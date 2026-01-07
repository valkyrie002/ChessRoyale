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
 * The diagonal one
 * med/high capacity
 */
public class Rhombus implements Piece {
    private final int capacity = Pieces.RHOMBUS.getCapacity();
    private final int[][] movement = {
            {1,0,0,0,1},
            {0,1,0,1,0},
            {0,0,0,0,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
    };
    private List<Card> weapons;
    private final int playerID;


    public Rhombus(int playerID){
        this.playerID = playerID;
    }

    @Override
    public Set<Coordinate> getMovement() {
        return CoordinateFunctions.bitArrayToCoord(movement);
    }

    @Override
    public Set<Coordinate> getAttack() {
        Set<Coordinate> attack = new HashSet<>();
        for (Card c : weapons) {
            attack.addAll(c.getAttack());
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

    @Override
    public int getPlayerID() {
        return playerID;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
