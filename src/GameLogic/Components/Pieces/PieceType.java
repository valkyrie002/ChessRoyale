package GameLogic.Components.Pieces;

/**
 * All the pieces in the game have a constant cost id number
 */
public enum PieceType {
    TRIANGLE(1, 1, 't'),
    SQUARE(  2, 2, 's'),
    RHOMBUS( 3, 3, 'r'),
    HEXAGON( 4, 1, 'h'),
    CIRCLE(  5, 4, 'c'),
    KING(    6, 0, 'k');

    // The number associated with this Piece
    private final int value;

    // The capacity of this piece
    private final int capacity;

    // Character rep
    private final char character;

    /**
     * An enum constructor
     *
     * @param id piece identification number
     * @param k
     */
    PieceType(int id, int capacity, char k) {
        this.value = id;
        this.capacity = capacity;
        this.character = k;
    }

    public int getID() {return value;}
    public int getCapacity() {return capacity;}

    @Override
    public String toString() {
        return character + "";
    }
}
