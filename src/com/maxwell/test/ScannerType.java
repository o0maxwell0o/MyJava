package com.maxwell.test;

import java.util.Scanner;

public class ScannerType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // NextLine
        if (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(str);
        }
        // Next
        if (sc.hasNext()) {
            String str = sc.next();
            System.out.println(str);
        }
        // NextInt NextFloat
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (sc.hasNextInt()) {
            // 判断输入的是否是整数
            i = sc.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (sc.hasNextFloat()) {
            // 判断输入的是否是小数
            f = sc.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        double sum = 0;
        int m = 0;
        System.out.println("输入数值求和与平均值，输入非数字结束");
        while (sc.hasNextDouble()) {
            double x = sc.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));

    }
}
