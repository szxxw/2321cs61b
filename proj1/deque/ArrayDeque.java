package deque;

import java.util.Iterator;
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    // create an empty arraylist

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0; // arbitrarily start from 0 and 1
        nextLast = 1;

    }
    // the second way of resize
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            a[i] = items[current];
            current = (current + 1) % items.length;
        }
        items = a;
        nextLast = size;
        nextFirst = capacity - 1;

    }
    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = x;
        // 0 -1 = -1 + items.length x
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }
    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextLast] = x;
        size++;
        nextLast = (nextLast + 1) % items.length;

    }
    @Override
    public void printDeque() {
        int firstIndex = (nextFirst + 1) % items.length;
        while (firstIndex < size) {
            System.out.print(items[firstIndex] + " ");
            firstIndex++;
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }
    // Removes and returns the first item at the front of the deque.
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if (items.length >= 16 && size < items.length * 0.25) {
            resize(items.length / 2);
        }


        return item;

    }
    @Override// Removes and returns the last item at the front of the deque.
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        if (items.length >= 16 && size < items.length * 0.25) {
            resize(items.length / 2);
        }
        return item;
    }
    @Override
    //  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    //     If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }
        int realindex = (nextFirst + 1 + index) % items.length;
        return items[realindex];
    }
    @Override
    public boolean equals(Object o) {
        if (o == this && (o instanceof ArrayDeque)) {
            return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    private class ArrayDequeIterator implements Iterator<T> {
        private int index;
        ArrayDequeIterator() {
            index = 0;
        }
        public boolean hasNext() {
            return index < size;
        }
        public T next() {
            T item = get(index);
            index++;
            return item;
        }
    }
}
