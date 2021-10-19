package october18;

public class MagicMath {

    public static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    public static int abs(int n) {
        if (n < 0)
            return -n;
        return n;
    }

    public static int pow(int n, int e) {
        int res = 1;
        for (int i = 0; i < e; i++) {
            res *= n;
        }

        return res;
    }
}
