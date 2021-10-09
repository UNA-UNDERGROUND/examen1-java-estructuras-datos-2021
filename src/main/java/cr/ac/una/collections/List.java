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
public class List<T> extends Collection<T> {

    public List(String name) {
        super(name);
        this.n = 0;
        this.first = this.last = null;
    }

    public List() {
        this(null);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void add(T obj) {
        if (obj != null) {
            Node<T> tmp = new Node<>(obj);
            if (first == null) {
                first = last = tmp;
            } else {
                last.setNext(tmp);
                last = tmp;
            }
            n++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void add(T obj, int pos) {
        if (obj != null) {
            if ((pos < 0) || (n <= pos)) {
                add(obj);
            } else {
                if (pos == 0) {
                    first = new Node<>(obj, first);
                    if (first.getNext() == null) {
                        last = first;
                    }
                } else {
                    Node<T> cursor = first;
                    int k = 1;
                    while (k < pos) {
                        cursor = cursor.getNext();
                        k++;
                    }
                    cursor.setNext(new Node<>(obj, cursor.getNext()));
                    if (cursor.getNext() == null) {
                        last = cursor;
                    }
                }
                n++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T remove() {
        T r = null;
        if (!isEmpty()) {
            if (first == last) {
                r = last.getInfo();
                first = last = null;
            } else {
                Node<T> cursor = first;
                while (cursor.getNext() != last) {
                    cursor = cursor.getNext();
                }
                r = cursor.getNext().getInfo();
                cursor.setNext(null);
                last = cursor;
            }
            n--;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return r;
    }

    @Override
    public T remove(int pos) {
        T r = null;
        if (pos == (n - 1)) {
            r = remove();
        } else {
            if ((0 <= pos) && (pos < n)) {
                Node<T> tmp;
                if (pos == 0) {
                    r = first.getInfo();
                    tmp = first;
                    first = first.getNext();
                } else {
                    Node<T> cursor = first;
                    int k = 0;
                    while (k < (pos - 1)) {
                        cursor = cursor.getNext();
                        k++;
                    }
                    r = cursor.getNext().getInfo();
                    tmp = cursor.getNext();
                    cursor.setNext(cursor.getNext().getNext());
                    if (cursor.getNext() == null) {
                        last = cursor;
                    }
                }
                tmp.setNext(null);
                n--;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return r;
    }

    @Override
    public T remove(T obj) {
        T r = null;
        if (!isEmpty()) {
            if (first.getInfo().equals(obj)) {
                r = remove(0);
            } else {
                Node<T> cursor = first;
                boolean found = false;
                while ((cursor.getNext() != null) && !found) {
                    if (!(found = cursor.getNext().getInfo().equals(obj))) {
                        cursor = cursor.getNext();
                    }
                }
                if (found) {
                    r = cursor.getNext().getInfo();
                    Node<T> tmp = cursor.getNext();
                    cursor.setNext(cursor.getNext().getNext());
                    tmp.setNext(null);
                    if (cursor.getNext() == null) {
                        last = cursor;
                    }
                    n--;
                }
            }
        }
        return r;
    }

    @Override
    public T get(int pos) {
        T r = null;
        if ((0 <= pos) && (pos < size())) {

            Iterator<T> i = iterator();
            int k = 0;
            while (k < pos) {
                i.next();
                k++;
            }
            r = i.next();
        }
        return r;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
    }

    private int n;
    private Node<T> first;
    private Node<T> last;

}
