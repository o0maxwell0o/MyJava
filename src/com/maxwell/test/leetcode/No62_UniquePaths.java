package com.maxwell.test.leetcode;

public class No62_UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int count = check(m, n, 0, 0, 0);
        return count;

    }

    public static int check(int m, int n, int count, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        int n1 = 0;
        int n2 = 0;
        if (x < m - 1) {
            n1 += check(m, n, count, x + 1, y);
        }
        if (y < n - 1) {
            n2 += check(m, n, count, x, y + 1);
        }

        return n1 + n2;
    }
}

