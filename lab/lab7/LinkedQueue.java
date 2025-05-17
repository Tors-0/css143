/**
 * This class implements a queue with linked list
 * the offer() and poll() methods are responsible for maintaining FIFO order
 *
 * @author Meng Yang
 * @author Rae Johnston
 */

public class LinkedQueue {
    // This is an inner class specifically utilized for LinkedStack class,
    // thus no setter or getters are needed
    private static class Node {
        private Object data;
        private Node next;

        // Constructor with no parameters for inner class
        public Node() {
            data = null;
            next = null;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
        
    } // end of inner class

    private Node front;
    private Node back;

    public LinkedQueue() {
        front = null;
        back = null;
    }

    // Adds the object at the back of the queue
    public void offer(Object data) {
        if (front == null) {
            front = back = new Node(data, null);
        } else {
            back.next = new Node(data, null);
            back = back.next;
        }
    }

    /**
     * Removes the head of the queue and returns it,
     * or returns null if the queue is empty.
     *
     * @return the head of the queue
     */
    public Object poll() {
        if (front == null) {
            return null;
        } else {
            Node retVal = front;
            front = front.next;
            return retVal;
        }
    }

    // Returns the size of linked list by traversing the list
    public int size() {
        int size = 0;
        Node current = front;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Retrieves, but does not remove, the head of this queue,
    // or returns null if this queue is empty.
    public Object peek() {
        return front.data;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return true is this queue is empty
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return a string representation of this queue
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = front;

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
     * Indicates whether some object is equal to this queue.
     * For two lists to be equal, they must contain the same
     * data items in the same order.
     *
     * @param other the object to compare with
     * @return true if the argument is the same as this queue
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedQueue that)) {
            return false;
        }
        if (this.size() != that.size()) {
            return false;
        }

        Node thisNode = this.front;
        Node thatNode = that.front;
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