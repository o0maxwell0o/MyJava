package com.maxwell.test.leetcode;

/**
 * @author usonc016
 * @date 2021/7/17 17:46
 */
public class No169_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 7, 7};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // 摩尔投票算法
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int count = 1;
        int n = nums.length / 2;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
                if (count > n) {
                    return result;
                }
            } else {
                if (count > 0) {
                    count--;
                } else {
                    count = 1;
                    result = nums[i];
                }
            }
        }
        return result;
    }
}
