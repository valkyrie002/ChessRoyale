package GameLogic.Board;

import GameLogic.Components.Pieces.Piece;
import GameLogic.Components.Pieces.*;
import Util.Constants;
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
        int p1 = Constants.PLAYER_ONE;
        int p2 = Constants.PLAYER_TWO;

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                switch (INIT_BOARD[i][j]) {
                    case 's' -> board[i][j] = new Square(p2);
                    case 't' -> board[i][j] = new Triangle(p2);
                    case 'r' -> board[i][j] = new Rhombus(p2);
                    case 'h' -> board[i][j] = new Hexagon(p2);
                    case 'c' -> board[i][j] = new Circle(p2);
                    case 'k' -> board[i][j] = new King(p2);
                    case 'S' -> board[i][j] = new Square(p1);
                    case 'T' -> board[i][j] = new Triangle(p1);
                    case 'R' -> board[i][j] = new Rhombus(p1);
                    case 'H' -> board[i][j] = new Hexagon(p1);
                    case 'C' -> board[i][j] = new Circle(p1);
                    case 'K' -> board[i][j] = new King(p1);
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

    /**
     * Moves a piece on the board
     * @param source coordinate
     * @param target coordinate
     * @return
     * 0 - success
     * 1 - target obstructed
     * 2 - source invalid
     * 3 - target invalid
     */
    @Override
    public int movePiece(Coordinate source, Coordinate target) {


        if (!PathFunctions.validSrc(source)){
            return 2;
        }

        if (!PathFunctions.validDest(1, source, target)) {
            return 3;
        }

        if (PathFunctions.obstructed(source, target)) {
            return 1;
        }

        Piece moved = board[source.row()][source.col()];
        System.out.println(moved);
        board[source.row()][source.col()] = null;
        board[target.row()][target.col()] = moved;
        return 0;
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
    public int attack(Coordinate source, Coordinate target) {
        //TODO
        return 0;
    }

    /**
     * @return string rep of the board
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Piece p = board[i][j];
                if (p == null) {
                    sb.append(".");
                    continue;
                }
                switch (p.getType()) {
                    case CIRCLE -> {
                        if (p.getPlayerID() == Constants.PLAYER_ONE) {
                            sb.append("C");
                        } else {
                            sb.append("c");
                        }
                    }
                    case TRIANGLE -> {
                        if (p.getPlayerID() == Constants.PLAYER_ONE) {
                            sb.append("T");
                        } else {
                            sb.append("t");
                        }
                    }
                    case HEXAGON -> {
                        if (p.getPlayerID() == Constants.PLAYER_ONE) {
                            sb.append("H");
                        } else {
                            sb.append("h");
                        }
                    }
                    case SQUARE -> {
                        if (p.getPlayerID() == Constants.PLAYER_ONE) {
                            sb.append("S");
                        } else {
                            sb.append("s");
                        }
                    }
                    case KING -> {
                        if (p.getPlayerID() == Constants.PLAYER_ONE) {
                            sb.append("K");
                        } else {
                            sb.append("k");
                        }
                    }
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    static void main() {
        GameBoard gameBoard = new GameBoard();
//        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(2, 2)));
//        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(3, 3)));
//        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(2, 3)));
//        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(1, 4)));
//        System.out.println(getPath(new Coordinate(1, 1), new Coordinate(4, 1)));
//        System.out.println(gameBoard.obstructed(new Coordinate(1, 1), new Coordinate(1, 4)));
//        System.out.println(gameBoard.obstructed(new Coordinate(0, 0), new Coordinate(2, 0)));
//        System.out.println(gameBoard.obstructed(new Coordinate(1, 0), new Coordinate(2, 0)));
//        System.out.println(gameBoard.obstructed(new Coordinate(1, 0), new Coordinate(3, 2)));
        System.out.println(gameBoard.movePiece(new Coordinate(1, 1), new Coordinate(2, 2)));
        System.out.println(gameBoard);
        System.out.println(gameBoard.movePiece(new Coordinate(HEIGHT - 1, 1), new Coordinate(HEIGHT - 2, 1)));
        System.out.println(gameBoard);

        System.out.println(gameBoard.movePiece(new Coordinate(1, 1), new Coordinate(2, 1)));
        System.out.println(gameBoard);


    }
}
