package com.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class KthLargest {
    private List<Integer> list;
    int kThLargest;
    int k;
    
    public KthLargest(int k, int[] nums) {
        list = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        kThLargest = list.get(list.size() - k);
        this.k = k;
    }
    
    public int add(int val) {
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int elem = iterator.previous();
            if (val >= elem) {
                iterator.next();
                iterator.add(val);
                break;
            }
        }
        if (val > kThLargest) {
            kThLargest = list.get(list.size() - k);
        }
        return kThLargest;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}