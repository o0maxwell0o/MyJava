package com.maxwell.test;

import java.util.ArrayList;
import java.util.List;

public class Count3out {
    public static void main(String[] args) {
        //50个人，从第一个人开始数，数到3的人出列
        //countThree(5, 0, 3);
        yuesefu(5, 3);
    }

    /**
     * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
     * 从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，
     * 数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
     *
     * @param n     人的总数
     * @param start 开始报数的序号，start < n
     * @param m     出列的标记(可以大于n)
     */
    public static void countThree(int n, int start, int m) {
        List<Integer> list = new ArrayList<Integer>();
        //初始化列表
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        while (list.size() > 0) {
            //将前连个移入列表尾端
            for (int j = 0; j < m - 1; j++) {
                list.add(list.remove(start));
            }
            //打印出列的序号
            System.out.println(list.remove(start));
        }
    }

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
