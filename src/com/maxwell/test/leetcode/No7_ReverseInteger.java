package com.maxwell.test.leetcode;

import java.util.Arrays;

/**
 * @author usonc016
 * @date 2021/7/16 18:51
 */
public class No7_ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long result = 0;
        while (x != 0) {
            int temp = x % 10;
            result = result * 10 + temp;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
