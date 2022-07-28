package com.example.leetcode;

import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
    }

    static class Solution {

        public double[] medianSlidingWindow(int[] nums, int k) {
            Comparator<Integer> comparator = (a, b) -> nums[a] == nums[b] ? Integer.compare(b, a)
                    : Integer.compare(nums[b], nums[a]);
            TreeSet<Integer> left = new TreeSet<>(comparator);
            TreeSet<Integer> right = new TreeSet<>();
            double[] result = new double[nums.length - k + 1];

            for (int i = 0; i < nums.length; i++) {
                if (left.size() <= right.size()) {
                    right.add(i);
                    left.add(right.pollFirst());
                } else {
                    left.add(i);
                    right.add(left.pollFirst());
                }

                if (left.size() + right.size() == k) {
                    double median;
                    if (left.size() == right.size()) {
                        median = ((double) nums[left.first()] + (double) nums[right.first()]) / 2;
                    } else {
                        median = nums[left.first()];
                    }

                    int resultIndex = i - k + 1;
                    result[resultIndex] = median;
                    if (!left.remove(resultIndex)) {
                        right.remove(resultIndex);
                    }
                }
            }
            return result;
        }
    }
}
