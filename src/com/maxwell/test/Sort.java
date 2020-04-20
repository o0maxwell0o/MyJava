package com.maxwell.test;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] a = {3, 11, 4, 1, 7, 4, 22, 6};
        shellSort(a);
    }

    public static void bubbleSort(int[] array) {
        //放一个哨兵，检查是否能提前结束
        int size = array.length;
        boolean check = true;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    check = false;
                }
            }
            if (check) {
                break;
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void selectionSort(int[] array) {
        //不可以提前结束，最外层的for必须走完
        //每一次在未排序中选一个最小的放在已排序数列的尾端
        int size = array.length;
        boolean check = false;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    check = true;
                }
            }
            if (check) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }

            System.out.println(Arrays.toString(array));
        }
    }

    public static void insertionSort(int[] array) {
        //不可以提前结束，for必须走完
        //每一次取未排序数列的第一位，从已排序的数列尾端开始向前比较，插入到顺序位置
        int current;
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void shellSort(int[] array) {
        int size = array.length;
        int temp, preIndex;
        int gap = size / 2;
        while (gap > 0) {
            for (int i = gap; i < size; i++) {
                temp = array[i];
                preIndex = i - gap;
                while (preIndex >= 0 && temp < array[preIndex]) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            System.out.println(Arrays.toString(array));
            gap /= 2;
        }
    }
}
