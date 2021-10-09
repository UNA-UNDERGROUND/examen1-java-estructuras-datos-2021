package cr.ac.una.collections;

import java.util.ArrayList;
import java.util.List;

public class TNode<T extends Comparable<T>> {

    public TNode() {
        this(null);
    }

    public TNode(T data) {
        this(data, null);
    }

    public TNode(T data, TNode<T> father) {
        this(data, father, new ArrayList<>());
    }

    public TNode(T data, TNode<T> father, List<TNode<T>> childs) {
        this.data = data;
        this.father = father;
        this.childs = childs;
    }

    public TNode<T> find(T val) {
        if (data.equals(val)) {
            return this;
        }
        for (TNode<T> child : childs) {
            TNode<T> res = child.find(val);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TNode<T> getFather() {
        return father;
    }

    public void setFather(TNode<T> father) {
        this.father = father;
    }

    public boolean add(TNode<T> node) {
        if (find(node.getData()) == null) {
            node.setFather(this);
            return childs.add(node);
        }
        return false;
    }

    public boolean add(T data) {
        return add(new TNode<>(data));
    }

    public TNode<T> removeChild(T val) {
        for (TNode<T> child : childs) {
            if (child.getData().equals(val)) {
                TNode<T> res = child;
                res.setFather(null);
                childs.remove(child);
                return res;
            }
        }
        return null;
    }

    private T data;
    private TNode<T> father;
    private List<TNode<T>> childs;
}
