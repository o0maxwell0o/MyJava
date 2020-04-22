package com.maxwell.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort {
    public static void main(String[] args) {
        int[] a = {7, 200, 1000, 300, 3, 233, 13, 500};
        heapSort_asc(a);
        System.out.println(Arrays.toString(a));

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

    public static void bucketSort(int[] array) {
        int length = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int bucketCount = 10;//默认设置4个桶
        for (int i = 0; i < length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int range = (max - min + 1) / bucketCount;//每个桶的范围
        if (range != (double) (max - min + 1) / (double) bucketCount) {
            range++;
        }
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < length; i++) {
            int val = array[i];
            // 计算当前值属于哪个桶
            int bucketIndex = (int) Math.floor((val - min) / range);
            // 向桶中添加元素
            ArrayList<Integer> arrayList = bucketArr.get(bucketIndex);
            if (arrayList.isEmpty()) {
                arrayList.add(array[i]);
            } else {
                boolean checkEnd = true;
                for (int index = 0; index < arrayList.size(); index++) {
                    if (array[i] < arrayList.get(index)) {
                        arrayList.add(index, array[i]);
                        checkEnd = false;
                        break;
                    }
                }
                if (checkEnd) {
                    arrayList.add(array[i]);
                }
            }
        }
        int putIndex = 0;
        for (ArrayList<Integer> arr : bucketArr) {
            for (int i : arr) {
                array[putIndex] = i;
                putIndex++;
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void maxheap_down(int a[], int start, int end) {
        int c = start;            // 当前(current)节点的位置
        int l = 2 * c + 1;        // 左(left)孩子的位置
        int tmp = a[c];            // 当前(current)节点的大小
        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] < a[l + 1])
                l++;        // 左右两孩子中选择较大者，即m_heap[l+1]
            if (tmp >= a[l])
                break;        // 调整结束
            else            // 交换值
            {
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }

    /*
     * 堆排序(从小到大)
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void heapSort_asc(int a[]) {
        int i;
        int n = a.length;
        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--)
            maxheap_down(a, i, n - 1);

        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            swap(a, 0, i);
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxheap_down(a, 0, i - 1);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}

