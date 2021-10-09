package cr.ac.una.collections;

public class BTNode<T extends Comparable<T>> {

    public BTNode(T info, BTNode<T> left, BTNode<T> right) {
        this(null, info, left, right);
    }

    public BTNode(BTNode<T> father, T info, BTNode<T> left, BTNode<T> right) {
        this.info = info;
        this.left = left;
        this.right = right;
        this.father = father;
    }

    public BTNode(BTNode<T> father, T info) {
        this(null, info, null, null);
    }

    public BTNode(T info) {
        this(null, info);
    }

    public int size() {
        return 1 + ((left != null) ? left.size() : 0) + ((right != null) ? right.size() : 0);
    }

    public int height() {
        return 1 + Math.max(((left != null) ? left.height() : 0), ((right != null) ? right.height() : 0));
    }

    public int width() {
        int w = 3;
        if ((left == null) && (right == null)) {
            w = 1;
        } else if ((left == null) || (right == null)) {
            w = 2;
        }
        return w;
    }

    public BTNode<T> find(T obj) {
        if (obj != null) {
            int r = obj.compareTo(getInfo());
            if (r == 0) {
                return this;
            } else if ((r < 0) && (left != null)) {
                return left.find(obj);
            } else if ((r > 0) && (right != null)) {
                return right.find(obj);
            } else {
                return null;
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void add(T obj) {
        if (obj.compareTo(getInfo()) <= 0) {
            if (left == null) {
                left = new BTNode<T>(this, obj);
            } else {
                left.add(obj);
            }
        } else {
            if (right == null) {
                right = new BTNode<T>(this, obj);
            } else {
                right.add(obj);
            }
        }
    }

    public BTNode<T> deleteRec(BTNode<T> root, T value) {
        if (root == null) {
            return root;
        }
        if (value.compareTo(root.info) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.info) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.info = minValue(root.right);
            root.right = deleteRec(root.right, root.info);
        }

        return root;
    }

    T minValue(BTNode<T> root) {
        T minv = root.info;
        while (root.left != null) {
            minv = root.left.info;
            root = root.left;
        }
        return minv;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public T getInfo() {
        return info;
    }

    public void setFather(BTNode<T> node) {
        father = node;
    }

    public void setLeft(BTNode<T> node) {
        left = node;
    }

    public void setRight(BTNode<T> node) {
        right = node;
    }

    public BTNode<T> getFather() {
        return father;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    @Override
    public String toString() {
        boolean hasChildren = (getLeft() != null) || (getRight() != null);
        StringBuilder r = new StringBuilder(hasChildren ? "{" : "");
        r.append(getInfo());
        if (hasChildren) {
            r.append("; [");
            r.append(String.format("%s, ", (left != null) ? left : "_"));
            r.append(String.format("%s", (right != null) ? right : "_"));
            r.append("]");
        }
        r.append(hasChildren ? "}" : "");
        return r.toString();
    }

    public String toString(int indent) {
        return toString(indent, 0);
    }

    private String toString(int indent, int level) {
        StringBuilder r = new StringBuilder();
        if (left != null) {
            r.append(left.toString(indent, level + 1));
        }
        r.append(String.format("%s%s%n", " ".repeat(indent).repeat(level), getInfo()));
        if (right != null) {
            r.append(right.toString(indent, level + 1));
        }
        return r.toString();
    }

    private T info;
    private BTNode<T> left;
    private BTNode<T> right;
    private BTNode<T> father;
}
