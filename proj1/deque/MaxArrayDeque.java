package deque;
import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;
    public MaxArrayDeque(Comparator<T> c) {
        this.c  = c;
    }
    public T max() {
        return max(c);
    }


    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = get(0);
        for (int i = 0; i < size(); i++) {
            T current = get(i);
            if (c.compare(current, maxItem) > 0) {
                maxItem = current;
            }

        }
        return maxItem;
    }


}
