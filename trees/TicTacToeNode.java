/**
 * Used to generate a full tree recursively using the Board.
 * Each node will know what move was made to reach it.
 */
public class TicTacToeNode extends Node {

    private Board board;
    private Move parentEdge;
    private int xWin;
    private int oWin;
    private int draw;

    // 3 required getters
    public int getXWins() {
        return xWin;
    }
    public int getOWins() {
        return oWin;
    }
    public int getDraws() {
        return draw;
    }

    public TicTacToeNode() {
        // root node only
        super();
        board = new Board();
    }

    public TicTacToeNode(Board copyMe, Move move) {
        super();
        // need to copy the board
        this.board = new Board(copyMe);
        this.parentEdge = move;
    }

    // Use the board's ID (simplified string of the Board)
    @Override
    public int hashCode() {
        return this.board.hashCode();
    }

    @Override
    public String getNodeDisplay() {
        if (this.parentEdge == null) {
            return "R";
        }
        return (this.parentEdge.location()) + "";
    }

    @Override
    public String toString() {
        return String.format("%sxWins:%d\noWins:%d\ndraws:%d", board.toString(), xWin, oWin, draw);
    }

    // another required getter
    public Move getParentEdge() {
        return this.parentEdge;
    }

    // If we have no moves, calc the wins/draws. This is NOT recursive.
    public void calcWins() {
        // if we have no children, find winner/draw
        if (this.getChildren().size() == 0) {
            int winner = board.getWinner();
            if (winner == Board.PLAYER_X) {
                xWin = 1;
            } else if (winner == Board.PLAYER_O) {
                oWin = 1;
            } else {
                draw = 1;
            }
        }
    }

    public void createChildren() {

        // represents all the moves we can make... empty spots.
        int[][] moves = board.getAvailableMoves();

        // if we have no moves, we are a leaf, calc our wins/draws
        // and then exit
        if (moves.length == 0) {
            calcWins();
            return;
        }

        String turn = board.getNextMove();

        for (int[] move : moves) {
            // make a clone of the board with the move made to get here
            Move edge = new Move(move[0]*3 + move[1], turn);
            TicTacToeNode child = new TicTacToeNode(this.board, edge);

            child.board.doMove(move);
            this.addChild(child);
            child.createChildren();

            // sum up this node's wins/draws
            xWin += child.xWin;
            oWin += child.oWin;
            draw += child.draw;
        }
    }

}
