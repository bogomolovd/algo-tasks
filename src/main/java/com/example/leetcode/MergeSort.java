package com.example.leetcode;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res[] = solution.sortArray(new int[] {5,1,1,2,0,0});
        System.out.println(res);
    }

    static class Solution {
        public int[] sortArray(int[] nums) {
            if (nums.length < 2) {
                return nums;
            } else if (nums.length == 2) {
                if (nums[0] <= nums[1]) {
                    return nums;
                } else {
                    return new int[] { nums[1], nums[0] };
                }
            } else {
                int mid = nums.length / 2;
                int[] firstArray = sortArray(Arrays.copyOfRange(nums, 0, mid));
                int[] secondArray = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
                int[] result = new int[firstArray.length + secondArray.length];
                for (int i = 0, j = 0, k = 0; i < result.length; i++) {
                    if (j >= firstArray.length) {
                        result[i] = secondArray[k++];
                    } else if (k >= secondArray.length) {
                        result[i] = firstArray[j++];
                    } else if (firstArray[j] < secondArray[k]) {
                        result[i] = firstArray[j++];
                    } else {
                        result[i] = secondArray[k++];
                    }
                }
                return result;
            }
        }
    }
}
