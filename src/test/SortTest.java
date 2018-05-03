package test;

import java.util.Iterator;

import org.junit.Test;

import chapter1_Fundamentals.Bag;
import chapter1_Fundamentals.LinkStack;
import chapter1_Fundamentals.Queue;
import chapter1_Fundamentals.ResizingArrayStack;
import chapter2_sorting.Quick;

public class SortTest {
    public static void main(String[] args) {
        /*ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("hello");
        stack.push("world");
        for(String s : stack)
            System.out.println(s);
        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());*/
        /*LinkStack<String> stack2 = new LinkStack<>();
        stack2.push("hello java");
        stack2.push("hello world");
        for(String s : stack2)
            System.out.println(s);*/
        /*Queue<String> queue = new Queue<>();
        queue.enqueue("hello");
        queue.enqueue("java");
        queue.enqueue("nice");
        queue.enqueue("to");
        System.out.println(queue.dequeue());
        for(String s : queue)
            System.out.println(s);*/
        Bag<String> bag = new Bag<>();
        bag.add("hello");
        bag.add("world");
        for(String s : bag)
            System.out.println(s);
    }
    
    @Test
    public void quickTest() {
        Comparable[] array = new Comparable[] {3,4,2,6,2,3,1,4,5,9,7,20,19,23,15,12,11,13};
        Quick.sort(array);
        for(Comparable e : array)
            System.out.print(e + " ");
    }
}
