package com.sxg.heap;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * @author sxg
 * create in 2021/9/12
 */
public class LeastNumbers {

    public static void main(String[] args) {
        int[] array = new LeastNumbers().getLeastNumbers(new int[]{1, 3, 2, 6, 4, 5}, 3);
        System.out.println(array);
    }

    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
