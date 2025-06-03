public class TicTacToeTree extends Tree {


    public TicTacToeTree(Node root) {
        super(root);
    }

    public static Tree createSomeTree() {
        Tree tree = new TicTacToeTree(new TicTacToeNode());

        ((TicTacToeNode) tree.getRoot()).createChildren();

        return tree;
    }

}