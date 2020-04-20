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
