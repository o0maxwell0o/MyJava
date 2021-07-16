package com.maxwell.test.leetcode;

/**
 * @author usonc016
 * @date 2021/7/15 10:25
 */
public class No11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        //while(start < end) 都可以
        for (;start < end;) {
            int width = end - start;
            int heightInt = 0;
            if (height[start] >= height[end]) {
                heightInt = height[end];
                end--;
            } else {
                heightInt = height[start];
                start++;
            }
            int temp = heightInt * width;
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
