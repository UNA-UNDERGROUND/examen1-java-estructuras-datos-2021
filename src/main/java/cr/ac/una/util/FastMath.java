package cr.ac.una.util;

import java.util.ArrayList;

public class FastMath {

    // nos garantiza que corridas sucesivas cumplen un tiempo de O(1)
    // pero a un coste de memoria de O(n)
    // siendo el valor 0 = 1
    private static ArrayList<Integer> factorial_cache = new ArrayList<>();

    // caso especial del exponente
    public static int minusOnePow(int exp) {
        if (exp == 0) {
            return 1;
        }
        return exp % 2 == 0 ? 1 : -1;
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("no se aceptan numeros negativos");
        }
        // si no existe el valor en cache
        if (factorial_cache.size() < n) {
            if (n == 0) {
                factorial_cache.add(1);
                return 1;
            }
            int res = factorial(n - 1) * n;
            factorial_cache.add(res);
            return res;
        }
        // ya existe en el cache
        return factorial_cache.get(n);
    }

    // https://martin.ankerl.com/2007/10/04/optimized-pow-approximation-for-java-and-c-c/
    public static double pow(final double a, final double b) {
        final int tmp = (int) (Double.doubleToLongBits(a) >> 32);
        final int tmp2 = (int) (b * (tmp - 1072632447) + 1072632447);
        return Double.longBitsToDouble(((long) tmp2) << 32);
    }

    public static double sin(double val) {
        return 0;
    }
}
