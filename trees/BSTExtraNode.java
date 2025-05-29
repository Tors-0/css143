public class BSTExtraNode extends BSTNode {

   // TODO: Add instance fields here

   public BSTExtraNode(int value) {
      super(value);
   }

   public String toString() {
      return "TODO";
   }

   public void processInfo() {
      // TODO: process the root's information:
      // * count all the children
      // * calculate height
      // * sum total
      // When called, "this" node should be the root.
   }
   
   public boolean contains(BSTExtraNode other) {
      // TODO: cursively determine if "other" node
      // is equal to "this" node or any of "this" children. 
      // Use: node.compareTo()
      return false;
   }

   // Recursively count nodes
   private int countNodes() {
      // TODO: recursively count "this" node and its children.
      // Save the count in an instance field to display later.
      return 0;
   }

   // Recursively calculate height
   private int calculateHeight() {
      // TODO: recursively calculate this height of "this" node.
      // "This" height = max(leftChild, rightChild) + 1
      // If we have no children, our height is 0.
      // Save the height in an instance field to display later.
      return 0;
   }

   // Recursively calculate sum
   private int sumTotal() {
      // TODO: recursively calculate the sum of "this" node's info value
      // along with all of its children.
      // Save the sum in an instance field to display later.
      return 0;
   }
}