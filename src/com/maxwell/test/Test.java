package com.maxwell.test;


import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int m = 1; m <= c; m++) {
                    for (int n = 1; n <= d; n++) {
                        if (i < j) {
                            if ((j - i) % 3 == 0) {
                                if ((j + m) % 5 == 0) {
                                    if ((i * m) % 4 == 0) {
                                        if (check(i, n)) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        } else {
                            if ((i - j) % 3 == 0) {
                                if ((j + m) % 5 == 0) {
                                    if ((i * m) % 4 == 0) {
                                        if (check(i, n)) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }

    public static boolean check(int aa, int bb) {
        int k = 0;
        if (aa < bb) {
            int t = 0;
            t = aa;
            aa = bb;
            bb = t;
        }
        while (bb != 0) {
            k = aa % bb;
            aa = bb;
            bb = k;
        }
        if (aa == 1) {
            return true;
        } else {
            return false;
        }

    }

}

            /*
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<Integer, Integer> mapping : list) {
                System.out.println(mapping.getKey() + ":" + mapping.getValue());
            }
            */

/*
    public void depthFirst() {
        Stack<Map<String, Object>> nodeStack = new Stack<Map<String, Object>>();
        Map<String, Object> node = new HashMap<String, Object>();
        nodeStack.add(node);
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            System.out.println(node);
            //获得节点的子节点，对于二叉树就是获得节点的左子结点和右子节点
            List<Map<String, Object>> children = getChildren(node);
            if (children != null && !children.isEmpty()) {
                for (Map child : children) {
                    nodeStack.push(child);
                }
            }
        }
    }
//节点使用Map存放

    public void breadthFirst() {
        Deque<Map<String, Object>> nodeDeque = new ArrayDeque<Map<String, Object>>();
        Map<String, Object> node = new HashMap<String, Object>();
        nodeDeque.add(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.peekFirst();
            System.out.println(node);
            //获得节点的子节点，对于二叉树就是获得节点的左子结点和右子节点
            List<Map<String, Object>> children = getChildren(node);
            if (children != null && !children.isEmpty()) {
                for (Map child : children) {
                    nodeDeque.add(child);
                }
            }
        }
    }
//这里使用的是双端队列，和使用queue是一样的
*/



