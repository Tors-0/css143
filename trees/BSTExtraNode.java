public class BSTExtraNode extends BSTNode {

    private int nodeCount;
    private int height;
    private int sumTotal;

    public BSTExtraNode(int value) {
        super(value);
    }

    public String toString() {
        return String.format(
                "\n\n Value: %d\n nodeCount: %d\n height: %d\n total: %d",
                getInfo(),
                nodeCount,
                height,
                sumTotal
        );
    }

    public void processInfo() {
        this.nodeCount = this.countNodes();
        this.height = this.calculateHeight();
        this.sumTotal = this.sumTotal();

        if (getLeft() != null) {
            ((BSTExtraNode) getLeft()).processInfo();
        }
        if (getRight() != null) {
            ((BSTExtraNode) getRight()).processInfo();
        }
    }

    public boolean contains(BSTExtraNode other) {
        if (this.compareTo(other) < 0) {
            if (getLeft() != null) {
                return ((BSTExtraNode) getLeft()).contains(other);
            }
            return false;
        } else if (this.compareTo(other) > 0) {
            if (getRight() != null) {
                return ((BSTExtraNode) getRight()).contains(other);
            }
            return false;
        } else {
            return true;
        }
    }

    // Recursively count nodes
    private int countNodes() {
        int count = 1;
        if (getRight() != null) {
            count += ((BSTExtraNode) getRight()).countNodes();
        }
        if (getLeft() != null) {
            count += ((BSTExtraNode) getLeft()).countNodes();
        }
        return count;
    }

    // Recursively calculate height
    private int calculateHeight() {
        int leftHeight = 0;
        int rightHeight = 0;

        if (getRight() != null) {
            rightHeight = ((BSTExtraNode) getRight()).calculateHeight() + 1;
        }
        if (getLeft() != null) {
            leftHeight = ((BSTExtraNode) getLeft()).calculateHeight() + 1;
        }

        return Math.max(leftHeight, rightHeight);
    }

    // Recursively calculate sum
    private int sumTotal() {
        int total = this.getInfo();

        if (getLeft() != null) {
            total += ((BSTExtraNode) getLeft()).sumTotal();
        }
        if (getRight() != null) {
            total += ((BSTExtraNode) getRight()).sumTotal();
        }

        return total;
    }


}