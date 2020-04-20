package com.maxwell.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    /*
    反射机制。
    可以在程序运行时加载，探知和使用编译期间完全未知的类，
    并且可以生成相关类对象实例，从而可以调用其方法或则改变某个属性值。

    在Java程序中许多对象在运行是都会出现两种类型：编译时类型和运行时类型。
    编译时的类型由声明对象时实用的类型来决定，运行时的类型由实际赋值给对象的类型决定
    Person p=new Student();
    其中编译时类型为Person，运行时类型为Student。
    除此之外，程序在运行时还可能接收到外部传入的对象，该对象的编译时类型为Object,
    但是程序有需要调用该对象的运行时类型的方法。为了解决这些问题，程序需要在运行时发现对象和类的真实信息。
    然而，如果编译时根本无法预知该对象和类属于哪些类，程序只能依靠运行时信息来发现该对象和类的真实信息，
    此时就必须使用到反射了。
     */
    public static void main(String[] args) {
        try {
            //获取Person类的Class对象
            Class clazz = Class.forName("com.maxwell.test.Person");

            //获取Person类的所有方法信息
            Method[] method = clazz.getDeclaredMethods();
            System.out.println("getDeclareMethods: " + method.length);
            for (Method m : method) {
                System.out.println(m.toString());
            }
            method = clazz.getMethods();
            System.out.println("getMethods: " + method.length);
            for (Method m : method) {
                System.out.println(m.toString());
            }

            //获取Person类的所有成员属性信息
            Field[] field = clazz.getDeclaredFields();
            System.out.println("getDeclaredFields: " + field.length);
            for (Field f : field) {
                System.out.println(f.toString());
            }
            field = clazz.getFields();
            System.out.println("getFields " + field.length);
            for (Field f : field) {
                System.out.println(f.toString());
            }

            //获取Person类的所有构造方法信息
            Constructor[] constructor = clazz.getDeclaredConstructors();
            System.out.println("getDeclaredConstructors: " + constructor.length);
            for (Constructor c : constructor) {
                System.out.println(c.toString());
            }
            constructor = clazz.getConstructors();
            System.out.println("getConstructors " + constructor.length);
            for (Constructor c : constructor) {
                System.out.println(c.toString());
            }

            //
            //获取Person类的Class对象
            Class clazzTest = Class.forName("com.maxwell.test.Person");
            /**
             * 第一种方法创建对象
             */
            //创建对象
            Person p = (Person) clazzTest.newInstance();
            //设置属性
            p.setName("张三");
            p.setAge(16);
            p.setGender("男");
            System.out.println(p.toString());

            /**
             * 第二种方法创建
             */
            //获取构造方法
            Constructor c = clazzTest.getDeclaredConstructor(String.class, String.class, int.class);
            //创建对象并设置属性
            Person p1 = (Person) c.newInstance("李四", "男", 20);
            System.out.println(p1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
