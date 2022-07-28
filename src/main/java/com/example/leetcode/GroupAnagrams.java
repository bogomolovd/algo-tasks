package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<List<Integer>, List<String>> groups = new HashMap<>();
            for (String str : strs) {
                Integer[] arr = new Integer[26];
                Arrays.fill(arr, 0);
                List<Integer> key = Arrays.asList(arr);
                for (char c : str.toCharArray()) {
                    int index = c - 'a';
                    Integer val = key.get(index);
                    key.set(index, val == null ? 1 : val + 1);
                }
                groups.compute(key, (k, v) -> {
                    if (v == null) {
                        List<String> value = new ArrayList<>();
                        value.add(str);
                        return value;
                    } else {
                        v.add(str);
                        return v;
                    }});
            }
            List<List<String>> result = groups.values().stream()
                .collect(Collectors.toList());
            return result;
        }
    }
}
