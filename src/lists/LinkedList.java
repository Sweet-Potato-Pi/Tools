package lists;

/**
 * This class defines a linked list object which contains data of some type {@link E}. Linked lists like this store data in a chain-like configuration where the only way to get an object at a certain index is to iterate along the chain of previous {@link Node Nodes}.
 */
public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList(Node<E> head, Node<E> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public LinkedList() {
        this(new Node<>(null, null, null), new Node<>(null, null, null), 0);
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public Node<E> get(int index){
        try {
            if (index > this.size - 1) {
                throw new IndexOutOfBoundsException();
            }
            Node<E> current = head;
            for (int i = 0; i <= index; i++) {
                current = current.getNext();
            }
            return current;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Node<E> node){
        node.setNext(tail);
        node.setPrevious(tail.getPrevious());
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);

        this.size++;
    }

    public void add(E element){
        Node<E> node = new Node<>(element);
        node.setNext(tail);
        node.setPrevious(tail.getPrevious());
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);

        this.size++;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String out = "{\n";
        Node<E> current = head;
        for (int i = 0; i < this.getSize(); i++) {
            current = current.getNext();
            out += "@" + i + ": " + current.getData() + "\n";
        }
        return out + "}";
    }

}
