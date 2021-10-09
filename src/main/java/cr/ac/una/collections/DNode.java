package cr.ac.una.collections;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2021-09-19
 *
 */
public class DNode<T> {

    public DNode(T info, DNode<T> next, DNode<T> previous) {
        this.info = info;
        this.next = next;
        this.previous = previous;
    }

    public DNode(T info) {
        this(info, null, null);
    }

    public T getInfo() {
        return info;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DNode<T> previous) {
        this.previous = previous;
    }

    private T info;
    private DNode<T> next;
    private DNode<T> previous;
}
