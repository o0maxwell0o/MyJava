package com.maxwell.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No39_CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        check(candidates, target, results, path, sum);
        return results;
    }

    public static void check(int[] candidates, int target, List<List<Integer>> results, List<Integer> path, int sum) {
        for (int i = 0; i < candidates.length; i++) {
            int temp = candidates[i];
            sum += temp;
            if (sum > target) {
                sum -= temp;
            } else if (sum == target) {
                path.add(temp);
                List<Integer> tempList = new ArrayList<>(path);
                Collections.sort(tempList);
                if (!results.contains(tempList)) {
                    results.add(tempList);
                }
                path.remove(path.size() - 1);
                sum -= temp;
            } else {
                path.add(temp);
                check(candidates, target, results, path, sum);
                path.remove(path.size() - 1);
                sum -= temp;
            }
        }
    }
}
