package chapter1_Fundamentals;

import java.util.Iterator;
/**
 * the linklist implement of stack
 * @author Administrator
 *
 * @param <T>
 */
public class LinkStack<T> implements Iterable<T>{
    //the first node the linklist
    private Node first;
    //record the size of stack
    private int n;
    private class Node{
        T t;
        Node next;
    }
    /**
     * return the size of the stack
     */
    public int size() {
        return n;
    }
    /**
     * is the stack empty
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * push element into the stack
     */
    public void push(T t) {
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
        n++;
    }
    public T pop() {
        Node node = first;
        first = first.next;
        n--;
        return node.t;
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkStackIterator();
    }
    private class LinkStackIterator implements Iterator<T> {
        private int i = n;
        private Node node = first;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            T t = node.t;
            node = node.next;
            i--;
            return t;
        }
        
    }
}
