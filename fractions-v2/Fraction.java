public class Fraction {
    private int num;
    private int den;

    public Fraction(int numerator, int denominator) {
        num = numerator;
        den = denominator;
    }
    public Fraction(String[] unparsed) {
        this(unparsed[0], unparsed[1]);
    }
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
                return;
            }
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