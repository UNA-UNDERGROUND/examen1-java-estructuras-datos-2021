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
public class ArrayIterator<T> implements Iterator<T> {

    public ArrayIterator(int k, Object[] v) {
        this.k = k;
        this.i = 0;
        this.v = v;
    }

    public void restart() {
        i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < k;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
        T r = null;
        if (hasNext()) {
            r = (T) v[i++];
        }
        return r;
    }

    private final int k;
    private int i;
    private final Object[] v;
}
