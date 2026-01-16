package GameLogic.Board;

import Util.Coordinate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathFunctions {


    public boolean validMove(Coordinate init, Coordinate dest) {
        Board gb = GameBoard.getInstance();
    }

    /**
     * does the space between the two coordinates contain a piece?
     * @param fst the initial coordinate
     * @param snd the final coordinate
     * @return true if the path between the two coordinates contains a piece,
     *         false otherwise
     */
    public boolean obstructed(Coordinate fst, Coordinate snd) {
        List<Coordinate> path = getPathPlusDest(fst, snd);

        if (path == null) return false; // No path

        /* If any of the positions in the path contains a piece, then the path
         * is obstructed */
        for (Coordinate coord : path) {
            if (GameBoard.getInstance().getPiece(new Coordinate(coord.row(), coord.col())) != null) {
                return true;
            }
        }
        return false;
    }

    private static List<Coordinate> getPathPlusDest(Coordinate init, Coordinate dest){
        List<Coordinate> path = getPath(init, dest);
        path.add(dest);
        return path;
    }
    /**
     *  Get path from one coordinate to another if it exists
     *      * direct paths only: straight lines and diagonals)
     *      * Path includes dest, but not init
     * @param init the initial coordinate
     * @param dest the destination coordinate
     * @return A list of coordinates starting at init and ending at dest
     */
    private static List<Coordinate> getPath(Coordinate init, Coordinate dest) {
        int deltaY = Math.abs(dest.row() - init.row());
        int deltaX = Math.abs(dest.col() - init.col());

        if (init.equals(dest)) {
            // Same coordinate, empty path
            // TODO: should this be null?
            return new LinkedList<>();
        }


        if (deltaY <= 1 && deltaX <= 1) {
            // init and dest are "adjacent", path is simply dest
            ArrayList<Coordinate> path = new ArrayList<>();
            path.add(dest);
            return path;
        }

        // init and dest in the same column
        if (deltaX == 0){
            List<Coordinate> path = new ArrayList<>();

            if (dest.row() < init.row()) {
                // destination has lower row number => decrement
                for (int i = init.row() - 1; i > dest.row(); i--) {
                    path.add(new Coordinate(i, init.col()));
                }

            } else {
                // destination has higher row number, increment
                for (int i = init.row() + 1; i < dest.row(); i++) {
                    path.add(new Coordinate(i, init.col()));
                }
            }

            // return path from init to destination
            return path;
        }

        // init and dest in the same row
        if (deltaY == 0){
            List<Coordinate> path = new ArrayList<>();

            if (dest.col() < init.col()) {
                // destination has lower column number => decrement
                for (int i = init.col() - 1; i > dest.col(); i--) {
                    path.add(new Coordinate(init.row(), i));
                }

            } else {
                // destination has higher column number => increment
                for (int i = init.col() + 1; i < dest.col(); i++) {
                    path.add(new Coordinate(init.row(), i));
                }
            }

            // return path from init to destination
            return path;
        }

        // init and dest have a diagonal path between them
        if (deltaX == deltaY){
            boolean incX = false; // incrementing or decrementing x?
            boolean incY = false; // incrementing or decrementing y?
            List<Coordinate> path = new ArrayList<>();


            if (dest.row() > init.row()) {
                // incrementing y
                incY = true;
            }
            if (dest.col() > init.col()) {
                // incrementing x
                incX = true;
            }

            int offset = 1;
            int x;
            int y;

            // Create the path
            while (offset < deltaX){
                if (incX) {
                    x = init.row() + offset;
                } else {
                    x = init.row() - offset;
                }

                if (incY) {
                    y = init.row() + offset;
                } else {
                    y = init.row() - offset;
                }
                path.add(new Coordinate(y, x));
                offset++;
            }

            return path;
        }

        // No such path exists, return null
        return null;
    }
}
