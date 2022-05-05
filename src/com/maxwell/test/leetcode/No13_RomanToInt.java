package com.maxwell.test.leetcode;

public class No13_RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("IL"));
        System.out.println(romanToInt_Fix("IL"));
    }

    public static int romanToInt_Fix(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public static int romanToInt(String s) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (temp == 0) {
                temp = getValue(s.charAt(i));
            } else {
                int now = getValue(s.charAt(i));
                if (now == temp) {
                    sum += 2 * temp;
                    temp = 0;
                } else if (temp > now) {
                    sum += temp;
                    temp = now;
                } else {
                    if ((now == 5 || now == 10) && temp == 1) {
                        sum = sum - temp + now;
                        temp = 0;
                    } else if ((now == 50 || now == 100) && temp == 10) {
                        sum = sum - temp + now;
                        temp = 0;
                    } else if ((now == 500 || now == 1000) && temp == 100) {
                        sum = sum - temp + now;
                        temp = 0;
                    } else {
                        sum += temp;
                        temp = now;
                    }
                }
            }
        }
        if (temp != 0) {
            sum += temp;
        }
        return sum;

    }

    public static int getValue(char A) {
        int result = 0;
        switch (A) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
                break;
        }
        return result;
    }
}
