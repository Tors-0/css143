
import java.util.*;

public class TicTacToeTree extends Tree {


   public TicTacToeTree(Node root) {
      super(root);
   }

   public static Tree createSomeTree() {
      Tree tree = new TicTacToeTree(new TicTacToeNode());

      // TODO: Once the Board class is imported with required implementation,
      // uncomment the following line
      // ((TicTacToeNode) tree.getRoot()).createChildren();

      return tree;
   }

}