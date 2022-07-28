package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
    
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> used = new HashMap<>();
            int maxLen = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (used.containsKey(ch)) {
                    start = used.get(ch) + 1;
                }
                used.put(ch, i);
                maxLen = Math.max(maxLen, i - start + 1);
            }
            return maxLen;
        }
    }
}
