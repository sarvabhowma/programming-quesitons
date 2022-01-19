/*
shortest path using dijkstra algorithm

Input:
6
10
1 2 1
1 3 11
2 3 3
2 4 5
2 5 5
3 4 7
3 5 1
6 1 4
6 2 10
4 5 2
enter source : 1
enter destination : 5

Output:
shortest distance is = 5

 */
package Graphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class dijkstra {

    static class edge {
        int p;
        int w;

        edge(int x, int y) {
            p = x;
            w = y;
        }
    }

    static void shortest_path(Map<Integer, List<edge>> graph, int n, int s, int d) {

        PriorityQueue<edge> q = new PriorityQueue<>(Comparator.comparing(o -> o.w));
        int dis[] = new int[n + 1];

        Arrays.fill(dis, 99999);
        dis[s] = 0;

        while (s != d) {

            for (edge e : graph.get(s)) {
                if (dis[e.p] > dis[s] + e.w) {
                    dis[e.p] = dis[s] + e.w;
                    q.add(new edge(e.p, dis[e.p]));
                }
            }

            if (q.size() != 0) {
                s = q.remove().p;
            }
        }

        System.out.println("shortest distance is = " + dis[d]);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Integer, List<edge>> graph = new HashMap<>();
        int n = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(new edge(y, w));
            graph.get(y).add(new edge(x, w));
        }

        System.out.print("enter source : ");
        int s = sc.nextInt();

        System.out.print("enter destination : ");
        int d = sc.nextInt();

        shortest_path(graph, n, s, d);

    }
}

