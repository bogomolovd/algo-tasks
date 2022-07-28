package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class ArrayIntersection {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums2) {
                set2.add(num);
            }
            set1.retainAll(set2);
            return set1.stream().mapToInt(i -> (int) i).toArray();
        }
    }
}
