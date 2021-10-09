package cr.ac.una.ejercicios;

import java.util.ArrayList;

import cr.ac.una.collections.TNode;

public class Ejercicio3 implements Runnable {

    private static <T extends Comparable<T>> T LCA(TNode<T> A, TNode<T> B) {
        TNode<T> nodo;
        ArrayList<T> ancestorsA = new ArrayList<>();
        nodo = A;
        while (nodo != null) {
            ancestorsA.add(nodo.getData());
            nodo = nodo.getFather();
        }
        nodo = B;
        while (nodo != null) {
            for (T val : ancestorsA) {
                if (val.equals(nodo.getData())) {
                    return val;
                }
            }
            nodo = nodo.getFather();
        }
        return null;
    }

    private static TNode<Integer> createTree() {
        ArrayList<TNode<Integer>> nodos = new ArrayList<>();
        for (Integer i = 1; i < 17; i++) {
            nodos.add(new TNode<Integer>(i));
        }
        // hijos de 1
        nodos.get(1 - 1).add(nodos.get(2 - 1));
        nodos.get(1 - 1).add(nodos.get(3 - 1));
        // hijos de 2
        nodos.get(2 - 1).add(nodos.get(4 - 1));
        nodos.get(2 - 1).add(nodos.get(5 - 1));
        nodos.get(2 - 1).add(nodos.get(6 - 1));
        // hijos de 3
        nodos.get(3 - 1).add(nodos.get(7 - 1));
        // hijos de 7
        nodos.get(7 - 1).add(nodos.get(8 - 1));
        nodos.get(7 - 1).add(nodos.get(9 - 1));
        // hijos de 8
        nodos.get(8 - 1).add(nodos.get(10 - 1));
        nodos.get(8 - 1).add(nodos.get(11 - 1));
        nodos.get(8 - 1).add(nodos.get(12 - 1));
        nodos.get(8 - 1).add(nodos.get(13 - 1));
        // hijos de 9
        nodos.get(9 - 1).add(nodos.get(14 - 1));
        nodos.get(9 - 1).add(nodos.get(15 - 1));
        // hijos de 12
        nodos.get(12 - 1).add(nodos.get(16 - 1));

        return nodos.get(0);
    }

    @Override
    public void run() {
        TNode<Integer> root = createTree();
        for (int i = 1; i < 17; i++) {
            for (int j = 1; j < 17; j++) {
                if (j > i) {
                    Integer res = LCA(root.find(i), root.find(j));
                    System.out.println(String.format("LCA(%d, %d) = %d", i, j, res));
                }

            }
        }

    }

}
