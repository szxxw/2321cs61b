package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private  class IntNode {

        private T item;
        private IntNode next;
        private IntNode prev;
        IntNode(IntNode prev, T item, IntNode next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private IntNode sentienel;
    private int size;


    // create an empty linked list deque
    public LinkedListDeque() {
        sentienel = new IntNode(null, null, null);
        sentienel.prev = sentienel;
        sentienel.next = sentienel;
        size = 0;
    }

//    public LinkedListDeque(T x) {
//        this();
//        addFirst(x);
//        size = 1;
//    }
    // same as get, but uses recursion
//    public T getRecursive(int index) {
//
//    }
    @Override
    // Adds an item of type T to the front of the deque. You can assume that
    // item is never null.
    public void addFirst(T item) {
        IntNode  first = new IntNode(sentienel, item, sentienel.next);
        sentienel.next.prev = first; // current first node to the new first node
        sentienel.next = first; // Finally, the sentienel's next reference
        // is updated to point to the new node first.
        // This establishes the forward link from the sentienel
        // to the new first node and completes the insertion at the front of
        // the list.
        size += 1;
    }
    @Override
    // Adds an item of type T to the back of the deque. You can assume that item is never null.
    public void addLast(T item) {
        IntNode last = new IntNode(sentienel.prev, item, sentienel);

        sentienel.prev.next = last; // current last node to the new last node
        sentienel.prev = last;
        size += 1;
    }


    @Override
    // Returns the number of items in the deque.
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        IntNode p = sentienel.next;
        while (p != sentienel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }
    @Override
    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            IntNode p = sentienel.next;
            sentienel.next = p.next;
            sentienel.next.prev = p.prev;
            size--;
            return p.item;
        }
    }
    @Override
    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            IntNode p = sentienel.prev;
            sentienel.prev = p.prev;
            sentienel.prev.next = p.next;
            size--;
            return p.item;
        }
    }
    @Override
//    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            IntNode p = sentienel.next;
            if (index == 0) {
                return p.item;
            }
            while (index > 0) {
                index--;
                p = p.next;
            }
            return p.item;
        }

    }

    public T getRecursive(int index) {
        return helper(index, sentienel.next);
    }
    private T helper(int index, IntNode p) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return helper(index - 1, p.next);
    }



    public boolean equals(Object o) {
        if (o == this && (o instanceof LinkedListDeque)) {
            return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }
    private class LinkedListDequeIterator implements Iterator<T> {
        private int index;
        LinkedListDequeIterator() {
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

