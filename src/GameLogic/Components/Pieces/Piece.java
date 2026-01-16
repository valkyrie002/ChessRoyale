package GameLogic.Components.Pieces;

import GameLogic.Components.Cards.Card;
import Util.Constants;

import java.util.LinkedList;
import java.util.List;

public abstract class Piece {
    protected final int capacity;
    protected final int[][] movement;
    protected final List<Card> weapons;
    protected final int playerID;
    protected final PieceType pieceType;
    protected boolean inCombat;

    public Piece(int playerID, PieceType pieceType, int[][] movement) {
        this.playerID = playerID;
        this.capacity = pieceType.getCapacity();
        this.movement = movement;
        this.pieceType = pieceType;
        inCombat = false;
        weapons = new LinkedList<>();
    }
    public int[][] getMovement(){
        return movement;
    };
    public int[][] getAttack(){
        int[][] attack = new int[Constants.ARRAY_SIZE][Constants.ARRAY_SIZE];

        for (int i = 0; i < Constants.ARRAY_SIZE; i++) {
            for (int j = 0; j < Constants.ARRAY_SIZE; j++) {
                // Set base attack (currently only for hexagon)
                if (movement[i][j] == 2) {
                    attack[i][j] = 1;
                }
            }
        }

        // Update attack based on all equipped weapons
        for (Card c : weapons) {
            int[][] cAttack = c.getAttack();
            for (int i = 0; i < Constants.ARRAY_SIZE; i++) {
                for (int j = 0; j < Constants.ARRAY_SIZE; j++) {
                    if (attack[i][j] < cAttack[i][j]) {
                        attack[i][j] = cAttack[i][j];
                    }
                }
            }
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

    /**
     * @return the Piece Type
     */
    public PieceType getType() {
        return pieceType;
    }
}
