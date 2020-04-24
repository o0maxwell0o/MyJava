package com.maxwell.test;

import java.util.*;

public class Online {
    public static void main(String[] args) {
        String a = "bbbcccaaa";
        zipStringCount(a);
    }

    public static void luckyNumberTree(int n, int m, int[] array) {
        //put into main
        /*
        int n = 5, m = 2;
        int[] array = {1, 2, 3, 4, 5};
        luckyNumberTree(n, m, array);
         */
        //一条直线上种了N棵树，每棵树有一个和谐数，若区间内各和谐数之和能被M整数就是和谐区间，求和谐区间个数
        int N = n;
        int M = m;
        int count = 0;
        int[] Array = array;
        List<Integer[]> list = new ArrayList<>();
        for (int length = 1; length <= N; length++) {
            int sum = 0;
            int size = length;
            for (int i = 0; i < N - size + 1; i++) {
                int[] write = new int[length];
                while (size > 0) {
                    sum += Array[i + length - size];
                    write[length - size] = Array[i + length - size];
                    size--;
                }
                if (sum % M == 0) {
                    count++;
                    Integer[] newlist = new Integer[write.length];
                    for (int k = 0; k < write.length; k++) {
                        newlist[k] = Integer.valueOf(write[k]);
                    }
                    list.add(newlist);
                }
                sum = 0;
                size = length;
            }
        }
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                System.out.print(list.get(i)[j] + " ");
            }
            System.out.println("");
        }
    }

    public static void buyThreeFreeOne(int n, int[] value) {
        /*
        int n = 4;
        int[] value = {100, 200, 300, 400};
        buyThreeFreeOne(n, value);
         */
        //买三个物品，当中价值最低的物品变为免费，请问购买下列物品最少需要花费多少钱
        int N = n;
        List<Integer> list = new ArrayList<>();
        for (int i : value) {
            list.add(i);
        }
        Collections.sort(list);
        Collections.reverse(list);
        int count = 1, sum = 0;
        for (int i : list) {
            if (count % 3 == 0) {
                count = 1;
            } else {
                sum += i;
                count++;
            }
        }
        System.out.println(sum);
    }

    public static void checkArray(int n, int[] a, int[] b) {
        //数组a的某个连续区间加上一个特定值k后能变成数组b则输出YES，否则输出NO
        /*
        int n = 6;
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {1, 2, 4, 4, 5, 6};
        checkArray(n, a, b);
         */
        boolean start = false, end = false, hasbreak = false;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                //equal
                if (start && !end) {
                    //mid
                    end = true;
                }

            } else {
                //not equal
                if (!start && !end) {
                    //before start
                    start = true;
                    diff = b[i] - a[i];

                } else if (start && !end) {
                    //mid
                    if (diff != b[i] - a[i]) {
                        System.out.println("NO");
                        hasbreak = true;
                        break;
                    }
                } else if (start && end) {
                    //after end
                    System.out.println("NO");
                    hasbreak = true;
                    break;
                }
            }
        }
        if (!hasbreak) {
            System.out.println("YES");
        }

    }

    public static int check(List<Integer> array, int n) {
        //整理数组让它成为非递减顺序，并输出操作次数
        //每次操作可以对一个数分解成两个数的和，并加入到原位置中
        //!!!未完成
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
        boolean finish = true;
        int count = 0;
        while (finish) {
            boolean notyet = false;
            for (int i = 0; i < n - 1; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    count += check(array, n);
                    notyet = true;
                }
            }
            if (!notyet) {
                finish = false;
            }
        }
        System.out.println(count);
         */
        int count = 0;
        if (array.get(0) > array.get(1)) {
            int it = array.get(0);
            int after = array.get(0 + 1);
            it -= after;
            array.remove(0);
            array.add(0, it);
            array.add(0 + 1, after);
        }
        for (int i = 1; i < n - 1; i++) {
            if (array.get(i) > array.get(i + 1)) {
                int it = array.get(i);
                int pre = array.get(i - 1);
                it -= pre;
                array.remove(i);
                array.add(i, pre);
                array.add(i + 1, it);
                count++;
            }
        }
        return count;
    }

    public static void sumPrice(int[] coupon, int[] price) {
        //有一系列优惠券，并使用这些优惠券购买商品
        //当商品价格大于等于某个优惠券，便可以使用该优惠券，支付扣除优惠券的价格（会出现200-200=0）
        //计算使用优惠券后，购买商品的实际价格
        /*
        int[] a = {50, 100, 200};
        int[] b = {300, 300, 300, 300};
        Arrays.sort(a);
        Arrays.sort(b);
        sumPrice(a, b);
         */
        int index = 0, sum = 0;
        for (int i = 0; i < price.length; i++) {
            boolean checkwhile = false;
            while (index < coupon.length) {
                if (price[i] < coupon[index]) {
                    //价格小于优惠券
                    if (index > 0) {
                        //该商品已经可以使用优惠券
                        sum += price[i] - coupon[index - 1];
                        checkwhile = true;
                        break;
                    } else {
                        //该商品没有可以使用的优惠券
                        sum += price[i];
                        checkwhile = true;
                        break;
                    }

                } else {
                    //价格大于或等于优惠券
                    if (price[i] == coupon[index]) {
                        //等于
                        sum += price[i] - coupon[index];
                        checkwhile = true;
                        break;
                    } else {
                        //大于
                        index++;
                    }

                }
            }
            if (!checkwhile) {
                sum += price[i] - coupon[coupon.length - 1];
            }
        }
        System.out.println(sum);
    }


    public static void zipStringCount(String str) {
        //字符串包括a-z,A-Z,0-9,'-'
        //数字表示数字前的字符串重复的次数例如abc3>>abcabcabc
        //'-'表示从哪个字母按字母表到哪个字母例如a-d>>abcd,x-b>>xyzab
        //找出频率最高的字符以及出现次数
        //字符有大小之分但是计数和最后输出都按小写，大写的字母也归并到小写中
        //若最大值相等，输出字母表靠前的一个
        //Map的迭代遍历按key值从小到大遍历的
        /*
        String a="A-Dabc3"
        zipStringCount(a)
         */
        char[] temp = str.toLowerCase().toCharArray();
        List<Character> carr = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            carr.add(temp[i]);
        }
        Map<Character, Integer> map = new HashMap();
        int indexforA = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < carr.size(); i++) {
            char a = carr.get(i);
            if (a < 'a') {
                if (a >= '0' && a <= '9') {
                    int doit = a - '0';
                    doit--;
                    while (doit != 0) {
                        for (int start = indexforA; start < i; start++) {
                            addNum(map, carr.get(start));
                        }
                        doit--;
                    }
                    indexforA = i + 1;
                } else {//'-'
                    char pre = carr.get(i - 1);
                    char aft = carr.get(i + 1);
                    if (carr.get(i - 1) > carr.get(i + 1)) {
                        //从a再开始
                        carr.remove(i);
                        int count = 0;
                        for (int start = (int) pre + 1; start <= (int) 'z'; start++) {
                            carr.add(i + count, (char) start);
                            addNum(map, (char) start);
                            count++;
                        }
                        for (int start = 'a'; start < (int) aft; start++) {
                            carr.add(i + count, (char) start);
                            addNum(map, (char) start);
                            count++;
                        }
                        i += count;
                    } else {
                        carr.remove(i);
                        int count = 0;
                        for (int start = (int) pre + 1; start < (int) aft; start++) {
                            carr.add(i + count, (char) start);
                            addNum(map, (char) start);
                            count++;
                        }
                        i += count;
                    }
                }

            } else {
                addNum(map, a);
            }
        }
        int max = 0;
        char tar = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                tar = entry.getKey();
            }
        }
        System.out.println("" + tar + max);
    }

    public static void addNum(Map<Character, Integer> map, char a) {
        //zipStringCount的计数方法
        if (map.containsKey(a)) {
            int count = map.get(a) + 1;
            map.put(a, count);
        } else {
            map.put(a, 1);
        }
    }


    public static void maxOverlap(int[] start, int[] end) {
        //检测重合区间数量最多的时候，题目转变>>不同的人在不同时间到达和离开房间，求人数最多的时候以及此时的人数
        /*
        int[] a = {1, 2, 10, 5, 5};
        int[] b = {4, 5, 12, 9, 12};
        maxOverlap(a, b);
         */
        Arrays.sort(start);
        Arrays.sort(end);
        int[] total = new int[start.length + end.length];
        boolean[] stats = new boolean[start.length + end.length];
        int i = 0, j = 0, index = 0;
        while (i < start.length && j < end.length) {
            if (start[i] <= end[j]) {
                total[index] = start[i++];
                stats[index++] = true;
            } else {
                total[index] = end[j++];
                stats[index++] = false;
            }
        }
        while (i < start.length) {
            total[index] = start[i++];
            stats[index++] = true;
        }
        while (j < end.length) {
            total[index] = end[j++];
            stats[index++] = false;
        }
        int max = 0, num = 0, maxTime = 0;
        for (int check = 0; check < total.length; check++) {
            if (stats[check]) {
                num++;
            } else {
                num--;
            }
            if (num > max) {
                max = num;
                maxTime = total[check];
            }
        }
        System.out.println(max + " " + maxTime);
    }

}
