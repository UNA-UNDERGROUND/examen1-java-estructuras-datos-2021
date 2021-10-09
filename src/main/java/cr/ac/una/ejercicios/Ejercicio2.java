package cr.ac.una.ejercicios;

import cr.ac.una.util.FastMath;

public class Ejercicio2 implements Runnable {

    @Override
    public void run() {
        double x0 = -2.2;
        while (x0 <= +2.0) {
            double y0 = Math.sin(x0);
            double y1 = FastMath.sin(x0);
            // función de cálculo (recursiva)
            System.out.printf("f(%1$ 11.9f) = %2$ 11.9f, %3$ 11.9f " + "; error = %4$ 6.4g%n", x0, y0, y1,
                    Math.abs((y1 - y0) / y1));
            x0 += 0.15;
        }
    }

}
