package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No46_Permutations {
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

        } else {
            for (int num : nums) {
                if (path.contains(num)) {
                    continue;
                }
                path.add(num);
                help(result, path, nums);
                path.remove(path.size() - 1);//backtracking
            }
        }

    }
}
