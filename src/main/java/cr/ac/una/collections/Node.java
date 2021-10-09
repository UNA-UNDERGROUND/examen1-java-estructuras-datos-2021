package cr.ac.una.collections;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2021-08-21
 *
 */
public class Node<T> { // Link

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this(info, null);
    }

    public T getInfo() {
        return info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    private T info;
    private Node<T> next;
}
