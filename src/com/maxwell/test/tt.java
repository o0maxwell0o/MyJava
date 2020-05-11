package com.maxwell.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class tt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int col = k / n;
        int vol = k % n;
        int pair1 = 0;
        int pair2 = 0;
        if (vol > 0) {
            vol--;
            pair1 = list.get(col);
            pair2 = list.get(vol);
        } else {
            col--;
            pair1 = list.get(col);
            pair2 = list.get(list.size() - 1);
        }
        System.out.println("(" + pair1 + "," + pair2 + ")");

    }
}


/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        String[] dic = new String[n];
        for (int i = 0; i < n; i++) {
            dic[i] = sc.nextLine();
        }
        System.out.println(help(str, dic, 0, 0));
    }

    public static int help(String str, String[] dic, int count, int index) {
        if (index == str.length()) {
            ++count;
        } else {
            for (int i = 0; i < dic.length; i++) {
                if (index + dic[i].length() <= str.length() && dic[i].equals(str.substring(index, index + dic[i].length()))) {
                    index += dic[i].length();
                    help(str, dic, count, index);
                }
            }
        }
        return count;
    }
}
 */

/*
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> store = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            String order = sc.nextLine();
            String[] sub = order.split(" ");
            if (sub[0].equals("1")) {
                if (index == 0 || store.isEmpty()) {
                    store.add(index, sub[1]);
                } else {
                    String newstr = store.get(index-1) + sub[1];
                    store.add(newstr);
                }
                op.add(1);
                index++;
            } else if (sub[0].equals("2")) {
                String temp = store.get(index-1);
                String newstr = temp.substring(0, temp.length() - Integer.valueOf(sub[1]));
                store.add(newstr);
                op.add(2);
                index++;
            } else if (sub[0].equals("3")) {
                System.out.println(store.get(index - 1).charAt(Integer.valueOf(sub[1]) - 1));

            } else if (sub[0].equals("4")) {
                for (int j = index-1; j >= 0; j--) {
                    if(op.get(j).equals(1)||op.get(j).equals(2)){
                        index=j;
                        break;
                    }
                }
            }
        }
    }
}
 */
/*
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] astr = str.toCharArray();
        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] op = sc.nextLine().split(" ");
            if (op[0].equals("2")) {
                int start = Integer.valueOf(op[1]) - 1;
                int end = Integer.valueOf(op[2]) - 1;
                List<Character> check = new ArrayList<>();
                for (int j = start; j <= end; j++) {
                    if (check.contains(astr[j])) {

                    } else {
                        check.add(astr[j]);
                    }
                }
                System.out.println(check.size());

            } else {
                char[] temp = op[2].toCharArray();
                astr[Integer.valueOf(op[1])-1] = temp[0];
            }
        }
    }
}
 */
