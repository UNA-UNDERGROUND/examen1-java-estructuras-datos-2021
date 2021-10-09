package cr.ac.una.collections;

import java.util.Iterator;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2021-09-02
 *
 */
public class DIterator<T> implements Iterator<T> {

    public DIterator(DNode<T> first, DNode<T> last) {
        this.first = first;
        this.last = last;
        this.current = first;
    }

    public void restart(boolean atEnd) {
        current = (atEnd) ? last : first;
    }

    public void restart() {
        restart(false);
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    public boolean hasPrevious() {
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

    public T previous() {
        T r = null;
        if (hasPrevious()) {
            r = current.getInfo();
            current = current.getPrevious();
        }
        return r;
    }

    private final DNode<T> first;
    private final DNode<T> last;
    private DNode<T> current;
}
