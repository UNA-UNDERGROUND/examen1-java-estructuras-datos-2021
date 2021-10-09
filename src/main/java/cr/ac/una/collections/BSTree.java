package cr.ac.una.collections;

public class BSTree<T extends Comparable<T>> {

    public BSTree() {
        this.root = null;
    }

    public int size() {
        return (root == null) ? 0 : root.size();
    }

    public int height() {
        return (root == null) ? 0 : root.height();
    }

    public BTNode<T> find(T obj) {
        return (root == null) ? null : root.find(obj);
    }

    public void add(T obj) {
        if (obj != null) {
            if (root == null) {
                root = new BTNode<T>(obj);
            } else {
                root.add(obj);
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void delete(T obj) {
        if (root != null) {
            boolean isRoot = root.getInfo().equals(obj);
            if (isRoot) {
                if (root.getLeft() == null) {
                    root = root.getRight();
                }
                if (root.getRight() == null) {
                    root = root.getLeft();
                } else {
                    BTNode<T> node = root.deleteRec(root, obj);
                    if (node == null && !isRoot) {
                        throw new RuntimeException("no existe el elemento {" + obj + "}");
                    }
                }
            }
        }
        throw new RuntimeException("no hay nodos");
    }

    @Override
    public String toString() {
        return (root == null) ? "{}" : root.toString();
    }

    public String toString(int n) {
        return (root == null) ? "(null)" : root.toString(n);
    }

    private BTNode<T> root;
}
