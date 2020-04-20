package com.maxwell.test;

import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int[] test = {1, 3, 5, 6, 2, 4, 7};
        Arrays.sort(test);
        int result = binaryRank(8, test);
        if (result == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("找到，下表是" + result);
        }
    }

    public static int binaryRank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
