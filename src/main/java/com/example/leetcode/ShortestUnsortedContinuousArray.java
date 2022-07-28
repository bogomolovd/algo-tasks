package com.example.leetcode;

public class ShortestUnsortedContinuousArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
        System.out.println(solution.findUnsortedSubarray(new int[] { 1, 2, 3, 4 }));
        System.out.println(solution.findUnsortedSubarray(new int[] { 1 }));
        System.out.println(solution.findUnsortedSubarray(new int[] { 2, 1 }));
    }

    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int minElem = Integer.MAX_VALUE;
            boolean wrongOrder = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    wrongOrder = true;
                }
                if (wrongOrder && minElem > nums[i]) {
                    minElem = nums[i];
                }
            }
            int minIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (minElem < nums[i]) {
                    minIndex = i;
                    break;
                }
            }
            if (minIndex == -1) {
                return 0;
            }
            int maxElem = Integer.MIN_VALUE;
            wrongOrder = false;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i > 0 && nums[i] < nums[i - 1]) {
                    wrongOrder = true;
                }
                if (wrongOrder && maxElem < nums[i]) {
                    maxElem = nums[i];
                }
            }
            int maxIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (maxElem > nums[i]) {
                    maxIndex = i;
                    break;
                }
            }
            return maxIndex - minIndex + 1;
        }
    }
}