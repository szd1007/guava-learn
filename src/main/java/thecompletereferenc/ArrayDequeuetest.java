package thecompletereferenc;

import java.util.ArrayDeque;

public class ArrayDequeuetest {

/*
This class is likely to be faster than
 * {@link Stack} when used as a stack, and faster than {@link LinkedList}
 * when used as a queue.
 * stack 的替代品
 */
    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(1);
        ad.push(2);
        ad.pop();

        System.out.println(ad);
    }
}
