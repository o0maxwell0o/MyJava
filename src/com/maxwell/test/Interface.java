package com.maxwell.test;

import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            System.out.println(i);
        }

        TestG<Integer> gInteger = new TestG<Integer>(123);
        TestG<Number> gNumber = new TestG<Number>(456);
        showKeyValue1(gInteger);
        showKeyValue1(gNumber);

    }

    public static void showKeyValue1(TestG<?> obj) {
        System.out.println("key value is" + obj.getKey());
    }

    public static class TestG<T> {
        private T key;

        public TestG(T i) {
            this.key = i;
        }

        public T getKey() {
            return key;
        }
    }

    public interface Generator<T> {
        public T next();
    }

    class FruitGenerator<T> implements Generator<T> {
        @Override
        public T next() {
            return null;
        }
    }
}
