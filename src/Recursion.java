import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        dfs(a, 0, 3);

    }

    public static int factorial(int i) {
        //阶乘
        if (i == 0 || i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static void recursionDisplay(int n) {
        int temp = n;
        System.out.println("push: " + temp);
        if (n > 0) {
            recursionDisplay(--n);
        }
        System.out.println("pull: " + temp);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    //递归过程是：在递进的过程中拆分数组，在回归的过程合并数组
    public static void mergeSort(int[] nums, int first, int last) {
        /*
        int[] nums = {6, 5, 3, 8, 1, 7, 2, 9, 4};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
         */
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(nums, first, mid);    //归并排序前半个子序列
            mergeSort(nums, mid + 1, last); //归并排序后半个子序列
            merge(nums, first, mid, last);    //在回归过程中合并
        }
    }

    public static void merge(int[] nums, int first, int mid, int last) {
        int left = first;
        int right = mid + 1;
        int temp = 0;
        int[] tempArray = new int[last - first + 1];
        while (left <= mid && right <= last) {
            if (nums[left] < nums[right]) {
                tempArray[temp++] = nums[left++];
            } else {
                tempArray[temp++] = nums[right++];
            }
        }
        while (left <= mid) {
            tempArray[temp++] = nums[left++];
        }
        while (right <= last) {
            tempArray[temp++] = nums[right++];
        }
        System.arraycopy(tempArray, 0, nums, first, tempArray.length);
    }

    private static void dfs(int a[], int start, int end) {
        //全排列
        if (start == end) {
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
            System.out.println();

        } else {
            for (int i = start; i <= end; i++) {
                swap(a, start, i);
                dfs(a, start + 1, end);
                //逐层复原数列顺序，进入下一个循环
                swap(a, start, i);
            }
        }
    }

    private static void swap(int[] a, int s2, int i) {
        int t = a[s2];
        a[s2] = a[i];
        a[i] = t;
    }
}
