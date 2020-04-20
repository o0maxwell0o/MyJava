package com.maxwell.test;

import java.util.Arrays;
import java.util.Scanner;

public class Backpack {

    public static void main(String[] args) {
        /*
        int[] w = {2, 2, 3, 1, 5, 2};
        int[] v = {2, 3, 1, 5, 4, 3};
        pack01(9, w, v);
        System.out.println(maxValue(w, v, 9));
        */
        int[] w = {2, 2, 3, 1, 5, 2};
        int[] v = {2, 3, 1, 5, 4, 3};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pack01(n, w, v);
    }


    /**
     * 01背包问题 将重量为(w1,w2,w3,w4,w5...)、价值为(v1,v2,v3,v4,v5...)的物品放入容量为N的背包中，怎样放价值最大
     * 动态规划：
     * 我们设v[i][j]为放入前i个物品到容量为j的背包中的最大值，i一定是小于物品总个数的，j一定是小于N的
     * 举个例子 v[2][5]表示将前两个物品放入容量为5的背包中的最大价值 v[2][6]表示将前两个物品放入容量为6的背包中的最大价值
     * 则有等式：
     * v[0][j] = v[j][0] = 0
     * v[i][j] = v[i-1][j] w[i]>j
     * v[i][j] = Max(v[i-1][j],v[i-1][j-w[i]]+value[i]) w[i] <= j
     * 暴力求解：
     * 求出物品个数的所有子集，计算每一个子集的价值，选出最大值
     * 例如有4个物品，那么2^4=16个子集，每个子集有四位，每一位是0代表该子集中没有该物品，是1代表有该物品
     * 0 0 0 0 代表该子集中没有任何物品
     * 0 1 0 1 代表该子集中有2号物品和4号物品
     */
    /**
     * 动态规划
     *
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public static int maxValue(int[] weight, int[] value, int capacity) {
        int weightLen = weight.length;
        int valueLen = capacity + 1;//列值长度加1，是因为最后一列要保证重量值为lenColumn
        int maxValue = 0;
        int[][] v = new int[weightLen][valueLen];
        for (int i = 0; i < weightLen; i++) {
            for (int j = 0; j < valueLen; j++) {
                if (i == 0) {
                    v[i][j] = 0;
                } else if (j == 0) {
                    v[i][j] = 0;
                } else {
                    if (weight[i] > j) {
                        v[i][j] = v[i - 1][j];

                    } else if (weight[i] <= j) {
                        v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i]] + value[i]);
                    }
                    maxValue = v[i][j];
                }

            }

        }
        return maxValue;
    }

    /**
     * 01背包-容量压缩
     *
     * @param c      包容量
     * @param weight 各物品质量
     * @param value  各物品价值
     */
    public static void pack01(int c, int[] weight, int[] value) {
        int n = weight.length; //物品数量
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] G = new int[n + 1][c + 1];//作用是标记是否装入，与算法过程无关
        for (int i = 1; i < n + 1; i++) {
            w[i] = weight[i - 1];
            v[i] = value[i - 1];
        }

        //初始化values[0...c]=0————在不超过背包容量的情况下，最多能获得多少价值
        //原因：如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，这个解的价值为0，所以初始时状态的值也就全部为0了
        int[] values = new int[c + 1];
        //初始化values[0]=0，其它全为负无穷————解决在恰好装满背包的情况下，最多能获得多少价值的问题
        //原因：只有容量为0的背包可以什么物品都不装就能装满，此时价值为0，其它容量背包均无合法的解，属于未定义的状态，应该被赋值为负无穷
        /*for (int i = 1; i < values.length; i++) {
            values[i] = MIN;
        }*/

        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                    G[i][t] = 1;
                }
            }
        }
        System.out.println("最大价值为： " + values[c]);
        System.out.print("装入背包的物品编号为： ");
        /*
        输出顺序:逆序输出物品编号
        注意：这里另外开辟数组G[i][v],标记上一个状态的位置
        G[i][v] = 1:表示物品i放入背包了，上一状态为G[i - 1][v - w[i]]
        G[i][v] = 0:表示物品i没有放入背包，上一状态为G[i - 1][v]
        */
        int i = n;
        int j = c;
        while (i > 0) {
            if (G[i][j] == 1) {
                System.out.print(i + " ");
                j -= w[i];
            }
            i--;
        }
        System.out.println();
    }

    public static void completePack() {
        int[] w = {0, 3, 2, 5, 1, 6, 4};
        int[] v = {0, 6, 5, 10, 2, 16, 8};
        int max = 10;
        int[] m = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            m[i] = w[i];
        }
        Arrays.sort(m);
        int q = max / m[1];
        int[] f = new int[q];
        int[][] maxValue = new int[w.length][max + 1];
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < w.length; j++) {
                if (i == 0 || j == 0) {
                    maxValue[j][i] = 0;

                } else {
                    if (i < w[j]) {
                        maxValue[j][i] = maxValue[j - 1][i];

                    } else {

                        for (int k = 1, g = 0;
                             k <= i / w[j];
                             k++, g++) {
                            f[g] = maxValue[j - 1][i - (k * w[j])] + k * v[j];
                        }
                        Arrays.sort(f);
                        int v1 = maxValue[j - 1][i];
                        maxValue[j][i] = Math.max(v1, f[0]);
                        f = new int[q];
                    }
                }
            }
        }
        for (int n = 0;
             n < w.length;
             n++) {
            for (int i = 0;
                 i <= max;
                 i++) {
                System.out.print(maxValue[n][i] + "\t");
            }
            System.out.println();
        }
        System.out.println(maxValue[w.length - 1][max]);

    }
}
