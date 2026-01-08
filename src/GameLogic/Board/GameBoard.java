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
    private static final int HEIGHT = 7;
    private static final int WIDTH = 7;
    private static final int TERRITORY_HEIGHT = 3;
    private static final Coordinate DIMENSIONS = new Coordinate(HEIGHT, WIDTH);
    // The board is a 2D array of Pieces? // TODO: could turn this into GameSquare Objects, which have piece and coordinate
    private final  Piece[][] board;
    private Set<Coordinate> obstacles;

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
     *
     */
    public GameBoard() {
        board = new Piece[WIDTH][HEIGHT];
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

    @Override
    public int attack(int player, Coordinate source, Coordinate target) {
        //TODO
        return 0;
    }
}
