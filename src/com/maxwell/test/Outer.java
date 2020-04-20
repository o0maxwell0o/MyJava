package com.maxwell.test;

public class Outer {
    public String name = "outer";
    class Inner {
        String name = "inner";
        public void show() {
            String name = "show";
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Outer.this.name);
        }

    }
    public static void main(String[] args) {
        Inner inner = new Outer().new Inner();
        inner.show();
    }
}
