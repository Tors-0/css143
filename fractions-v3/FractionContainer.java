/**
 * Holds a fraction and its count to avoid having to store every instance of a
 * fraction found in the input file. This is done to improve memory efficiency.
 * <br><br>
 * Implements {@link Comparable} to allow it to compare itself to any other
 * {@link FractionContainer} for easy sorting.
 */
public class FractionContainer implements Comparable<FractionContainer>{

    private final Fraction fraction;

    // The count of fractions we are holding/containing
    private int count;

    public FractionContainer(Fraction fraction) {
        this.fraction = new Fraction(fraction);
        this.count = 1;
    }

    public void add() {
        this.count++;
    }

    // This method is a gift from Mr. Stride to the student.
    // It is a static method that implements Comparator<> that can be used
    // to help FractionTracker sort in ascending order by the count.
    // Example usage: arr.sort(FractionContainer::compareAscendingByCount);
    public static int compareAscendingByCount(FractionContainer fc1, FractionContainer fc2) {
        // if our count is equal, then use the fraction value
        if (fc1.count == fc2.count) {
            return fc1.compareTo(fc2);
        }

        // just use the count
        return fc1.count - fc2.count;
    }

    @Override
    public int compareTo(FractionContainer o) {
        return this.fraction.compareTo(o.fraction);
    }

    public boolean matches(Fraction frac) {
        return frac.equals(this.fraction);
    }

    @Override
    public String toString() {
        return this.fraction.toString() + " has a count of " + count;
    }
}