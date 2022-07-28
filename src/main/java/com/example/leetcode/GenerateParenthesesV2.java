package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesV2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        StringBuilder str = new StringBuilder();
        List<String> acc = new ArrayList<>();
        solution.generateParenthesis(str, acc, 0, 0, n);
        System.out.println(acc);
    }

    static class Solution {
        public void generateParenthesis(StringBuilder str, List<String> acc, int open, int close, int n) {
            if (str.length() == n * 2) {
                acc.add(new String(str));
                return;
            }
            
            if (open < n) {
                str.append("(");
                generateParenthesis(str, acc, open + 1, close, n);
                str.deleteCharAt(str.length() - 1);
            }

            if (close < open) {
                str.append(")");
                generateParenthesis(str, acc, open, close + 1, n);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
