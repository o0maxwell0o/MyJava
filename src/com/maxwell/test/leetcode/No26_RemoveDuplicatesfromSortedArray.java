package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author usonc016
 * @date 2021/7/16 18:28
 */
public class No26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 1, n = nums.length;
        while (right < n) {
            if (nums[right] == nums[left]) {
                right++;
            } else {
                nums[left + 1] = nums[right];
                left++;
                right++;
            }
        }
        return left + 1;
    }
}
