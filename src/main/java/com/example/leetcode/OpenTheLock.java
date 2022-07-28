package com.example.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
        String[] deadends1 = new String[] {"0001"};
        String target1 = "0002";
        System.out.println(solution.openLock(deadends, target));
    }

    static class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> moves = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            String start = "0000";
            moves.offer(start);
            visited.add(start);
            int movesNum = 0;
            int curTransitions = 1;
            int nextTransitions = 0;
            while (!moves.isEmpty()) {
                String move = moves.poll();
                if (move.equals(target)) {
                    return movesNum;
                }
                if (contains(deadends, move)) {
                    continue;
                }
                char[] moveArr = move.toCharArray();
                for (int i = 0; i < move.length(); i++) {
                    char digitChar = move.charAt(i);
                    int digit = Character.getNumericValue(digitChar);
                    int digitDecr = digit - 1;
                    if (digitDecr < 0) {
                        digitDecr = 9;
                    }
                    moveArr[i] = Character.forDigit(digitDecr, 10);
                    String moveDown = new String(moveArr);
                    if (!visited.contains(moveDown)) {
                        moves.offer(moveDown);
                        visited.add(moveDown);
                        nextTransitions++;
                    }
                    int digitIncr = digit + 1;
                    if (digitIncr > 9) {
                        digitIncr = 0;
                    }
                    moveArr[i] = Character.forDigit(digitIncr, 10);
                    String moveUp = new String(moveArr);
                    if (!visited.contains(moveUp)) {
                        moves.offer(moveUp);
                        visited.add(moveUp);
                        nextTransitions++;
                    }
                    moveArr[i] = digitChar;
                }
                curTransitions--;
                if (curTransitions == 0) {
                    movesNum++;
                    curTransitions = nextTransitions;
                    nextTransitions = 0;
                }
            }
            return -1;
        }

        private boolean contains(String[] arr, String value) {
            for (String item : arr) {
                if (value.equals(item)) {
                    return true;
                }
            }
            return false;
        }
    }
}
