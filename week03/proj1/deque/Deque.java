package deque;

import java.util.Iterator;

public interface Deque<T> extends Iterable<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public boolean equals(Object o);

    public Iterator<T> iterator();

    public static void main(String[] args) {

    }
}
