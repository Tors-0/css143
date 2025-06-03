
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
        Node node = getRoot();

        // 70% chance to move to child node if possible
        while (!node.getChildren().isEmpty() && Math.random() < 0.70) {
            // pick a random child
            node = node.getChildren().get(
                    (int) (Math.random() * node.getChildren().size()));
        }
        node.addChild(nodeToAdd);
        return true;
    }

    /**
     * Create a node and add it randomly to the Tree.
     * @return true if successful
     */
    public boolean add() {
        return add(new Node());
    }

    public static Tree createSomeTree() {
        // create an empty tree with only a root
        Tree tree = new Tree(new Node());
        int count = 10 + (int) (Math.random() * 20);
        for (int i = 0; i < count; i++) {
            tree.add();
        }
        return tree;
    }
}
