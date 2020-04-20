package com.maxwell.test;

import java.util.Stack;

public class Base {
    public static void main(String[] args) {
        String s = "((1+(2+3))*(4*5))";
        char[] result = s.toCharArray();
        result(result);
    }

    //判断是否是质数（素数）
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //运用埃拉托色筛选法筛选出所有小于等于n的质数
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        //初始化，默认所有都是质数
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        //筛选，将所有质数的倍数都标记为非质数(最初只知道2是质数)
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = 2; j <= n / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

    //牛顿迭代法求平方根和立方根
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    //判断是否是回文
    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //Dijkstra的双栈算术表达式求值
    public static void result(char[] num) {
        Stack<Character> ops = new Stack<Character>();
        Stack<Double> vals = new Stack<Double>();
        for (char e : num) {
            if (e == '(') ;
            else if (e == '+') ops.push(e);
            else if (e == '-') ops.push(e);
            else if (e == '*') ops.push(e);
            else if (e == '/') ops.push(e);
            else if (e == ')') {
                char op = ops.pop();
                double val = vals.pop();
                if (op == '+') val = vals.pop() + val;
                else if (op == '-') val = vals.pop() - val;
                else if (op == '*') val = vals.pop() * val;
                else if (op == '/') val = vals.pop() / val;
                vals.push(val);
            } else {
                double number = Character.getNumericValue(e);
                vals.push(number);
            }

        }
        System.out.println(vals.pop());
    }
}

