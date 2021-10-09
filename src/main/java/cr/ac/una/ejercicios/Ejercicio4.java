package cr.ac.una.ejercicios;

import java.util.ArrayList;

import cr.ac.una.collections.BTNode;

public class Ejercicio4 implements Runnable {
    // necesario para modificar los valores como referencia
    private class Height {
        int value = 0;
    }

    private <T extends Comparable<T>> boolean isBalanced(BTNode<T> root, Height height) {
        if (root == null) {
            height.value = 0;
            return true;
        }

        Height leftHeight = new Height();
        Height rightHeight = new Height();
        boolean leftBalanced = isBalanced(root.getLeft(), leftHeight);
        boolean rigthBalanced = isBalanced(root.getRight(), rightHeight);

        height.value = (leftHeight.value > rightHeight.value ? leftHeight.value : rightHeight.value) + 1;

        if ((leftHeight.value - rightHeight.value >= 2) || (rightHeight.value - leftHeight.value >= 2)) {
            return false;
        } else {
            return leftBalanced && rigthBalanced;
        }
    }

    private BTNode<Integer> generateBalancedTree() {
        ArrayList<BTNode<Integer>> nodes = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            nodes.add(new BTNode<Integer>(i));
        }
        BTNode<Integer> root = nodes.get(0);
        root.setLeft(nodes.get(2 - 1));
        root.setRight(nodes.get(3 - 1));
        nodes.get(2 - 1).setLeft(nodes.get(4 - 1));
        nodes.get(2 - 1).setRight(nodes.get(5 - 1));

        return root;
    }

    private BTNode<Integer> generateUnBalancedTree() {
        ArrayList<BTNode<Integer>> nodes = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            nodes.add(new BTNode<Integer>(i));
        }
        BTNode<Integer> root = nodes.get(0);
        root.setLeft(nodes.get(2 - 1));
        root.setRight(nodes.get(3 - 1));
        nodes.get(2 - 1).setLeft(nodes.get(4 - 1));
        nodes.get(2 - 1).setRight(nodes.get(5 - 1));
        nodes.get(5 - 1).setLeft(nodes.get(6 - 1));

        return root;
    }

    @Override
    public void run() {
        Height height = new Height();
        BTNode<Integer> a = generateBalancedTree();
        BTNode<Integer> b = generateUnBalancedTree();

        if (isBalanced(a, height)) {
            System.out.println("El arbol 'a' se encuentra balanceado");
        } else {
            System.out.println("El arbol 'a' no se encuentra balanceado");
        }
        if (isBalanced(b, height)) {
            System.out.println("El arbol 'b' se encuentra balanceado");
        } else {
            System.out.println("El arbol 'b' no se encuentra balanceado");
        }
    }

}
