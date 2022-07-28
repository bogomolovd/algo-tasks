package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class SnakesAndLadders {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = new int[][] {
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 }
        };
        int[][] board1 = new int[][] {
                { -1, -1 },
                { -1, 1 }
        };
        int[][] board2 = new int[][] {
                { -1, 4, -1 },
                { 6, 2, 6 },
                { -1, 3, -1 }
        };
        int[][] board3 = new int[][] {
                { 1, 1, -1 },
                { 1, 1, 1 },
                { -1, 1, 1 }
        };
        int[][] board4 = new int[][] {
                { -1, -1, -1, -1, 48, 5, -1 },
                { 12, 29, 13, 9, -1, 2, 32 },
                { -1, -1, 21, 7, -1, 12, 49 },
                { 42, 37, 21, 40, -1, 22, 12 },
                { 42, -1, 2, -1, -1, -1, 6 },
                { 39, -1, 35, -1, -1, 39, -1 },
                { -1, 36, -1, -1, -1, -1, 5 }
        };
        int[][] board5 = new int[][] {
                { -1, 1, 2, -1 },
                { 2, 13, 15, -1 },
                { -1, 10, -1, -1 },
                { -1, 6, 2, 8 }
        };
        int[][] board6 = new int[][] {
                { -1, -1, -1, 63, -1, -1, -1, 62, -1 },
                { 53, 52, 13, 32, -1, -1, -1, -1, -1 },
                { -1, -1, 26, -1, 73, -1, -1, -1, 55 },
                { -1, -1, -1, -1, 74, -1, -1, -1, -1 },
                { -1, -1, 35, 42, -1, 45, -1, -1, -1 },
                { 81, -1, 3, 46, -1, -1, -1, -1, 59 },
                { 74, -1, 66, 16, -1, -1, -1, -1, -1 },
                { -1, -1, -1, 28, -1, -1, 81, -1, 22 },
                { -1, -1, -1, -1, 61, 17, 39, 21, -1 }
        };
        int[][] board7 = new int[][] {
                { -1, 1, 1, 1 },
                { -1, 7, 1, 1 },
                { 16, 1, 1, 1 },
                { -1, 1, 9, 1 }
        };
        int[][] board8 = new int[][] {
                { -1, 1, 1, 1 },
                { -1, 7, 1, 1 },
                { 1, 1, 1, 1 },
                { -1, 1, 9, 1 }
        };
        int[][] board9 = new int[][] {
                { -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 300, -1, -1, -1, -1 },
                { -1, -1, 173, -1, -1, 273, 197, -1, -1, -1, -1, -1, 110, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, 215, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1 },
                { -1, -1, 148, -1, -1, -1, -1, 168, -1, -1, -1, -1, -1, -1, -1, 207, -1, -1 },
                { -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 177, 295, -1, 170, -1, -1, -1, -1, 184, 250, -1, -1, 192, 251, -1, -1, 53 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 298, -1, -1, 34, 182, 107, -1, 32 },
                { 284, 205, -1, -1, -1, -1, -1, 119, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1 },
                { -1, -1, 71, -1, 309, -1, -1, 13, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1 },
                { 9, -1, -1, -1, -1, 312, -1, -1, -1, 238, -1, -1, -1, -1, 118, -1, -1, -1 },
                { -1, -1, -1, 225, -1, -1, 315, -1, -1, -1, 203, -1, -1, -1, -1, -1, 129, -1 },
                { 225, -1, 73, -1, -1, -1, -1, -1, 124, -1, -1, 161, -1, 184, 201, -1, 309, -1 },
                { -1, -1, -1, 138, -1, -1, -1, 87, 280, -1, 165, -1, 240, 227, -1, -1, -1, -1 },
                { 49, -1, -1, -1, -1, 131, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, 66, 149 },
                { -1, -1, -1, -1, -1, -1, -1, 46, -1, -1, 189, 266, -1, -1, 178, -1, -1, -1 },
                { 67, 280, -1, 252, -1, 191, -1, 21, -1, -1, 147, -1, 301, -1, -1, -1, -1, -1 },
                { -1, 156, -1, -1, 260, -1, -1, -1, -1, 66, -1, 319, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 238, -1, -1, -1, -1, -1, -1 }
        };
        System.out.println(solution.snakesAndLadders(board)); // should be 4
        System.out.println(solution.snakesAndLadders(board1)); // should be 1
        System.out.println(solution.snakesAndLadders(board2)); // should be 2
        System.out.println(solution.snakesAndLadders(board3)); // should be -1
        System.out.println(solution.snakesAndLadders(board4)); // should be 3
        System.out.println(solution.snakesAndLadders(board5)); // should be 2
        System.out.println(solution.snakesAndLadders(board6)); // should be 3
        System.out.println(solution.snakesAndLadders(board7)); // should be 3
        System.out.println(solution.snakesAndLadders(board8)); // should be -1
        System.out.println(solution.snakesAndLadders(board9)); // should be 5
    }

    static class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            boolean[] visited = new boolean[n * n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            for (int moves = 0; !queue.isEmpty(); moves++) {
                for (int size = queue.size(); size > 0; size--) {
                    int elem = queue.poll();
                    if (visited[elem]) {
                        continue;
                    }
                    if (elem == n * n) {
                        return moves;
                    }
                    visited[elem] = true;
                    for (int step = 1; step <= 6 && elem + step <= n * n; step++) {
                        int ref = getRef(board, elem + step);
                        int next = ref != -1 ? ref : elem + step;
                        if (!visited[next] && !queue.contains(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
            return -1;
        }

        public int getRef(int[][] board, int elem) {
            return board[getRow(elem, board.length)][getColumn(elem, board.length)];
        }

        private int getRow(int cellNumber, int boardSize) {
            return boardSize - 1 - ((cellNumber - 1) / boardSize);
        }

        private int getColumn(int cellNumber, int boardSize) {
            if (((cellNumber - 1) / boardSize) % 2 != 0) {
                return (boardSize - cellNumber % boardSize) % boardSize;
            } else {
                return (cellNumber - 1) % boardSize;
            }
        }
    }
}
