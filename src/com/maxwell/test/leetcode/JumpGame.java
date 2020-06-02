package com.maxwell.test.leetcode;

import java.util.Map;

import static java.lang.System.exit;

public class JumpGame {
    static boolean result = false;

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }


    public static boolean canJump(int[] nums) {
        try {
            jump(nums, 0);
        } catch (RuntimeException e) {
            return true;
        }

        return result;
    }

    public static void jump(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            result = true;
            throw new RuntimeException();
        } else {
            int step = nums[pos];
            if (step == 0) {
                return;
            } else {
                for (int i = 1; i <= step; i++) {
                    if (pos + i < nums.length) {
                        jump(nums, pos + i);
                    }
                }
            }
        }
    }

     /*
    public static boolean canJump(int[] nums) {
        if (nums.length == 0 || nums[0] == 0 && nums.length > 1) {
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = Math.max(nums[i - 1] - 1, nums[i]);
            if (i < nums.length - 1 && nums[i] <= 0) {
                return false;
            }
        }
        return true;
    }

      */
}
