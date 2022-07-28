package com.example.leetcode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SudokuSolver {
    private static final Logger LOGGER = Logger.getLogger("MyLog"); 

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("M-d_HHmmss");
        FileHandler fh = null;
        try {
            fh = new FileHandler("C:/Workspace/MyLogFile_"
                + format.format(Calendar.getInstance().getTime()) + ".log");
        } catch (Exception e) {
            e.printStackTrace();
        }
        fh.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fh);
        Solution solution = new Solution();
        char[][] arr = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solution.solveSudoku(arr);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    
    static class Solution {
        public void solveSudoku(char[][] board) {
            char[][] curBoard = new char[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    curBoard[i][j] = board[i][j];
                }
            }
            backtrack(board, curBoard, 0, 0);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = curBoard[i][j];
                }
            }
        }
        
        private boolean backtrack(char[][] initBoard, char[][] curBoard, int row, int col) {
            if (initBoard[row][col] != '.') {
                if (row == 8 && col == 8) {
                    return true;
                }
                return backtrack(initBoard, curBoard, col < 8 ? row : row + 1, (col + 1) % 9);
            }
            for (int num = 1; num <= 9; num++) {
                if (canPlaceNumber(initBoard, curBoard, row, col, num)) {
                    curBoard[row][col] = Character.forDigit(num, 10);    
                    if (row == 8 && col == 8) {
                        return true;
                    }
                    if (!backtrack(initBoard, curBoard, col < 8 ? row : row + 1, (col + 1) % 9)) {
                        curBoard[row][col] = '.';   
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        
        private boolean canPlaceNumber(char[][] initBoard, char[][] curBoard, int row, int col, int num) {
            return curBoard[row][col] == '.' 
                && !rowContainsNum(curBoard, row, num)
                && !colContainsNum(curBoard, col, num)
                && !subBoxContainsNum(curBoard, row, col, num); 
        }
        
        private boolean rowContainsNum(char[][] curBoard, int row, int num) {
            for (int i = 0; i < 9; i++) {
                char ch = curBoard[row][i];
                if (ch != '.' && Character.getNumericValue(ch) == num) {
                    return true;
                }
            }
            return false;
        }
        
        private boolean colContainsNum(char[][] curBoard, int col, int num) {
            for (int i = 0; i < 9; i++) {
                char ch = curBoard[i][col];
                if (ch != '.' && Character.getNumericValue(ch) == num) {
                    return true;
                }
            }
            return false;
        }
        
        private boolean subBoxContainsNum(char[][] curBoard, int row, int col, int num) {
            int subBoxRow = row / 3;
            int subBoxCol = col / 3;
            for (int i = subBoxRow * 3; i < (subBoxRow + 1) * 3; i++) {
                for (int j = subBoxCol * 3; j < (subBoxCol + 1) * 3; j++) {
                    char ch = curBoard[i][j];
                    if (ch != '.' && Character.getNumericValue(ch) == num) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
