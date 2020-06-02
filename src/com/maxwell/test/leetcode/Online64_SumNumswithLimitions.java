package com.maxwell.test.leetcode;

public class Online64_SumNumswithLimitions {
    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    public static int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        sum += n;
        return sum;
    }

}
