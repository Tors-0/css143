import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Keeps track of a group of {@link FractionContainer}s to minimize effort
 * in counting fractions from files.
 * <br><br>
 * Uses {@link List}-like syntax for ease of use and uses {@link java.util.stream.Stream} to optimize
 * common algorithms.
 */
public class FractionTracker {

    // Use an ArrayList<FractionContainer> to keep track of everything
    private List<FractionContainer> counts;

    // keep track of this so simplify finding the total count later
    private int totalCount = 0;


    public FractionTracker() {
        counts = new ArrayList<>();
    }

    public void clear() {
        counts.clear();
        totalCount = 0;
    }

    public boolean contains(Fraction fraction) {
        return counts.stream().anyMatch(con -> con.matches(fraction));
    }

    public void increment(Fraction fraction) {
        for (FractionContainer con : counts) {
            if (con.matches(fraction)) {
                con.add();
                return;
            }
        }
    }

    public void add(Fraction fraction) {
        if (this.contains(fraction)) {
            increment(fraction);
        } else {
            counts.add(new FractionContainer(fraction));
        }
        totalCount++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (FractionContainer con : counts) {
            builder.append(con.toString()).append("\n");
        }
        builder.append("Total Count = ").append(totalCount);

        return builder.toString();
    }

    public void sortByFraction(boolean ascending) {
        if (ascending)
            counts.sort(null);
        else
            counts.sort(Collections.reverseOrder(null));
    }

    public void sortByCount(boolean ascending) {
        if (ascending)
            counts.sort(FractionContainer::compareAscendingByCount);
        else
            counts.sort(Collections.reverseOrder(
                    FractionContainer::compareAscendingByCount)
            );
    }
}
