package com.maxwell.test;



public class ParentClassReferencePointingToChildClassObject {
    public static void main(String[] args)   {
        big a = new big();
        big b = new small();
        small c = new small();
        a.move();
        b.move();
        c.talk();
    }
}

class big {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class small extends big {
    public void move() {
        System.out.println("狗可以跑和走");
    }

    public void talk() {
        System.out.println("aaa");
    }
}

