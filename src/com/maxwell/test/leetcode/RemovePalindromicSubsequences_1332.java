package com.maxwell.test.leetcode;

public class RemovePalindromicSubsequences_1332 {
    public static void main(String[] args) {
        System.out.println(removPalindromeSub("ababa"));
    }

    public static int removPalindromeSub(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        } else {
            char[] strArr = s.toCharArray();
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                if (strArr[i] != strArr[j]) {
                    return 2;
                }
            }
            return 1;
        }
    }
}
