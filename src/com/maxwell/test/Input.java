package com.maxwell.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//next以及其他nextInt等对于有效符之后的回车符不会处理，
//nextLine一直读到回车符结束，并且删除回车符
//nextLine之前使用过next等方法一定要注意回车
//多加一条nextLine使其跳过回车符
public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int dist = sc.nextInt();
            String s = sc.next();
            if (dist < 11) {
                System.out.println("NO");
                break;
            }
            boolean re = false;
            int count = 0;
            while (dist > 0) {
                Object s1 = s.subSequence(0, 1);
                if (s1.equals("8")) {
                    count += 1;
                }
                s = s.substring(1);
                dist -= 1;
            }
            if (count >= 8) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
/*1
public class Input {
    public static void loop() {
        //  Input:  3 3
        //          1 3 2 4 5 6         第一个数组长度为3，第二个数组长度为3
        //  Output: 1 2 3 4 5 6         合并排序后输出
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();        //输入第一个集合的长度
            int k = input.nextInt();       //输入第二个集合的长度
            int[] arr = new int[n + k];
            HashSet<Integer> temp = new HashSet<Integer>();
            for (int i = 0, len = n + k; i < len; i++) {
                temp.add(input.nextInt());              //输入集合各个元素，这里直接放入hashset了
            }
            Integer[] result = new Integer[temp.size()]; //hashset
            temp.toArray(result);
            Arrays.sort(result);                         //输出要求从小到大
            for (int x : result) {
                System.out.print(x + " ");
            }
        }

    }

    //输入一个整数
    public void anInt() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个整数： ");
        int number = sc.nextInt();

        System.out.println("输入的数字是： " + number);
    }

    //输入一个浮点数
    public void aDouble() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个浮点数： ");
        double number = sc.nextDouble();
        System.out.println("输入的数字是： " + number);

    }

    //输入一行字符,并根据字符做相应的动作
    public void aLine() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一行字符：");
        String aline = sc.nextLine();
        char[] word = aline.toCharArray();

        for (int i = 0; i < aline.length(); i++) {
            switch (word[i]) {
                case ('w'): {
                    System.out.print("输入的字符是： w ");
                    break;
                }
                case ('s'): {
                    System.out.println("输入的字符是： s");
                    break;
                }
                case ('a'): {
                    System.out.println("输入的字符是： a");
                    break;
                }
                case ('d'): {
                    System.out.println("输入的字符是： d");
                    break;
                }
                default: {
                    System.out.println("输入了其它字符");
                }
            }
        }
    }

    //输入一行整数，这种情况是最常见的，需要进行类型转换
    public void aLineInt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一行整数使用空格分离：");
        String aline = sc.nextLine();

        ArrayList alinenumber = new ArrayList();//转换成整型放到
        int pre = 0;//扫描指针
        int i = 0;
        int temp = 0;
        for (i = 0; i < aline.length(); i++) {
            if (aline.charAt(i) == ' ') {
                temp = Integer.parseInt(aline.substring(pre, i));
                alinenumber.add(temp);
                pre = i + 1;
            }
        }
        temp = Integer.parseInt(aline.substring(pre, i));//跳出循环时可能还有一个数字
        alinenumber.add(temp);

        System.out.print("输入的数字序列：");
        for (i = 0; i < alinenumber.size(); i++)
            System.out.print((int) alinenumber.get(i) + " ");
        System.out.println();
    }

    //输入一行浮点数，需要进行类型转换
    public void aLineDouble() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一行浮点数使用空格分离：");
        String aline = sc.nextLine();

        ArrayList alinenumber = new ArrayList();//转换成整型放到
        int pre = 0;//扫描指针
        int i = 0;
        double temp = 0;
        for (i = 0; i < aline.length(); i++) {
            if (aline.charAt(i) == ' ') {
                temp = Double.parseDouble(aline.substring(pre, i));
                alinenumber.add(temp);
                pre = i + 1;
            }
        }
        temp = Double.parseDouble(aline.substring(pre, i));//跳出循环时可能还有一个数字
        alinenumber.add(temp);

        System.out.print("输入的浮点数为：");
        for (i = 0; i < alinenumber.size(); i++)
            System.out.print((Double) alinenumber.get(i) + " ");
        System.out.println();
    }

    //输入一个整数矩阵，矩阵的长度和宽度不确定，可以用于输入n*n的矩阵
    public void aMatrix() {
        Scanner sc = new Scanner(System.in);
        ArrayList matrix = new ArrayList();//整个矩阵
        ArrayList alinelist;//每一列
        int length = 0;//一列的长度

        System.out.println("请输入一个矩阵：");
        //获得下一行
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.equals(""))//输入空行则完成输入，退出循环
                break;

            alinelist = new ArrayList();

            int pre = 0;//扫描指针
            int i = 0;
            int temp = 0;
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    temp = Integer.parseInt(str.substring(pre, i));
                    alinelist.add(temp);
                    pre = i + 1;
                }
            }
            temp = Integer.parseInt(str.substring(pre, i));
            alinelist.add(temp);
            matrix.add(alinelist);

            if (length < alinelist.size())
                length = alinelist.size();
        }
        //复制到数组中
        int array[][] = new int[matrix.size()][length];
        //调用函数计算数量

        for (int i = 0; i < matrix.size(); i++) {
            alinelist = (ArrayList) matrix.get(i);
            for (int j = 0; j < alinelist.size(); j++) {
                array[i][j] = (int) alinelist.get(j);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Input test = new Input();
        loop();
        System.out.println("Hello");
    }

}

 */
