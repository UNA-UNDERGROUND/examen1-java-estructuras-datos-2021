package cr.ac.una.collections;

import java.util.Iterator;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.1 2021-08-24 1.0.0 2021-08-21
 */
public class Array<T> extends Collection<T> {

    public Array(int m, String name) {
        super(name);
        this.e = new Object[m];
    }

    public Array(int m) {
        this(m, null);
    }

    public Array() {
        this(MAX_ARRAY, null);
    }

    public int maxCapacity() {
        return e.length;
    }

    @Override
    public void add(T obj) {
        if ((obj != null) && (n < e.length)) {
            e[n++] = obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void add(T obj, int pos) {
        if ((pos < 0) || (n <= pos)) {
            pos = n;
        }
        if (obj != null) {
            if (n < e.length) {
                for (int i = n; i > pos; i--) {
                    e[i] = e[i - 1];
                }
                e[pos] = obj;
                n++;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T remove() {
        return remove(size() - 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int pos) {
        T r = null;
        if ((0 <= pos) && (pos < n)) {
            r = (T) e[pos];
            for (int i = pos; i < n; i++) {
                e[i] = e[i + 1];
            }
            n--;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return r;
    }

    @Override
    public T remove(T e) {
        T r = null;
        int p = getPosition(e);
        if (p >= 0) {
            r = remove(p);
        } else {
            throw new IllegalArgumentException();
        }
        return r;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int pos) {
        T r = null;
        if ((0 <= pos) && (pos < n)) {
            r = (T) e[pos];
        }
        return r;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(n, e);
    }

    private static final int MAX_ARRAY = 128;
    private Object[] e;

}
