package com.maxwell.test.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations_17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> astr = new LinkedList<>();
        return recursive(astr, digits, 0);

    }

    public static List<String> recursive(List<String> astr, String digits, int index) {
        if (index == digits.length()) {
            return astr;
        }
        List<String> temp = new LinkedList<>();
        char a = digits.charAt(index);
        char[] putin = {
                'a', 'b', 'c',
                'd', 'e', 'f',
                'g', 'h', 'i',
                'j', 'k', 'l',
                'm', 'n', 'o',
                'p', 'q', 'r', 's',
                't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        int start = 0, end = 0;
        switch (a) {
            case '2':
                start = 0;
                end = 2;
                break;
            case '3':
                start = 3;
                end = 5;
                break;
            case '4':
                start = 6;
                end = 8;
                break;
            case '5':
                start = 9;
                end = 11;
                break;
            case '6':
                start = 12;
                end = 14;
                break;
            case '7':
                start = 15;
                end = 18;
                break;
            case '8':
                start = 19;
                end = 21;
                break;
            case '9':
                start = 22;
                end = 25;
                break;
        }
        if (astr.isEmpty()) {
            for (int i = start; i <= end; i++) {
                temp.add(String.valueOf(putin[i]));
            }
        } else {
            for (String old : astr) {
                for (int i = start; i <= end; i++) {
                    temp.add(old + putin[i]);
                }
            }
        }
        astr = temp;
        return recursive(astr, digits, ++index);
    }
}
