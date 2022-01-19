/*
minimum spanning tree using kruskal algorithm

Input:
6 // no of nodes
10 // no of edges
1 2 1 // source destination weight
1 3 11
2 3 3
2 4 5
2 5 5
3 4 7
3 5 1
6 1 4
6 2 10
4 5 2

Output:
s : 1, d : 2, w : 1
s : 3, d : 5, w : 1
s : 4, d : 5, w : 2
s : 2, d : 3, w : 3
s : 6, d : 1, w : 4

 */
package Graphs;

import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class kruskal {

    static class edge {
        int s = 0;
        int d = 0;
        int w = 0;

        edge(int x, int y, int z) {
            s = x;
            d = y;
            w = z;
        }
    }

    static int parent(int x,int[] v){
        if(v[x]==x){
            return x;
        }
        return parent(v[x],v);
    }

    static void spanning_tree(List<edge> graph, int n) {

        List<edge> st = new ArrayList<>();
        PriorityQueue<edge> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));

        q.addAll(graph);
        int v[] = new int[n + 1];
        for(int i=1;i<n;i++){
            v[i] = i;
        }

        while (q.size() != 0) {
            edge e = q.remove();
            int x = parent(e.s,v);
            int y = parent(e.d,v);
            if(x==y){
                continue;
            }
            v[Math.max(x,y)] = Math.min(x,y);
            st.add(e);
        }
        System.out.println();
        for (edge e : st) {
            System.out.println("s : " + e.s + ", d : " + e.d + ", w : " + e.w);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<edge> graph = new ArrayList<>();
        int n = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            graph.add(new edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        spanning_tree(graph, n);

    }
}