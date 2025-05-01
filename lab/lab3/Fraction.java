public class Fraction {
    public final int numerator;
    public final int denominator;

    public Fraction(int num, int den) {
        int numerator1 = num;
        int denominator1;

        if (den != 0) {
            denominator1 = den;
        } else {
            denominator1 = 1;
        }

        int limit = Math.min(numerator1, denominator1);
        for (int i = limit; i > 1; i--) {
            if (numerator1 % i == 0 && denominator1 % i == 0) {
                numerator1 /= i;
                denominator1 /= i;
                break;
            }
        }
        if (denominator1 < 0) {
            numerator1 *= -1;
            denominator1 *= -1;
        }

        this.numerator = numerator1;
        this.denominator = denominator1;
    }

    public Fraction(Fraction other) {
        this(other.numerator, other.denominator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Fraction other) {
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }

    public Fraction add(Fraction that) {
        int tempNum = this.numerator * that.denominator + that.numerator * this.denominator;
        int tempDen = this.denominator * that.denominator;
        return new Fraction(tempNum, tempDen);
    }
}
