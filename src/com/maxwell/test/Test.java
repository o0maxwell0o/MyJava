package com.maxwell.test;

import com.maxwell.test.dataCode.ch03.MyArrayList;


import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<String> astr = new LinkedList<>();
        System.out.println(letterCombinations(astr, "232", 0));

    }

    public static List<String> letterCombinations(List<String> astr, String digits, int index) {
        if (index == digits.length()) {
            return astr;
        }
        List<String> temp = new LinkedList<>();
        char a = digits.charAt(index);
        char[] putin = {
                'a', 'b', 'c',
                'd', 'e', 'f',
                'g', 'h', 'i',
                'j', 'k', 'l',
                'm', 'n', 'o',
                'p', 'q', 'r', 's',
                't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        int start = 0, end = 0;
        switch (a) {
            case '2':
                start = 0;
                end = 2;
                break;
            case '3':
                start = 3;
                end = 5;
                break;
            case '4':
                start = 6;
                end = 8;
                break;
            case '5':
                start = 9;
                end = 11;
                break;
            case '6':
                start = 12;
                end = 14;
                break;
            case '7':
                start = 15;
                end = 18;
                break;
            case '8':
                start = 19;
                end = 21;
                break;
            case '9':
                start = 22;
                end = 25;
                break;
        }
        if(astr.isEmpty()){
            for (int i = start; i <= end; i++) {
                temp.add(String.valueOf(putin[i]));
            }
        }else{
            for (String old : astr) {
                for (int i = start; i <= end; i++) {
                    temp.add(old + putin[i]);
                }
            }
        }
        astr = temp;
        return letterCombinations(astr, digits, ++index);
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



