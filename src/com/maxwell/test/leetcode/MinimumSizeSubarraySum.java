package com.maxwell.test.leetcode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
