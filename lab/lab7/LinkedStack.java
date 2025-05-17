/**
 * This class uses nodes to form a stack as a linked list.
 * the push() and pop() methods are responsible for maintaining LIFO order
 *
 * @author Rae Johnston
 **/
public class LinkedStack {
    /**
     * This is an inner class specifically utilized for LinkedStack class,
     * thus no setter or getters are needed
     */
    private static class Node {
        private Object data; // the data stored in this node
        private Node next; // a reference to the next node in the list

        // Constructor with no parameters for inner class
        public Node() {
            data = null;
            next = null;
        }

        // TODO Define a constructor with parameters for the data and the reference to the next node
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    } // end of inner class

    private Node head; // a reference to the first node in the list

    /**
     * Constructor with no parameters for outer class
     */
    public LinkedStack() {
        head = null;
    }

    /**
     * Adds a node as the first node element at the start of the list with the specified data.
     *
     * @param data the object to store in the node
     */
    public void push(Object data) {
        this.head = new Node(data, this.head);
        // Note: It is possible, though not necessary, to implement this method with a single line.
    }

    /**
     * Removes the top node in the stack and returns its data,
     * or returns null if the stack is empty.
     *
     * @return the data at the top of the stack
     */
    public Object pop() {
        if (this.head == null) {
            return null;
        } else {
            Node out = this.head;
            this.head = this.head.next;
            return out.data;
        }
    }

    /**
     *  Returns the size of linked list by traversing the list.
     *
     * @return the size of the list
     */
    public int size() {
        Node cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    // Finds if there is a match for the given object
    public boolean contains(Object data) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.equals(data)) return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * Finds the first node containing the target item, and returns a
     * reference to that node. Return null if target not found.
     */
    private Node findData(Object target) {
        Node current = head;
        Object itemAtPosition;
        while (current != null) {
            itemAtPosition = current.data;

            if (itemAtPosition.equals(target)) {
                return current;
            }
            current = current.next;
        }
        return null; // target not found
    }

    /**
     * Prints this list to the console.
     */
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        if (current != null) {
            if (current.data != null) {
                result.append(current.data);
            }
            current = current.next;
        }
        while (current != null) {
            if (current.data != null) {
                result.append(", ").append(current.data);
            }
            current = current.next;
        }
        return result.toString();
    }

    /**
     * Indicates whether this stack is empty.
     *
     * @return true if this stack is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Empties the stack of all elements.
     */
    public void clear() {
        head = null;
    }

    /**
     * Two lists are equal if they contain the same data in the same order.
     *
     * @param other the list to compare against
     * @return true if this list is the same as the other
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedStack that)) {
            return false;
        }
        if (this.size() != that.size()) {
            return false;
        }

        Node thisNode = this.head;
        Node thatNode = that.head;
        while (thisNode != null) {
            if (!thisNode.data.equals(thatNode.data)) {
                return false;
            }
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        return true;
    }
}