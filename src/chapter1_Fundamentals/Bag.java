package chapter1_Fundamentals;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private Node first;//point to the first elements in bag
    private int N;//the size of bag
    private class Node {
        T t;
        Node next;
    }
    /**
     * We can only add node to the bag
     */
    public void add(T t) {
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
        N++;
    }
    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }
    /**
     * The iterator of Bag
     * @author Bingoo
     *
     */
    private class BagIterator implements Iterator<T> {
        private Node current = first;
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            i--;
            return t;
        }
        
    }
}
