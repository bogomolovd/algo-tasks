package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 1));
    }

    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
            comparator = comparator.thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder()));
            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, comparator);
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                int freq = map.getOrDefault(word, 0);
                map.put(word, freq + 1);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (queue.size() < k) {
                    queue.offer(entry);
                    continue;
                } 
                Map.Entry<String, Integer> queueEntry = queue.peek(); 
                if (queueEntry.getValue() < entry.getValue() || 
                    (queueEntry.getValue().equals(entry.getValue()) 
                        && queueEntry.getKey().compareTo(entry.getKey()) > 0)) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
            String result[] = new String[k];
            for (int i = k - 1; i >= 0; i--) {
                result[i] = queue.poll().getKey();
            }
            return Arrays.asList(result);
        }
    }
}
