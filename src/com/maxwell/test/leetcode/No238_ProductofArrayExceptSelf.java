package com.maxwell.test.leetcode;

public class No238_ProductofArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1]*result[i-1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = temp * result[i];
            temp *= nums[i];
        }
        return result;
    }
}
