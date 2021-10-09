package cr.ac.una;

import cr.ac.una.ejercicios.Ejercicio1;
import cr.ac.una.ejercicios.Ejercicio2;
import cr.ac.una.ejercicios.Ejercicio3;

public class App {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1:");
        new Ejercicio1().run();
        System.out.println("Ejercicio 2:");
        new Ejercicio2().run();
        System.out.println("Ejercicio 3:");
        new Ejercicio3().run();
    }
}
