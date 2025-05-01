public class CustomMath {
    public static final double PI = Math.PI;
    public static final double E = Math.E;

    // q1 because they are immutable they can't be changed even thought they are externally accessible
    // q2 you can call them with the dot operator on the classname

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }

    public int pow(int base, int exp) {
        int out = 1;
        for (int i = 0; i < exp; i++) {
            out *= base;
        }
        return out;
    }
}
