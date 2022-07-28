package com.example.leetcode;

public class Search2DMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                new int[] { 1, 4, 7, 11, 15 },
                new int[] { 2, 5, 8, 12, 19 },
                new int[] { 3, 6, 9, 16, 22 },
                new int[] { 10, 13, 14, 17, 24 },
                new int[] { 18, 21, 23, 26, 30 }
        };
        System.out.println(solution.searchMatrix(matrix, 5));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int maxCol = binSearchLessThanOrEqual(matrix[0], target);
            if (target == matrix[0][maxCol]) {
                return true;
            }
            for (int i = 0; i < matrix.length; i++) {
                if (binSearch(matrix[i], maxCol, target)) {
                    return true;
                }
            }
            return false;
        }

        public int binSearchLessThanOrEqual(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int mid = (left + right) / 2 + 1;
                if (mid == target) {
                    return mid;
                } else if (mid < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public boolean binSearch(int[] arr, int maxCol, int target) {
            int left = 0;
            int right = maxCol;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (mid == target) {
                    return true;
                } else if (mid < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
