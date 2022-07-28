package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MyPow {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(-1.0, -2147483648));
    }

    static class Solution {
        Map<Integer, Double> results = new HashMap<>();
        
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            } else if (n == 2) {
                return x * x;
            } else if (n == -1) {
                return 1 / x;
            } else if (n == -2) {
                return 1 / x * 1 / x;
            }
            double result = myPowCached(x, n / 2) * myPowCached(x, (n > 0 ? 1 : -1) + n / 2);
            return Double.isNaN(result) ? 0 : result;
        }
        
        private double myPowCached(double x, int n) {
            Double result = results.get(n);
            if (result == null) {
                result = myPow(x, n);
                results.put(n, result);
            }
            return result;
        }
    }
}
