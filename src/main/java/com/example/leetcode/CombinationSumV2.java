package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumV2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
        // System.out.println(solution.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));

    }

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> combinations = new ArrayList<>();
            findCombinations(candidates, new ArrayList<>(), 0, 0, target, combinations);
            return combinations;
        }

        private void findCombinations(int[] candidates, List<Integer> acc, int index, int currsum, int target,
                List<List<Integer>> combinations) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                int newSum = currsum + candidates[i];
                if (newSum == target) {
                    acc.add(candidates[i]);
                    combinations.add(acc);
                    return;
                }
                if (newSum > target) {
                    return;
                }
                List<Integer> newAcc = new ArrayList<>();
                newAcc.addAll(acc);
                newAcc.add(candidates[i]);
                findCombinations(candidates, newAcc, i + 1, newSum, target, combinations);
            }
        }
    }
}
