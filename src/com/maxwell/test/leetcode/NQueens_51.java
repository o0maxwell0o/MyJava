package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[] pathtemp = new char[n];
        for (int i = 0; i < n; i++) {
            pathtemp[i] = '.';
        }
        helper(result, new ArrayList<String>(), 0, n, pathtemp);
        return result;

    }

    public static void helper(List<List<String>> result, List<String> path, int index, int nums, char[] pathtemp) {
        if (index == nums) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < nums; i++) {
                if (check(nums, i, path, index)) {
                    char[] temp = pathtemp.clone();
                    temp[i] = 'Q';
                    path.add(String.valueOf(temp));
                    helper(result, path, index + 1, nums, pathtemp);
                    path.remove(index);
                }
            }
        }
    }

    public static boolean check(int n, int i, List<String> path, int index) {
        for (int row = index - 1; row >= 0; row--) {
            if (path.get(row).charAt(i) == 'Q') {
                return false;
            }
            if (i - index + row >= 0 && path.get(row).charAt(i - index + row) == 'Q') {
                return false;
            }
            if (i + index - row < n && path.get(row).charAt(i + index - row) == 'Q') {
                return false;
            }

        }
        return true;
    }

}
