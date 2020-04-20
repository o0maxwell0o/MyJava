package com.maxwell.test;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 7, 8, 2, 1, 3};
        bubbleSort(a);
    }

    public static void bubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            boolean check = true;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
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
}
