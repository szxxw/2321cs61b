package deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    int size();

    void printDeque();
    default boolean isEmpty() {
        return size() == 0;
    }
    T removeFirst();
    T removeLast();
    T get(int index);
    boolean equals(Object o);

}
