package com.example.leetcode;

/**
 * Hello world!
 *
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("5 = " + solution.intToRoman(5));
        System.out.println("9 = " + solution.intToRoman(9));
        System.out.println("13 = " + solution.intToRoman(13));
        System.out.println("58 = " + solution.intToRoman(58));
        System.out.println("1994 = " + solution.intToRoman(1994));
        System.out.println("3999 = " + solution.intToRoman(3999));
    }

    static class Solution {
        public String intToRoman(int num) {
            return getNumber(num / 1000, "M", null, null) +
                    getNumber((num / 100) % 10, "C", "D", "M") +
                    getNumber((num / 10) % 10, "X", "L", "C") +
                    getNumber(num % 10, "I", "V", "X");
        }

        private String getNumber(int num, String oneChar, String fiveChar, String tenChar) {
            if (num == 9) {
                return oneChar + tenChar;
            }
            if (num == 4) {
                return oneChar + fiveChar;
            }
            return (num >= 5 ? fiveChar : "") + oneChar.repeat(num % 5);
        }
    }
}
