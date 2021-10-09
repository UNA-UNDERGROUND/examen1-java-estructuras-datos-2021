package cr.ac.una.collections;

public class SDQueue<T> extends DQueue<T> {
    // Este método obtiene de la cola todos los elementos para los cuale
    // la función isAcceptable() del fitro especificado es verdadera
    // (regresa un valor true).
    // La función regresa los elementos que cumplen con el criterio indicado
    // SIN ALTERAR la lista original. Es decir, los elementos se agregan
    // al resultado sin eliminarlos.
    // public SDQueue<T> select(Filter<T> f){throw new
    // UnsupportedOperationException();}
    // Este método extrae de la cola todos los elementos para los cuales
    // la función isAcceptable() del fitro especificado es verdadera
    // (regresa un valor true).
    // La función ELIMINA de la lista original los elementosque cumplen
    // con el criterio indicado.
    //
    public SDQueue<T> extract(Filter<T> f) {
        throw new UnsupportedOperationException();
    }
}
