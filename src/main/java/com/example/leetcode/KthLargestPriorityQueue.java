package com.example.leetcode;

import java.util.PriorityQueue;

class KthLargestPriorityQueue {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargestPriorityQueue(int k, int[] nums) {
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
        this.k = k;
    }

    public int add(int val) {
        if (queue.peek() == null || queue.size() < k) {
            queue.offer(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}