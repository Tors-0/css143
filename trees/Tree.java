
//Implements a Tree that acts like a BST (Binary Search Tree)
public class Tree {

   private Node root;

   // Note that we have no Default constructor

   public Tree(Node root) {
      this.root = root;
   }

   public Node getRoot() {
      return root;
   }

   /**
    * Add this specific node to the tree in a random way.
    * 
    * @param nodeToAdd The node to add
    * @return true if successful
    */
   public boolean add(Node nodeToAdd) {
      // TODO
      return false;
   }

   /**
    * Create a node and add it randomly to the Tree.
    * @return true if successful
    */
   public boolean add() {
      // TODO
      return false;
   }

   public static Tree createSomeTree() {
      // create an empty tree with only a root
      Tree tree = new Tree(new Node());
      return tree;
   }
}
