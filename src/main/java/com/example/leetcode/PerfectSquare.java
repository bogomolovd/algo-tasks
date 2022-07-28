package com.example.leetcode;

public class PerfectSquare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
    }
    
    static class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 0;
            int right = num;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long elem = (long) mid * (long) mid;
                if (num == elem) {
                    return true;
                } else if (num < elem) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
}
