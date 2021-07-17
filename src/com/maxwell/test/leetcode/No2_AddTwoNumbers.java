package com.maxwell.test.leetcode;

/**
 * @author usonc016
 * @date 2021/7/17 17:14
 */
public class No2_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        ListNode result = addTwoNumbers(listNode11, listNode21);
        while (result != null) {
            System.out.println(result.val);
            result = result.next != null ? result.next : null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        while (a != null || b != null || carry != 0) {
            int sum = carry;
            sum += a != null ? a.val : 0;
            sum += b != null ? b.val : 0;
            carry = sum / 10;
            if (head == null) {
                // 初始
                head = new ListNode(sum % 10);
                current = head;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            a = a.next != null ? a.next : null;
            b = b.next != null ? b.next : null;
        }
        return head;
    }
}
