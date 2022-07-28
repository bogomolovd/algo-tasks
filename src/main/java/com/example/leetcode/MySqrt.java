package com.example.leetcode;

public class MySqrt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    static class Solution {
        public int mySqrt(int x) {
            int left = 0;
            int right = 65536;
            int lastRes = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long sqr = (long) mid * (long) mid; 
                if (sqr == x) {
                    return mid;
                } else if (sqr > x) {
                    right = mid - 1;
                } else {
                    lastRes = mid;
                    left = mid + 1;
                }
            }
            return lastRes;
        }
    }
}
