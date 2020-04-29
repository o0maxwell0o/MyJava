package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid_1260 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 22;
        shiftGrid(grid, k);

    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int col = grid[0].length;
        int row = grid.length;
        int[][] temp = new int[row][col];
        int movcol = k % col;
        int movrow = (k / col) % row;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int fincol = 0, finrow = 0;
                boolean addrow = false;
                if (movcol + j > col - 1) {
                    fincol = j + movcol - col;
                    addrow = true;
                } else {
                    fincol = j + movcol;
                }
                if (addrow) {
                    if (movrow + 1 + i > row - 1) {
                        finrow = 1 + i + movrow - row;
                    } else {
                        finrow = 1 + i + movrow;
                    }

                } else {
                    if (movrow + i > row - 1) {
                        finrow = i + movrow - row;
                    } else {
                        finrow = i + movrow;
                    }
                }
                temp[finrow][fincol] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                tempList.add(temp[i][j]);
            }
            result.add(tempList);
        }
        return result;
    }
}
