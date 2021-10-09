package cr.ac.una.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2021-09-02 1.0.1 2021-10-07
 *
 */
public class DQueue<T> extends Collection<T> {

    public DQueue() {
        this.first = this.last = null;
    }

    @Override
    public void add(T obj) {
        if (obj != null) {
            DNode<T> t = new DNode<>(obj, null, last);
            if (isEmpty()) {
                first = last = t;
            } else {
                last.setNext(t);
                last = t;
            }
            n++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void add(T obj, int pos) {
        if (obj != null) {
            if ((pos < 0) || (size() <= pos)) {
                pos = size();
            }
            if (pos == size()) { // La lista está vacía o se agrega al final..
                add(obj);
            } else {
                DNode<T> z = findPosition(pos);
                DNode<T> t = new DNode<>(obj, z, z.getPrevious());

                if (pos == 0) { // El elemento es ahora el primero de la lista..
                    first = t;
                } else {
                    t.getPrevious().setNext(t);
                }

                if (pos == size()) { // El elemento es el último de la lista..
                    last = t;
                } else {
                    t.getNext().setPrevious(t);
                }

                // Observe que el valor del contador debe actualizarse
                // luego de verificar el valor de la última posición,
                // para el valor de size() sea el correcto.
                //
                n++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T remove() { // O(1)
        T r = null;
        if (!isEmpty()) {
            r = deleteNode(last);
        } else {
            throw new IllegalArgumentException();
        }
        return r;
    }

    @Override
    public T remove(int pos) { // O(n)
        T r = null;
        if (!isEmpty()) {
            try {
                r = deleteNode(findPosition(pos));
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return r;
    }

    @Override
    public T remove(T obj) { // O(n)
        T r = null;
        if (!isEmpty()) {
            try {
                r = deleteNode(findValue(obj));
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return r;
    }

    private T deleteNode(DNode<T> d) {
        // https://www.baeldung.com/java-assert
        assert (d != null);

        T r = d.getInfo();

        if (d == first) {
            first = first.getNext();
            if (first != null) {
                first.setPrevious(null);
            } else { // El nodo era el único dentro de la lista.
                last = null;
            }
            d.setNext(null);
        } else if (d == last) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            d.getPrevious().setNext(d.getNext());
            d.getNext().setPrevious(d.getPrevious());
        }

        d.setNext(null);
        d.setPrevious(null);
        n--;

        return r;
    }

    @Override
    public T get(int pos) {
        return findPosition(pos).getInfo();
    }

    @Override
    public Iterator<T> iterator() {
        return new DIterator<>(first, last);
    }

    // El método que encuentra la posición i-ésima de
    // la lista es O(n/2) en promedio. Al buscar
    // el primer elemento (en la posición 0), el método
    // no necesita recorrer la lista.
    //
    private DNode<T> findPosition(int i) {
        if ((0 <= i) && (i < size())) {
            DNode<T> cursor = first;
            int k = 0;
            while (k < i) {
                cursor = cursor.getNext();
                k++;
            }
            assert ((k == i) && (cursor != null));
            return cursor;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // Regresa el nodo que contiene al objeto indicado
    // como parámetro.
    //
    private DNode<T> findValue(T obj) {
        if (obj != null) {
            DNode<T> cursor = first;
            boolean found = false;
            while (cursor != null && !found) {
                if (!(found = cursor.getInfo().equals(obj))) {
                    cursor = cursor.getNext();
                }
            }
            if (!found) {
                throw new NoSuchElementException();
            }
            return cursor;
        } else {
            throw new IllegalArgumentException();
        }
    }

    protected DNode<T> first; // 2021-10-07
    protected DNode<T> last;
}