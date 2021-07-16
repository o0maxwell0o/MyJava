package com.maxwell.test.leetcode;

/**
 * @author usonc016
 * @date 2021/7/15 11:04
 */
public class No13_RomantoInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                if (s.charAt(i) == 'I') {
                    if (s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                        continue;
                    } else if (s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                        continue;
                    }
                } else if (s.charAt(i) == 'X') {
                    if (s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                        continue;
                    } else if (s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                        continue;
                    }
                } else if (s.charAt(i) == 'C') {
                    if (s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                        continue;
                    } else if (s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                        continue;
                    }
                }

            }
            result += getResult(s.charAt(i));
        }
        return result;
    }

    public static int getResult(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
