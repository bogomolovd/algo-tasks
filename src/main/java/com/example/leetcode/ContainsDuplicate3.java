package com.example.leetcode;

import java.util.TreeMap;

public class ContainsDuplicate3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { -2147483648, 2147483647 }, 1, 1));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 3, 6, 2 }, 1, 2));
    }

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeMap<Integer, Integer> counts = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (counts.size() == k + 1) {
                    int prev = nums[i - (k + 1)];
                    Integer prevElemCount = counts.get(prev);
                    if (prevElemCount == 1) {
                        counts.remove(prev);
                    } else {
                        counts.put(prev, prevElemCount - 1);
                    }
                }
                int cur = nums[i];
                Integer ceil = counts.ceilingKey(cur);
                if (ceil != null && Math.abs((long) ceil - (long) cur) <= t) {
                    return true;
                }
                Integer floor = counts.floorKey(cur);
                if (floor != null && Math.abs((long) floor - (long) cur) <= t) {
                    return true;
                }
                int curCount = counts.getOrDefault(cur, 0);
                counts.put(cur, curCount + 1);
            }
            return false;
        }
    }
}
