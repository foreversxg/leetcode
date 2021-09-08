package com.sxg.jdk;

import java.util.PriorityQueue;

/**
 * @author sxg
 * create in 2021/9/7
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(6);
        queue.add(8);
        queue.add(2);
        queue.add(4);
        Integer e = queue.poll();
        System.out.println(e);
    }
}
