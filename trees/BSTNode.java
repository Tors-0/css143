import java.awt.event.MouseEvent;

/*
 * This class:
 *    - is a node for a Binary Search Tree... a BSTNode.
 *    - inherits from Node so that the BST can be drawn.
 *    - IS-A Node that HAS-A integer
 *
 * This class will:
 *   - provide an abstraction for Left and Right children.
 *   - have getters/setters for Left/Right children.
 *   - have a default constructor to hold a simple zero integer value.
 *   - have a constructor to set this node to a specific integer value.
 *   - implement Comparable<> for convenient comparisons.
 *   - override toString() to display information nicely.
 *
 */
public class BSTNode extends Node implements Comparable<BSTNode> {
    private int info;

    public BSTNode(int info) {
        super();
        // left child is first, index 0
        getChildren().add(null);
        // right child is second, index 1
        getChildren().add(null);
        this.info = info;
    }

    public void setLeft(BSTNode node) {
        // TODO
    }

    public void setRight(BSTNode node) {
        // TODO
    }

    public BSTNode getLeft() {
        // TODO
        return null;
    }

    public BSTNode getRight() {
        // TODO
        return null;
    }

    public int getInfo() {
        // TODO
        return 0;
    }

    public String toString() {
        // TODO
        return "   This is my popup display";
    }

    @Override
    public void clickEvent(int modifiers) {
        if ((modifiers & MouseEvent.CTRL_DOWN_MASK) > 0) {
            System.out.println("Values in Pre-Order");
            printPreOrder();
        } else if ((modifiers & MouseEvent.SHIFT_DOWN_MASK) > 0) {
            System.out.println("Values in Post-order");
            printPostOrder();
        } else {
            System.out.println("Values in order:");
            printInOrder();
        }
        System.out.println();
    }

    /**
     * This method will add a Node to myself, "this" node.
     * This method uses recursion to add the node to the correct child.
     *
     * @param toAdd The node to add
     * @return true if successful
     */
    public boolean add(BSTNode toAdd) {
        // TODO Implement this method
        return false;
    }

    private void printPostOrder() {
        if (getLeft() != null) {
            getLeft().printPreOrder();
        }
        if (getRight() != null) {
            getRight().printPreOrder();
        }
        System.out.print(getInfo() + " ");
    }

    private void printPreOrder() {
        System.out.print(getInfo() + " ");
        if (getLeft() != null) {
            getLeft().printPreOrder();
        }
        if (getRight() != null) {
            getRight().printPreOrder();
        }
    }

    private void printInOrder() {
        if (getLeft() != null) {
            getLeft().printPreOrder();
        }
        System.out.print(getInfo() + " ");
        if (getRight() != null) {
            getRight().printPreOrder();
        }
    }

    @Override
    // implementation of Comparable. Can be used to search the tree, or to
    // sort the nodes, or a variety of tasks using Comparable.
    public int compareTo(BSTNode o) {
        return this.info - o.info;
    }
}
