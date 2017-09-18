package chapter1_Fundamentals;

import java.util.Iterator;
/**
 * the implement of stack
 * @author Administrator
 *
 * @param <T>
 */
public class ResizingArrayStack<T> implements Iterable<T>{
    //maintain a generic array
    private T[] array = (T[])new Object[1];
    private int n;//record the size of the stack
    /**
     * return the size of stack
     * @return
     */
    public int size() {
        return n;
    }
    /**
     * is the stack empty
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * push into stack 
     * @param t
     */
    public void push(T t) {
        if(n == array.length)
            resize(2 * array.length);
        array[n++] = t;
    }
    public T pop() {
        T t = array[n--];
        if(n > 0 && n == array.length / 4)
            resize(array.length/2);
        return t;
    }
    public T peek() {
        T t = array[--n];
        n++;
        return t;
    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ReverseArrayIterator();
    }
    public void resize(int length) {
        //create a new array
        T[] temp = (T[])new Object[length];
        for(int i = 0; i < array.length; i++)
            temp[i] = array[i];
        array = temp;
    }
    private class ReverseArrayIterator implements Iterator<T> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return array[--i];
        }
          
    }
}
