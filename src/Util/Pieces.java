package Util;

/**
 * All the pieces in the game have a constant cost id number
 */
public enum Pieces {
    TRIANGLE(1, 1),
    SQUARE(  2, 2),
    RHOMBUS( 3, 3),
    HEXAGON( 4, 1),
    CIRCLE(  5, 4);

    // The number associated with this Piece
    private final int value;

    // The capacity of this piece
    private final int capacity;

    /**
     * An enum constructor
     * @param id piece identification number
     */
    Pieces(int id, int capacity) {
        this.value = id;
        this.capacity = capacity;
    }

    public int getID() {return value;}
    public int getCapacity() {return capacity;}
}
