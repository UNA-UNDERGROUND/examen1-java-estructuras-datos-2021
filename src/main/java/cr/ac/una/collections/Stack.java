package cr.ac.una.collections;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.1 2021-08-24
 *
 */
public class Stack<T> {

    public Stack() {
        this.n = 0;
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    public int size() {
        return n;
    }

    public T top() {
        return (first != null) ? first.getInfo() : null;
    }

    public void push(T obj) {
        if (obj != null) {
            first = new Node<>(obj, first);
            n++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public T pop() {
        if (!isEmpty()) {
            T r = first.getInfo();
            first = first.getNext();
            n--;
            return r;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        Node<T> cursor = first;
        while (cursor != null) {
            r.append(cursor.getInfo());
            cursor = cursor.getNext();
            if (cursor != null) {
                r.append(", ");
            }
        }
        r.append("}");
        return r.toString();
    }

    private int n;
    private Node<T> first;
}
