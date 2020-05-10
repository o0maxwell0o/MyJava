package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        help(result, new ArrayList<Integer>(), nums);
        return result;

    }

    private static void help(List<List<Integer>> result, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);
                help(result, path, nums);
                path.remove(path.size() - 1);//backtracking
            }
        }

    }
}
