package cr.ac.una.collections;

@FunctionalInterface
public interface Filter<T> {
    public boolean isAcceptable(T obj);
}