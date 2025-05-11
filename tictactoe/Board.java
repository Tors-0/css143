
import java.util.*;

/**
 * This class keeps track of the board and controls access to the board's
 * pieces.
 * <br>
 * It has a copy constructor.
 * <br>
 * It can:
 * <br> - make a move on the board (place a piece)
 * <br> - give a list of moves available yet to be made
 * <br> - display itself via toString()
 * <br> - determine whose move it is
 * <br> - determine if there is a winner or a draw
 * 
 * @author Rae Johnston
 *
 */
public class Board {
    // These are used by getWinner() method.
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public static final int DRAW_GAME = 0;
    public static final int GAME_NOT_OVER = 3;

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
    /**
     * An "X" move is represented by a 'X' char at the corresponding location,
     * and likewise with an "O" represented by 'O'. blank tiles are ' '
     */
    private char[] board;
    private int emptySpaces = 9;

    /**
     * This constructor will create an empty board.
     */
    public Board() {
        board = new char[9];
        Arrays.fill(board, ' ');
    }

    /**
     * The Copy Constructor will do a DEEP copy of an existing Board.
     * 
     * @param copyMe The Board to copy.
     */
    public Board(Board copyMe) {
        this.board = Arrays.copyOf(copyMe.board, 9);
        this.emptySpaces = copyMe.emptySpaces;
    }

    /**
     * Gets who will move next: "X" or "O"
     * 
     * @return "X" or "O"
     */
    public String getNextMove() {
        if (emptySpaces % 2 == 0) {
            return "O";
        } else {
            return "X";
        }
    }

    private static final String rowDivider = "\n-----\n";
    // The board must be able to print itself nicely.
    public String toString() {
        return String.format("%c|%c|%c %s%c|%c|%c %s%c|%c|%c",
                board[0],
                board[1],
                board[2],
                rowDivider,
                board[3],
                board[4],
                board[5],
                rowDivider,
                board[6],
                board[7],
                board[8]
        );
    }

    /**
     * Makes the requested move on the board.
     * <br>
     * The board will know whose turn it is next. It will place the appropriate
     * piece, X or O. It just knows!
     *
     * @param location as {row, col}
     */
    public void doMove(int[] location) {
        int realLocation = location[0] * 3 + location[1];
        board[realLocation] = getNextMove().charAt(0);
        emptySpaces--;
    }

    /**
     * Gets all the moves one can make on this board as a 2D array.
     * If the game is over, this should return an empty array.
     * <br>
     * The first dimension is the move number (0-index). It must match exactly
     * how many moves are available to make. (i.e. it cannot always be of size 9.)
     * <br>
     * The second dimension is an array for { row, col }. For example, { 2, 1 } is
     * the bottom row, middle column.
     * 
     * @return 2D array of moves
     */
    public int[][] getAvailableMoves() {
        // IMPORTANT: If the game is over, this should return an empty array.
        if (isGameOver()) {
            return new int[0][0];
        }

        int[][] moves = new int[emptySpaces][2];
        for (byte boardPos = 0, movePos = 0; boardPos < board.length; boardPos++) {
            if (board[boardPos] == ' ') {
                moves[movePos] = new int[]{boardPos / 3, boardPos % 3};
                movePos++;
            }
        }
        return moves;
    }

    private final static int[][] winConditions = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
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
        if (emptySpaces > 4) {
            return Board.GAME_NOT_OVER;
        }

        char checkVal;
        for (int[] checkRow : winConditions) {
            checkVal = checkSpaces(checkRow[0],checkRow[1],checkRow[2]);
            if (checkVal == 'X') {
                return Board.PLAYER_X;
            } else if (checkVal == 'O') {
                return Board.PLAYER_O;
            }
        }

        if (emptySpaces == 0) return Board.DRAW_GAME;
        else return Board.GAME_NOT_OVER;
    }

    private char checkSpaces(int a, int b, int c) {
        if (board[a] == board[b] && board[b] == board[c]) {
            return board[a];
        }
        return ' ';
    }

    /**
     * Determines if the game is over. Someone won. Or, it's a draw.
     * @return true of the game is over.
     */
    public boolean isGameOver() {
        return getWinner() != Board.GAME_NOT_OVER;
    }

}
