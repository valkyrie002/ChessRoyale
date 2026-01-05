package Util;

/**
 * All the cards in the game have a constant cost id number
 */
public enum Cards {
    DAGGER(       1, 1),
    PITCHFORK(    2, 1),
    SHIELD(       3, 1),
    SLINGSHOT(    4, 1),
    CHAIN_MACE(   5, 2),
    SWORD(        6, 2),
    BOW(          7, 2),
    LANCE(        8, 3),
    BOOMERANG(    9, 3),
    WIZARD_STAFF(10, 4);

    // ID for graphics
    private final int id;

    // The cost of this card
    private final int cost;

    /**
     * Enum constructor
     * @param id this card's identification number
     * @param cost the cost of this card
     */
    Cards(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public int getID() {return id;}
    public int getCost() {return cost;}
}
