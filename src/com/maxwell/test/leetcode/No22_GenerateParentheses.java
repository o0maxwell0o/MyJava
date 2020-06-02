package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        help(n, n, "", result);
        return result;
    }

    private static void help(int left, int right, String path, List<String> result) {
        if (left <= right) {
            if (left == 0 && right == 0) {
                result.add(path);
                return;
            }
            if (left < 0 || right < 0) {
                return;
            }
            help(left - 1, right, path + '(', result);
            help(left, right - 1, path + ')', result);
        }
    }
}
