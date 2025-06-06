/*
 * This class implements a BST (Binary Search Tree)
 * Nodes may have repeated values.
 * All children on the Left are < self.
 * All children on the Right are >= self.
 *
 * The contents of each mode is a simple primitive integer.
 *
 * This class:
 *   - provides the ability to add a value to the tree.
 *   - encapsulates the root
 */

public class BSTTree extends Tree {

    // our constructor
    public BSTTree(BSTNode root) {
        super(root);
        if (getRoot() == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Add a node with a random value 0-99.
     * @return true if successful
     */
    @Override
    public boolean add() {
        return add((int) (Math.random() * 100));
    }

    /**
     * Create a new node of the correct Base Type for this Tree.
     * Derived classes should override.
     * This allows us to reuse the add(value) method.
     */
    public BSTNode createNewNode(int value) {
        return new BSTNode(value);
    }

    /**
     * This adds a value to the Tree. We create a Node and
     * add it to our root node iteratively or recursively.
     *
     * @param value The integer value to add to the tree
     * @return true if successful
     */
    public boolean add(int value) {
        // Calling the method to create our node allows
        // child classes to reuse this method.
        BSTNode newNode = createNewNode(value);
        BSTNode root = (BSTNode) this.getRoot();

        return root.add(newNode);
    }

    public static Tree createSomeTree() {
        int rootValue = (int) (Math.random()*10) + 45;
        BSTTree tree = new BSTTree(new BSTNode(rootValue));

        int count = (int) (10 + Math.round(Math.random() * 10));
        for (int i = 0; i < count; i++) {
            tree.add();
        }

        return tree;
    }
}
