package com.maxwell.test.leetcode;

public class No70_ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
