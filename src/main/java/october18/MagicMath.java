package october18;

/**
 * The class MagicMath contains method for performing some basic mathematical operations
 * @author Prodanov M.D.
 * @version 1.0
 */
public class MagicMath {

    /**
     * Calculates the factorial of a natural number
     * @param n the natural number
     * @return the factorial of the argument
     */
    public static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    /**
     * Calculates the absolute value of an integer number
     * @param n the integer value
     * @return the absolute value of the argument
     */
    public static int abs(int n) {
        if (n < 0)
            return -n;
        return n;
    }

    /**
     * Calculates the exponentiation for an integer base and a natural power
     * @param n the integer base
     * @param e the natural power
     * @return the value of {@code n} to the power of {@code e}
     */
    public static int pow(int n, int e) {
        int res = 1;
        for (int i = 0; i < e; i++) {
            res *= n;
        }

        return res;
    }
}
