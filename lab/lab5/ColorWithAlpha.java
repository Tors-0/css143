public class ColorWithAlpha extends SimpleColor {
    int alpha;

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
        checkColorVal(alpha);
    }

    public ColorWithAlpha(int alpha) {
        super(0, 0, 0);
        setAlpha(alpha);
    }

    public ColorWithAlpha(int r, int g, int b, int alpha) {
        super(r, g, b);
        setAlpha(alpha);
    }

    public ColorWithAlpha(ColorWithAlpha other) {
        super(other);
        setAlpha(other.alpha);
    }

    @Override
    public String toString() {
        return super.toString() + " A: " + alpha;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ColorWithAlpha other) {
            return super.equals(other) && (this.alpha == other.alpha);
        }
        return false;
    }
}
