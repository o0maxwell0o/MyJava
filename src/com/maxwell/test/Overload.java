package com.maxwell.test;


//1. 重载方法参数必须不同（三个里面至少满足一个）：
//        参数个数不同，如method(int x)与method(int x,int y)不同
//        参数类型不同，如method(int x)与method(double x)不同g
//        参数顺序不同，如method(int x,double y)与method(double x,int y)不同
//2. 重载只与方法名与参数类型相关与返回值无关
//        如void method(int x)与int method(int y)不是方法重载，不能同时存在
//3. 重载与具体的变量标识符无关
//        如method(int x)与method(int y)不是方法重载，不能同时存在
public class Overload {
    static int add(int a, int b) {
        return a + b;

    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        double d = 1.2, e = 3.2;
        System.out.println(add(a, b));
        System.out.println(add(a, b, c));
        System.out.println(add(d, e));

    }
}
