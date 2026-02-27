package lists;

/**
 * This class represents a single element in a {@link LinkedList}.
 */
public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> previous;

    public Node(E data, Node<E> next, Node<E> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Node(E data) {
        this(data, null, null);
    }

    //Non-Static Methods

    /**
     * This method can be used to check what kind of sentinel, if any, a node is.
     * @return 0 for a header sentinel. 1 for a tail sentinel. -1 for any other node.
     */
    public int isSentinel() {
        if (this.previous == null && this.next != null) {
            return 0;
        } else if (this.next == null && this.previous != null) {
            return 1;
        } else {
            return -1;
        }
    }

    public void setData(E newData) {
        this.data = newData;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrevious() {
        return previous;
    }
}
