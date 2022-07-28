package com.example.leetcode;

public class MinSubArrayLength {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum == target) {
                return nums.length;
            } else if (sum < target) {
                return 0;
            }
            int i = 0;
            int j = nums.length - 1;
            int currSum = sum;
            int n = nums.length;
            while (i < j) {
                int sumLeft = currSum - nums[j];
                int sumRight = currSum - nums[i];
                if (sumLeft > sumRight) {
                    currSum = sumLeft;
                    j--;
                } else {
                    currSum = sumRight;
                    i++;
                }
                if (target > currSum) {
                    return n;
                }
                n--;
            }  
            return n;
        }
    }
}
