package com.maxwell.test.leetcode;

import java.util.HashSet;
import java.util.Set;

public class No128_LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentResult = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentResult++;
                }
                result = Math.max(currentResult, result);
            }
        }
        return result;
    }
}
