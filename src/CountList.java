import java.util.ArrayList;
import java.util.Collection;

public class CountList<T> extends ArrayList<T> {
    public int countEqualTo(T ref) {
        int count = 0;
        for (T e : this) {
            if (ref.equals(e)) count++;
        }
        return count;
    }

    public CountList() {
        super();
    }
    public CountList(int initialCapacity) {
        super(initialCapacity);
    }
    public CountList(Collection<? extends T> collection) {
        super(collection);
    }
}
