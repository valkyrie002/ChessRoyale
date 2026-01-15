package Util;

public record Coordinate(int row, int col) {
    /**
     * Is this coordinate equal to that coordinate?
     * @param obj   the reference object with which to compare.
     * @return true if they have same row and col, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Coordinate) {
            Coordinate that = (Coordinate) obj;
            if (this.row == that.row && this.col == that.col) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
