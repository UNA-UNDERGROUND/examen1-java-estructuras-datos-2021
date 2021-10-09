package cr.ac.una.collections;

import java.util.Iterator;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2021-08-21
 *
 */
public class ListIterator<T> implements Iterator<T> {

    public ListIterator(Node<T> first) {
        this.first = first;
        this.current = first;
    }

    public void restart() {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T r = null;
        if (hasNext()) {
            r = current.getInfo();
            current = current.getNext();
        }
        return r;
    }

    private final Node<T> first;
    private Node<T> current;
}
