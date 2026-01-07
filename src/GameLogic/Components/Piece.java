package GameLogic.Components;

import Util.Coordinate;
import Util.CoordinateFunctions;
import Util.Pieces;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Piece {
    protected final int capacity;
    protected final int[][] movement;
    protected final List<Card> weapons;
    protected final int playerID;
    protected boolean inCombat;

    public Piece(int playerID, int capacity,  int[][] movement) {
        this.playerID = playerID;
        this.capacity = capacity;
        this.movement = movement;
        inCombat = false;
        weapons = new LinkedList<>();
    }
    public int[][] getMovement(){
        return movement;
    };
    public int[][] getAttack(){
        Set<Coordinate> attack = new HashSet<>();
        for (Card c : weapons) {
            attack.addAll(c.getAttack());
        }
        return attack;
    }
    public List<Card> getWeapons(){
        return weapons;
    }

    /**
     * @return -1 if dead, number of weapons otherwise
     */
    public int takeDamage(){
        if (weapons.size() > 0) {
            weapons.remove(0);
            return weapons.size();
        } else {
            // You dead
            return -1;
        }
    }
    public int getPlayerID(){
        return playerID;
    }
    public int getCapacity(){
        return capacity;
    }

    public boolean inCombat(){
        return inCombat;
    }

    /**
     * @param card Try to equip the given weapon
     * @return 0 if success
     *         1 if in Combat
     *         2 if overcapacity
     */
    public int equipWeapon(Card card){
        if (inCombat) {
            return 1;
        }

        int weaponSum = 0;
        for (Card c : weapons) {
            weaponSum += c.getCost();
        }
        weaponSum += card.getCost();

        if (weaponSum > capacity) {
            return 2;
        }

        weapons.add(card);

        return 0;
    }
}
