import java.util.*;

/**
 * This class keeps track of the board by completing moves.
 * It can determine if a move is valid, give a list
 * of available moves yet to be made, print itself nicely,
 * and determine if there is a winner.
 * 
 * @author StudentName
 *
 */
public class Board {
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public static final int DRAW_GAME = 0;
    public static final int GAME_NOT_OVER = 3;

    public Board() {
        // starting board, all empty
    }
    
    // TODO: Implement a copy constructor
    public Board(Board object) {

    }

    /**
     * Gets the winner of this board.
     * 
     * @return The winner (PLAYER_X, PLAYER_O, DRAW_GAME, GAME_NOT_OVER)
     */
    public int getWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWinner'");
    }

    /**
     * Gets all the available moves one can make on this board as a 2D array.
     * If the game is over, this should return an empty array.
     * 
     * The first dimension is the move number (0-index). It must match exactly
     * how many moves are available to make. (i.e. it cannot always be of size 9.)
     * 
     * The second dimension is an array for { row, col }. For example, { 2, 1 } is
     * the
     * bottom row, middle column.
     * 
     * @return 2D array of moves
     */
    public int[][] getAvailableMoves() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMoves'");
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

    /**
     * Makes the requested move on the board.
     * 
     * @param location
     */
    public void doMove(int[] location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doMove'");
    }

}