package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        char[] str = new char[2 * n];
        List<String> accumulator = new ArrayList<>();
        solution.generateParenthesis(str, 0, accumulator);
        System.out.println(accumulator);
    }

    static class Solution {
        public void generateParenthesis(char[] str, int pos, List<String> accumulator) {
            if (pos == str.length) {
                if (isValid(str)) {
                    accumulator.add(new String(str));
                }
            } else {
                str[pos] = '(';
                generateParenthesis(str, pos + 1, accumulator);
                str[pos] = ')';
                generateParenthesis(str, pos + 1, accumulator);
            }
        }

        private boolean isValid(char[] str) {
            int balance = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '(') {
                    balance++;
                } else {
                    balance--;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }
}
