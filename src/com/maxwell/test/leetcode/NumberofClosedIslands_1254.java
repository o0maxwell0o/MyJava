package com.maxwell.test.leetcode;

public class NumberofClosedIslands_1254 {
    public static void main(String[] args) {
        int count = 0;
        int[][] g = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if ((i == 0 || i == g.length - 1 || j == 0 || j == g[0].length - 1) && g[i][j] == 0) {
                    dfs(g, i, j, -1);
                }
            }
        }

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j, -1);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] g, int i, int j, int c) {
        if (i < 0 || i == g.length || j < 0 || j == g[0].length || g[i][j] != 0) return;
        g[i][j] = c;
        dfs(g, i - 1, j, c);
        dfs(g, i, j - 1, c);
        dfs(g, i + 1, j, c);
        dfs(g, i, j + 1, c);
    }
}
