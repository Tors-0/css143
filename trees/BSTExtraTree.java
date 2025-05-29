public class BSTExtraTree extends BSTTree {

    public BSTExtraTree(BSTExtraNode root) {
        super(root);
    }

    /**
     * Create a new node of the correct Base Type for this Tree.
     */
    @Override
    public BSTNode createNewNode(int value) {
        return new BSTExtraNode(value);
    }

    /**
     * Determines if the tree contains a value.
     *
     * @param value The value to search for
     * @return true if the Tree contains the value.
     */
    public boolean contains(int value) {
        BSTNode node = (BSTNode) this.getRoot();
        while (node != null && node.getInfo() != value) {
            if (node.getInfo() < value) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        return node != null;
    }

    /**
     * Verify that the value is not already in the tree. Add it
     * only if the node value is unique.
     * @param value The value to add to the tree.
     * @return true if successful
     */
    @Override
    public boolean add(int value) {
        return !contains(value) && super.add(value);
    }

    public static BSTExtraTree createSomeTree() {
        // create our root node first close to value 50
        int value = 50;
        BSTExtraNode root = new BSTExtraNode(value);

        BSTExtraTree tree = new BSTExtraTree(root);
        // have a total of 15-25 nodes in this tree
        // TODO:

        // Process all the information in our tree
        root.processInfo();

        return tree;
    }
}