package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
    
    static class Solution {
        public boolean isHappy(int n) {
            if (n == 1) {
                return true;
            }
            Set<Long> usedNumbers = new HashSet<>();
            usedNumbers.add((long) n);
            long newNumber = n;
            do {
                char[] digits = String.valueOf(newNumber).toCharArray();
                newNumber = 0;
                for (char digit : digits) {
                    newNumber += Math.pow(Character.getNumericValue(digit), 2);
                }
                if (!usedNumbers.add(newNumber)) {
                    return false;
                }
            } while (newNumber != 1);
            return true;
        }
    }
}
