package cr.ac.una.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;

import cr.ac.una.collections.Filter;
import cr.ac.una.collections.SDQueue;
import cr.ac.una.model.Producto;

public class Ejercicio1 implements Runnable {
    private static final String RUTA_CSV = "spec/datos (ejercicio 1).txt";

    @Override
    public void run() {
        SDQueue<Producto> productos = new SDQueue<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(RUTA_CSV))) {
            String fila;
            while ((fila = csvReader.readLine()) != null) {
                String[] columnas = fila.split("\t");
                String codigo = columnas[0];
                String nombre = columnas[1];
                String precio = columnas[2];
                Float costo = Float.parseFloat(precio);

                Producto p = new Producto(codigo, nombre, costo);
                productos.add(p);

            }
        } catch (Exception ex) {
            System.err.println("No se pudo cargar el archivo: " + ex.getLocalizedMessage());
        }

        // mostrar una lista con todos los productos cuyo código inicie con la letra
        // ‘B’, sin borrarninguno de la lista original.

        SDQueue<Producto> filtro1 = productos.select(new Filter<Producto>() {

            @Override
            public boolean isAcceptable(Producto obj) {
                return obj.getCodigo().startsWith("B");
            }

        });

        System.out.println("Filtro con letra B");
        for (Producto producto : filtro1) {
            System.out.println(producto);
        }

        // mostrar una lista con todos los productos que tengan un precio mayor a
        // 10.000, extrayéndolos (eliminándolos) de la lista original.

        SDQueue<Producto> filtro2 = productos.extract(new Filter<Producto>() {

            @Override
            public boolean isAcceptable(Producto obj) {
                return obj.getCosto() > 10000;
            }

        });
        System.out.println("Filtro de costo");
        for (Producto producto : filtro2) {
            System.out.println(producto);
        }

        System.out.println("lista original");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

    }
}
