package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    public T max() {
        return max(comp);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int maxIndex = getNextFirst()+1;
        for (int i=getNextFirst()+1; i<getNextFirst()+1+size(); i++) {
            if (comp.compare(get(i), get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }

        return get(maxIndex);
    }

    public static void main(String[] args) {

    }
}
