package com.maxwell.test;


public class ExtendsImplements {
    public static void main(String[] args) {
        System.out.println("------SubClass 类继承------");
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(100);
        System.out.println("------SubClass2 类继承------");
        SubClass2 sc3 = new SubClass2();
        SubClass2 sc4 = new SubClass2(200);

        System.out.println("------super和this------");
        Animal a = new Animal();
        a.eat();
        Dog d = new Dog();
        d.eatTest();
    }
}

class Animal {
    void eat() {
        System.out.println("animal : eat");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("dog : eat");
    }

    void eatTest() {
        this.eat();   // this 调用自己的方法
        super.eat();  // super 调用父类方法
    }
}

class SuperClass {
    private int n;

    SuperClass() {
        System.out.println("SuperClass()");
    }

    SuperClass(int n) {
        System.out.println("SuperClass(int n)" + n);
        this.n = n;
    }
}

// SubClass 类继承
class SubClass extends SuperClass {
    private int n;

    SubClass() { // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n) {
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):" + n);
        this.n = n;
    }
}

// SubClass2 类继承
class SubClass2 extends SuperClass {
    private int n;

    SubClass2() {
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n) { // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):" + n);
        this.n = n;
    }
}
