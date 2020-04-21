package com.maxwell.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort {
    public static void main(String[] args) {
        int[] a = {3, 11, 4, 3, 222, 12312, 2222, 6};
        radixSort(a);
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

    public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            int[] temp = new int[high - low + 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[i + low];
            }
            int i = low, j = mid + 1, k = low;
            for (; i <= mid && j <= high; k++) {
                if (temp[i - low] < temp[j - low]) {
                    array[k] = temp[i++ - low];
                } else {
                    array[k] = temp[j++ - low];
                }
            }
            while (i <= mid) {
                array[k++] = temp[i++ - low];
            }
            while (j <= high) {
                array[k++] = temp[j++ - low];
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int base = array[end];
        int i = start, j = end;
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }

        }
        System.out.println(Arrays.toString(array));
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);

    }

    public static void countingSort(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }
        for (int i = 0, index = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[index] = i + min;
                index++;
                count[i]--;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int divNumber;//用于基数分类0-9
        int count = 0;//计算最大数的位数
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        while (max > 0) {
            max /= 10;
            count++;
        }
        for (int radix = 0; radix < count; radix++) {
            for (int i = 0; i < 10; i++) {
                map.put(i, new ArrayList<Integer>());
            }
            for (int i = 0; i < array.length; i++) {
                int divTime = radix;
                divNumber = array[i];
                while (divTime != 0) {
                    divNumber /= 10;
                    divTime--;
                }
                divNumber %= 10;
                map.get(divNumber).add(array[i]);
            }
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j : map.get(i)) {
                    array[index++] = j;
                }
            }
            System.out.println(Arrays.toString(array));
        }

    }

}

