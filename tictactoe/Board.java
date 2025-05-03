
import java.util.*;

/**
 * This class keeps track of the board and controls access to the board's
 * pieces.
 * 
 * It has a copy constructor.
 * 
 * It can:
 * make a move on the board (place a piece)
 * give a list of moves available yet to be made
 * display itself via toString()
 * determine whose move it is
 * determine if there is a winner or a draw
 * 
 * @author ---Student name goes here---
 *
 */
public class Board {
    // These are used by getWinner() method.
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public static final int DRAW_GAME = 0;
    public static final int NO_WINNER = 3;

    /*
     * Your Board class should have very few instance fields.
     * All instance fields will be private.
     * 
     * The board HAS-A storage for all the X & O pieces on the board.
     * Students should write comments that explain how an X vs O is represented.
     * 
     * The board class may HAS-A count of the X's and O's pieces on the board.
     * How you store the pieces on the board can make your code simple or complex.
     * 
     * 
     * Think about how you want to represent the board.
     * Here are 6 typical ways that students have stored the board:
     * - String
     * - int[]
     * - int[][]
     * - String[]
     * - String[][]
     * - char[][]
     * 
     * That's it. No more instance fields!
     */
    private char[][] board = new char[3][3];

    /**
     * This constructor will create an empty board.
     */
    public Board() {

    }

    /**
     * The Copy Constructor will do a DEEP copy of an existing Board.
     * 
     * @param copyMe The Board to copy.
     */
    public Board(Board copyMe) {

    }

    /**
     * Gets who will move next: "X" or "O"
     * 
     * @return "X" or "O"
     */
    public String getNextMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextMove'");
    }

    // The board must be able to print itself nicely.
    public String toString() {
        // TODO: Student must implement this
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    /**
     * Makes the requested move on the board.
     *
     * The board will know whose turn it is next. It will place the appropriate
     * piece, X or O. It just knows!
     *
     * @param location as {row, col}
     */
    public void doMove(int[] location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doMove'");
    }

    /**
     * Gets all the moves one can make on this board as a 2D array.
     * If the game is over, this should return an empty array.
     * 
     * The first dimension is the move number (0-index). It must match exactly
     * how many moves are available to make. (i.e. it cannot always be of size 9.)
     * 
     * The second dimension is an array for { row, col }. For example, { 2, 1 } is
     * the bottom row, middle column.
     * 
     * @return 2D array of moves
     */
    public int[][] getAvailableMoves() {
        // IMPORTANT: If the game is over, this should return an empty array.
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableMoves'");
    }

    /**
     * The board can figure out if there is a winner, or if the game
     * has ended in a draw.
     * Use the Board constants:
     * Board.PLAYER_X
     * Board.PLAYER_O
     * Board.DRAW_GAME
     * Board.GAME_NOT_OVER
     * 
     * @return the value of the winner, or Draw, or game not over
     */
    public int getWinner() {
        // TODO: implement the ability to determine a winner/draw.
        throw new UnsupportedOperationException("Unimplemented method 'getWinner'");
    }

    /**
     * Determines if the game is over. Someone won. Or, it's a draw.
     * @return true of the game is over.
     */
    public boolean isGameOver() {
        // TODO: implement this.
        throw new UnsupportedOperationException("Unimplemented method 'isGameOver'");
    }

}
