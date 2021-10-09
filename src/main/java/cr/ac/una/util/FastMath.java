package cr.ac.una.util;

import java.util.ArrayList;

public class FastMath {

    // nos garantiza que corridas sucesivas cumplen un tiempo de O(1)
    // pero a un coste de memoria de O(n)
    // siendo el valor 0 = 1
    private static ArrayList<Long> factorial_cache = new ArrayList<>();

    // caso especial del exponente
    public static int minusOnePow(int exp) {
        if (exp == 0) {
            return 1;
        }
        return exp % 2 == 0 ? 1 : -1;
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("no se aceptan numeros negativos");
        }

        // si no existe el valor en cache
        if (factorial_cache.size() - 1 < n) {
            if (n == 0) {
                factorial_cache.add(1L);
                return 1;
            }
            Long prev = factorial(n - 1);
            Long res = prev * n;
            factorial_cache.add(res);
            return res;
        }
        // ya existe en el cache
        return factorial_cache.get(n);
    }

    private static double sqr(double x) {
        return x * x;
    }

    private static double mypow(double base, double power, double precision) {
        if (power < 0)
            return 1 / mypow(base, -power, precision);
        if (power >= 10)
            return sqr(mypow(base, power / 2, precision / 2));
        if (power >= 1)
            return base * mypow(base, power - 1, precision);
        if (precision >= 1)
            return Math.sqrt(base);
        return Math.sqrt(mypow(base, power * 2, precision * 2));
    }

    private static double mypow(double base, double power) {
        return mypow(base, power, .0000000001D);
    }

    public static double pow(double base, Integer power, ArrayList<Double> cache) {
        if (power < 0) {
            throw new ArithmeticException("no se aceptan exponentes negativos");
        }
        if (base == 0) {
            if (power == 0) {
                throw new ArithmeticException("no se puede 0^0");
            }
            return 0;
        }

        // si no existe el valor en cache
        if (cache.size() - 1 < power) {
            if (power == 0) {
                factorial_cache.add(1L);
                return 1;
            }
            Double prev = pow(base, power - 1, cache);
            Double res = prev * base;
            cache.add(res);
            return res;
        }
        // ya existe en el cache
        return cache.get(power);
    }

    public static double sin(double val, int i, int max, ArrayList<Double> powerCache) {
        if (i == 0) {
            return val + sin(val, i + 1, max, powerCache);
        }
        int a = 2 * i + 1;
        try {
            Double powRes;
            powRes = mypow(val, a);
            if (Double.isNaN(powRes)) {
                // funcion con menos precision
                // con una funcion mas precisa el error disminuye
                powRes = pow(val, a, powerCache);
            }
            // powRes = Math.pow(val, a);
            double calc = (minusOnePow(i) * (powRes)) / factorial(a);
            if (i == max) {
                return calc;
            }
            return calc + sin(val, i + 1, max, powerCache);
        } catch (Exception e) {
            System.err.println("cache miss on: " + a);
            System.exit(-1);
            return -1;
        }
    }

    public static double sin(double val) {
        return sin(val, 0, 9, new ArrayList<>());
    }
}
