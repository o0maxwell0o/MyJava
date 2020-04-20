package com.maxwell.test.structure;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;  //结点个数vertices

    private LinkedList<Integer> adj[];  //领接链表

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();  //为每一个结点创建一个链表来存储边的连接情况
        }
    }

    void addEdge(int start, int end) {  //添加边
        adj[start].add(end);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);//4个结点0,1,2,3
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(2);//从结点2开始
    }


    void DFSUtil(int v, boolean visited[]) {//深度优先搜索DFS
        visited[v] = true;
        System.out.print(v + " ");

        //访问当前结点所有邻接节点
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v) {//为深度优先搜索做初始化准备
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
}
