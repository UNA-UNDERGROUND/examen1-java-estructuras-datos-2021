package cr.ac.una.ejercicios;

import java.util.ArrayList;

import cr.ac.una.collections.TNode;

public class Ejercicio5 implements Runnable {

    private static <T extends Comparable<T>> int getHeight(TNode<T> node) {
        Integer height = -1;
        TNode<T> actual = node;
        while (actual != null) {
            height++;
            actual = actual.getFather();
        }
        return height;
    }

    private static <T extends Comparable<T>> Boolean isCousin(TNode<T> A, TNode<T> B) {
        return A.getFather() != null && B.getFather() != null && (!A.getFather().equals(B.getFather()))
                && (getHeight(A) == getHeight(B));
    }

    private static TNode<Integer> createTree1() {
        ArrayList<TNode<Integer>> nodos = new ArrayList<>();
        for (Integer i = 1; i < 13; i++) {
            nodos.add(new TNode<Integer>(i));
        }

        // hijos de 2
        nodos.get(2 - 1).add(nodos.get(1 - 1));
        nodos.get(2 - 1).add(nodos.get(3 - 1));
        // hijos de 4
        nodos.get(4 - 1).add(nodos.get(2 - 1));
        nodos.get(4 - 1).add(nodos.get(5 - 1));
        // hijos de 5
        nodos.get(5 - 1).add(nodos.get(7 - 1));
        // hijos de 6
        nodos.get(6 - 1).add(nodos.get(4 - 1));
        nodos.get(6 - 1).add(nodos.get(8 - 1));
        // hijos de 8
        nodos.get(8 - 1).add(nodos.get(9 - 1));
        // hijos de 9
        nodos.get(9 - 1).add(nodos.get(9 - 1));
        nodos.get(9 - 1).add(nodos.get(10 - 1));
        // hijos de 10
        nodos.get(10 - 1).add(nodos.get(11 - 1));
        // hijos de 11
        nodos.get(11 - 1).add(nodos.get(12 - 1));

        return nodos.get(6 - 1);
    }

    private static TNode<Integer> createTree2() {
        ArrayList<TNode<Integer>> nodos = new ArrayList<>();
        for (Integer i = 1; i < 15; i++) {
            nodos.add(new TNode<Integer>(i));
        }

        // hijos de 1
        nodos.get(1 - 1).add(nodos.get(2 - 1));
        nodos.get(1 - 1).add(nodos.get(3 - 1));
        // hijos de 2
        nodos.get(2 - 1).add(nodos.get(4 - 1));
        nodos.get(2 - 1).add(nodos.get(5 - 1));
        // hijos de 3
        nodos.get(3 - 1).add(nodos.get(6 - 1));
        nodos.get(3 - 1).add(nodos.get(9 - 1));
        // hijos de 6
        nodos.get(6 - 1).add(nodos.get(7 - 1));
        nodos.get(6 - 1).add(nodos.get(8 - 1));
        // hijos de 7
        nodos.get(7 - 1).add(nodos.get(10 - 1));
        nodos.get(7 - 1).add(nodos.get(11 - 1));
        // hijos de 8
        nodos.get(8 - 1).add(nodos.get(12 - 1));
        nodos.get(8 - 1).add(nodos.get(13 - 1));
        // hijos de 12
        nodos.get(12 - 1).add(nodos.get(14 - 1));

        return nodos.get(1 - 1);
    }

    public void analizarArbol(TNode<Integer> root, int limit) {
        int nCousin = 0;
        int nNoCousin = 0;
        StringBuilder builderCousin = new StringBuilder();
        StringBuilder builderNoCousin = new StringBuilder();

        for (int i = 1; i < limit; i++) {
            for (int j = 1; j < limit; j++) {
                if (j > i) {
                    // no usé BTNode, porque hace una busqueda binaria
                    // y el primer arbol de ejemplo en el enunciado no esta ordenado
                    // por lo tanto se necesita una busqueda completa
                    if (isCousin(root.find(i), root.find(j))) {
                        if (nCousin != 0) {
                            builderCousin.append(", ");
                        }
                        nCousin++;
                        builderCousin.append(String.format("(%d, %d)", i, j));
                        if (nCousin == 10) {
                            builderCousin.append("\n");
                            nNoCousin = 0;
                        }
                    } else {
                        if (nNoCousin != 0) {
                            builderNoCousin.append(", ");
                        }
                        nNoCousin++;
                        builderNoCousin.append(String.format("(%d, %d)", i, j));
                        if (nNoCousin == 10) {
                            builderNoCousin.append("\n");
                            nNoCousin = 0;
                        }
                    }
                }
            }
        }
        String cousins = builderCousin.toString();
        String noCousins = builderNoCousin.toString();
        if (cousins.isEmpty()) {
            System.out.println("no hay nodos primos.");
        } else {
            System.out.print(cousins);
            System.out.println(" son primos entre sí.");
        }
        if (noCousins.isEmpty()) {
            System.out.println("no hay nodos no primos.");
        } else {
            System.out.print(noCousins);
            System.out.println(" no son primos entre sí.");
        }
    }

    @Override
    public void run() {
        // longitud 13
        TNode<Integer> rootA = createTree1();
        // longitud 15
        TNode<Integer> rootB = createTree2();

        System.out.println("Analizando arbol A");
        analizarArbol(rootA, 13);
        System.out.println("Analizando arbol B");
        analizarArbol(rootB, 15);
    }

}
