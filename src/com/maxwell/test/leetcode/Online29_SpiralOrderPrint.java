package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Online29_SpiralOrderPrint {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] test1 = {};
        System.out.println(spiralOrder(test1));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            int[] empty = {};
            return empty;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        int count = 0;
        int total = x * y;
        int x_pos = 0;
        int y_pos = 0;
        int forward = 0;
        List<Integer> result = new ArrayList<>();
        boolean[][] check = new boolean[y][x];
        while (count < total) {
            result.add(matrix[y_pos][x_pos]);
            check[y_pos][x_pos] = true;
            switch (forward) {
                case 0:
                    if (x_pos + 1 == x || check[y_pos][x_pos + 1]) {
                        forward = 1;
                        y_pos += 1;
                    } else {
                        x_pos += 1;
                    }
                    break;
                case 1:
                    if (y_pos + 1 == y || check[y_pos + 1][x_pos]) {
                        forward = 2;
                        x_pos -= 1;
                    } else {
                        y_pos += 1;
                    }
                    break;
                case 2:
                    if (x_pos - 1 < 0 || check[y_pos][x_pos - 1]) {
                        forward = 3;
                        y_pos -= 1;
                    } else {
                        x_pos -= 1;
                    }
                    break;
                case 3:
                    if (y_pos - 1 < 0 || check[y_pos - 1][x_pos]) {
                        forward = 0;
                        x_pos += 1;
                    } else {
                        y_pos -= 1;
                    }
                    break;
            }
            count++;
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;

    }
}
