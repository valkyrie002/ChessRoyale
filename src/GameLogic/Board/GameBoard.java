package GameLogic.Board;

import GameLogic.Components.Board;
import GameLogic.Components.Piece;
import GameLogic.Components.Pieces.*;
import Util.Coordinate;

import java.util.Set;

/**
 * The board that the game is played on
 */
public class GameBoard implements Board {
    // Board dimensions
    private static final int HEIGHT = 8;
    private static final int WIDTH = 5;
    private static final Coordinate DIMENSIONS = new Coordinate(HEIGHT, WIDTH);

    // The board is a 2D array of Pieces? // TODO: could turn this into GameSquare Objects, which have piece and coordinate
    private final  Piece[][] board;

    /**
     *
     */
    public GameBoard() {
        //Instantiating the board
        board = new Piece[WIDTH][HEIGHT];
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
//                Coordinate coord = new Coordinate(i, j);
                board[i][j] = null;
            }
        }

        // Instantiate Triangles
        for (int i = 0; i < WIDTH * 2; i++) {
            // TODO, are we cool with Pieces knowing their coordinates rather than coordinates knowing their pieces?
            // One Triangle per column in the second and second from last rows
            int xCoord = i / 2;
            if (i % 2 == 0) {
                // Even Triangles in second row
                board[1][xCoord] = new Triangle(); //TODO: pieces should be associated with player (add constructor to all Pieces which takes in int)
            } {
                // Odd Triangles in second to last row
                board[HEIGHT - 2][xCoord] = new Triangle(); //TODO: pieces should be associated with player (add constructor to all Pieces which takes in int)
            }
        }

        // Squares in opposite corners
        board[0][0] = new Square();
        board[HEIGHT - 1][WIDTH - 1] = new Square();

        // Rhombuses in opposite corners
        board[0][WIDTH - 1] = new Rhombus();
        board[HEIGHT - 1][0] = new Rhombus();

        // Circles in opposite corners
        board[0][WIDTH - 2] = new Circle();
        board[HEIGHT - 1][1] = new Circle();

        // Hexagons in opposite corners
        board[0][WIDTH - 2] = new Hexagon();
        board[HEIGHT - 1][1] = new Hexagon();

        // TODO: king?

        // Fill Rest of topmost and bottommost rows with triangles?
        for (int i = 0; i < WIDTH; i++) {
            // Some peace of mind flags
            boolean flag1 = false;
            boolean flag2 = false;

            if (board[0][i] == null) {
                // Coordinate is empty, add Triangle
                board[0][i] = new Triangle();
                flag1 = true;
            }
            if (board[HEIGHT - 1][i] == null) {
                // Coordinate is empty, add Triangle
                board[HEIGHT - 1][i] = new Triangle();
                flag2 = false;
            }
            if (flag1 != flag2) {
                System.out.println("Things are not symmetrical in Game Board Constructor");
            }
        }
    }
    @Override
    public Coordinate getDimensions() {
        return DIMENSIONS;
    }

    @Override
    public Set<Coordinate> getObstacles() {
        return Set.of();
    }

    @Override
    public void movePiece(int player, Piece piece, Coordinate target) {
        // TODO: I think this should be two Coordinates rather than Piece and Coordinate
        // OR, we could do a Piece getter for a given coordinate?
        // OR, we could have the object which creates GameBoard create the Pieces, but that feels like too much to
        // pass into a single constructor potentially (we could pass in a list of Pieces)...

    }

    @Override
    public void removePiece(Piece piece) {

    }
}
