package GameLogic.Board;

import GameLogic.Components.Board;
import GameLogic.Components.Piece;
import GameLogic.Components.Pieces.*;
import Util.Coordinate;

import java.util.*;

/**
 * The board that the game is played on
 */
public class GameBoard implements Board {

    private static Board boardInstance;

    // Board dimensions
    private static final int HEIGHT = 7;
    private static final int WIDTH = 7;
    private static final int TERRITORY_HEIGHT = 3;
    private static final Coordinate DIMENSIONS = new Coordinate(HEIGHT, WIDTH);
    // The board is a 2D array of Pieces? // TODO: could turn this into GameSquare Objects, which have piece and coordinate
    private final  Piece[][] board;
    private final Set<Coordinate> obstacles;

    private final char[][] INIT_BOARD = {
            {'s', 's', 'h', 'c', 'r', 'r', 'k' },
            {'t', 't', 't', 't', 't', 't', 't'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'T', 'T', 'T', 'T', 'T', 'T', 'T'},
            {'K', 'R', 'R', 'C', 'H', 'S', 'S'}
    };

    /**
     * @return The singleton board instance
     */
    public static Board getInstance() {
        if (boardInstance == null) boardInstance = new GameBoard();
        return boardInstance;
    }

    /**
     *
     */
    private GameBoard() {
        board = new Piece[WIDTH][HEIGHT];
        obstacles = new HashSet<>();
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                switch (INIT_BOARD[i][j]) {
                    case 's' -> board[i][j] = new Square(1);
                    case 't' -> board[i][j] = new Triangle(1);
                    case 'r' -> board[i][j] = new Rhombus(1);
                    case 'h' -> board[i][j] = new Hexagon(1);
                    case 'c' -> board[i][j] = new Circle(1);
                    case 'k' -> board[i][j] = new King(1);
                    case 'S' -> board[i][j] = new Square(2);
                    case 'T' -> board[i][j] = new Triangle(2);
                    case 'R' -> board[i][j] = new Rhombus(2);
                    case 'H' -> board[i][j] = new Hexagon(2);
                    case 'C' -> board[i][j] = new Circle(2);
                    case 'K' -> board[i][j] = new King(2);
                    case ' ' -> board[i][j] = null;
                    case '#' -> obstacles.add(new Coordinate(i, j));
                    default -> {
                        board[i][j] = null;
                        System.out.println("WHAT ARE YOU DOING");
                    }
                }
            }
        }
    }

    @Override
    public Coordinate getDimensions() {
        return DIMENSIONS;
    }

    @Override
    public Set<Coordinate> getObstacles() {
        return obstacles;
    }

    //TODO: handle safety, integer return value based on result
    @Override
    public void movePiece(int player, Coordinate source, Coordinate target) {
        Piece moved = board[source.row()][source.col()];
        board[source.row()][source.col()] = null;
        board[target.row()][target.col()] = moved;
    }

    @Override
    public void removePiece(Coordinate coordinate) {
        board[coordinate.row()][coordinate.col()] = null;
    }

    @Override
    public int getTerritorySize() {
        return TERRITORY_HEIGHT;
    }

    @Override
    public Piece getPiece(Coordinate coordinate) {
        return board[coordinate.row()][coordinate.col()];
    }

    //TODO: handle safety, integer return value based on result
    @Override
    public int attack(int player, Coordinate source, Coordinate target) {
        //TODO
        return 0;
    }

    /**
     * does the space between the two coordinates contain a piece?
     * @param fst the initial coordinate
     * @param snd the final coordinate
     * @return true if the path between the two coordinates contains a piece,
     *         false otherwise
     */
    private boolean obstructed(Coordinate fst, Coordinate snd) {
        List<Coordinate> path = getPath(fst, snd);

        if (path == null) return false; // No path

        /* If any of the positions in the path contains a piece, then the path
         * is obstructed */
        for (Coordinate coord : path) {
            if (board[coord.row()][coord.col()] != null) {
                return true;
            }
        }
        return false;
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
                for (int i = init.row() - 1; i >= dest.row(); i--) {
                    path.add(new Coordinate(i, init.col()));
                }

            } else {
                // destination has higher row number, increment
                for (int i = init.row() + 1; i <= dest.row(); i++) {
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
                for (int i = init.col() - 1; i >= dest.col(); i--) {
                    path.add(new Coordinate(init.row(), i));
                }

            } else {
                // destination has higher column number => increment
                for (int i = init.col() + 1; i <= dest.col(); i++) {
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
            while (offset <= deltaX){
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

    static void main() {
        GameBoard gameBoard = new GameBoard();
        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(2, 2)));
        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(3, 3)));
        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(2, 3)));
        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(1, 4)));
        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(4, 1)));
        System.out.println(gameBoard.obstructed(new Coordinate(1, 1), new Coordinate(1, 4)));
        System.out.println(gameBoard.obstructed(new Coordinate(0, 0), new Coordinate(2, 0)));
        System.out.println(gameBoard.obstructed(new Coordinate(1, 0), new Coordinate(2, 0)));
        System.out.println(gameBoard.obstructed(new Coordinate(1, 0), new Coordinate(3, 2)));


    }
}
