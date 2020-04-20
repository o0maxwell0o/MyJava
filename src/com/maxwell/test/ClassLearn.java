package com.maxwell.test;
/*
第一个规则:子类的构造过程中，必须调用其父类的构造方法。一个类，如果我们不写构造方法，那么编译器会帮我们加上一个默认的构造方法(就是没有参数的构造方法)，但是如果你自己写了构造方法，那么编译器就不会给你添加了，所以有时候当你 new一个子类对象的时候，肯定调用了子类的构造方法，但是如果在子类构造方法中我们并没有显示的调用基类的构造方法，如:super(); 这样就会调用父类没有参数的构造方法。

第二个规则:如果子类的构造方法中既没有显示的调用基类构造方法，而基类中又没有无参的构造方法，则编译出错，所以，通常我们需要显示的:super(参数列表)，来调用父类有参数的构造函数，此时无参的构造函数就不会被调用。

总之，一句话:
子类没有显示调用父类构造函数，不管子类构造函数是否带参数都默认调用父类无参的构造函数，若父类没有则编译出错。

 */
public class ClassLearn {
    public static void main(String[] args) {
        System.out.println("------ main start ------ ");
        new SonClass1();
        System.out.println("------ main end ------ ");
        System.out.println("------ main start ------ ");
        new SonClass2("fei");
        System.out.println("------ main end ------ ");
        //ParentClass1和SonClass1、ParentClass2和SonClass2关于继承关系以及载入内容的先后顺序
        Base base = new Sub();

        VariantTest v = new VariantTest();
        v = new VariantTest();
        v = new VariantTest();
        //类的所有对象共享静态变量或者叫类变量、有自己的成员变量或者叫实例变量
        new SonSuper();
    }

    public static class ParentClass1 {
        public ParentClass1() {
            System.out.println("ParentClass's constructor");
        }

        {
            System.out.println("ParentClass's block");
        }

        static {
            System.out.println("ParentClass's static block ");
        }
    }

    public static class SonClass1 extends ParentClass1 {
        public SonClass1() {
            System.out.println("SonClass's constructor");
        }

        {
            System.out.println("SonClass's block");
        }

        static {
            System.out.println("SonClass's static block ");
        }

    }

    public static class ParentClass2 {
        String name;

        public ParentClass2() {
            System.out.println("3");
        }

        public ParentClass2(String name) {
            System.out.println("4");
            this.name = name;
        }
    }

    public static class SonClass2 extends ParentClass2 {
        ParentClass2 parentClass;

        public SonClass2() {
            System.out.println("1");
        }

        public SonClass2(String name) {
            System.out.println("2");
            this.name = name;
            parentClass = new ParentClass2("FEI");
        }
    }

    public static class Base {

        private String baseName = "base";
        private static String testName = "TestBase";

        public Base() {
            callName();
        }

        public void callName() {
            System.out.println(baseName);
        }
    }

    public static class Sub extends Base {

        private String baseName = "sub";
        private static String testName = "TestSub";

        public void callName() {
            System.out.println(baseName);
            System.out.println(testName);
        }


    }

    public static class VariantTest {

        public static int staticVar = 0;
        public int instanceVar = 0;

        public VariantTest() {
            staticVar++;
            instanceVar++;
            System.out.println("staticVar=" + staticVar + ",instanceVar=" + instanceVar);
        }
    }

    public static class FatherSuper {
        public FatherSuper() {
            System.out.println("父类空");
        }

        public FatherSuper(int i) {
            System.out.println("父类i=" + i);
        }

    }

    public static class SonSuper extends FatherSuper {
        public SonSuper() {
            super(2);
            System.out.println("Son");
        }
    }
}
