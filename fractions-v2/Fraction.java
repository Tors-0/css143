/**
 * A fraction that can hold its numerator and denominator as integer values
 * @author Rae Johnston
 * @version 2025.04.10
 */
public class Fraction {
    /**
     * the numerator of the fraction.
     * subject to change if fraction is reduced
     */
    private int num;
    /**
     * the denominator of the fraction.
     * subject to change if fraction is reduced
     */
    private int den;

    /**
     * Creates a fraction from two integers. does not reduce them automatically
     * @param numerator part of the fraction on top of the line
     * @param denominator part of the fraciton below the line
     */
    public Fraction(int numerator, int denominator) {
        num = numerator;
        den = denominator;
    }

    /**
     * Creates a fraction from an array of two Strings.
     * The first string in the array (index 0) is the numerator, and the
     * second string in the array (index 1_ is the denominator.
     * <br>
     * Precondition: {@code unparsed} must have a length of at least 2
     * @param unparsed The two {@link String}s to be made into a
     *                 {@link Fraction}.
     */
    public Fraction(String[] unparsed) {
        this(unparsed[0], unparsed[1]);
    }

    /**
     *
     * @param unsplit One {@link String} following the regex {@code (\d+\/\d+)}
     */
    public Fraction(String unsplit) {
        this(unsplit.split("/"));
    }
    public Fraction(Fraction other) {
        this.den = other.den;
        this.num = other.num;
    }

    public Fraction(String num, String den) {
        this(Integer.parseInt(num), Integer.parseInt(den));
    }

    public void reduce() {
        int limit = Math.min(num, den);
        for (int i = limit; i > 1; i--) {
            if (num % i == 0 && den % i == 0) {
                num /= i;
                den /= i;
                break;
            }
        }
        if (den < 0) {
            num *= -1;
            den *= -1;
        }
    }

    @Override
    public String toString() {
        this.reduce();
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Fraction other) {
            return this.num * other.den == this.den * other.num;
        } else {
            return false;
        }
    }


}