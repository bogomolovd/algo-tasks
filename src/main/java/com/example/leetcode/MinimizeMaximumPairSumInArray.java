package com.example.leetcode;

import java.util.Arrays;
/**
 * Hello world!
 *
 */
public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPairSum(new int[] { 3, 5, 2, 3 })); // 7
        System.out.println(solution.minPairSum(new int[] { 3, 5, 4, 2, 4, 6 })); // 8
        System.out.println(solution.minPairSum(new int[] { 4, 1, 5, 1, 2, 5, 1, 5, 5, 4 })); // 8
    }

    static class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int max = -1;
            for (int i = 0; i < nums.length / 2; i++) {
                int sum = nums[i] + nums[nums.length - i - 1];
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }
    }
}
