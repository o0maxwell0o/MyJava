package com.maxwell.test.structure;

public class DataStructure {
    private static class Node<Item> {
        Item item;
        Node next;

    }

    public static void main(String[] args) {
        Node first = new Node();
        first.item = 1;
        Node second = new Node();
        second.item = "be";
        first.next = second;
        System.out.println(first.next.item);
    }
}

