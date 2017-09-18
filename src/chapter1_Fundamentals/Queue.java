package chapter1_Fundamentals;

import java.util.Iterator;
/**
 * the implement of queue with linked list
 * @author Bingoo
 *
 * @param <T>
 */
public class Queue<T> implements Iterable<T>{
    private Node first;//point to the head of queue
    private Node last;//point to the tail of queue
    private int N;//the size of queue
    //the node in the linked list
    private class Node{
        T t;//the value of current node
        Node next;//point to the next node
    }
    /**
     * return the size of queue
     */
    public int size() {
        return N;
    }
    /**
     * judge if the queue is empty
     */
    public boolean isEmpty() {
        return first == null;//or return N==0;
    }
    /**
     * insert into queue from tail
     */
    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.t = t;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }
    /**
     * delete from the head of queue
     */
    public T dequeue() {
        T t = first.t;
        first = first.next;
        if(isEmpty())
            last = null;
        N--;
        return t;
    }
    @Override
    public Iterator<T> 
    iterator() {
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<T>{
        private Node point = first;
       // private int i = N;optional
        @Override
        public boolean hasNext() {
            return first !=  null;
        }

        @Override
        public T next() {
            T t = point.t;
            point = point.next;
           // i--;optional
            return t;
        }
        
    }

}
