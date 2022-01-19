/*
minimum spanning tree using prims algorithm

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
previous node : 1, distance : 0
previous node : 1, distance : 1
previous node : 2, distance : 4
previous node : 2, distance : 6
previous node : 3, distance : 5
previous node : 1, distance : 4

 */

package Graphs;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class prims {

    static void spanning_tree(Map<Integer, List<int[]>> graph, int n) {

        int prev[] = new int[n];
        int d[] = new int[n];
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        List<Integer> l = new ArrayList<>();

        Arrays.fill(d, 9999);
        Arrays.fill(prev, -1);

        int s = 0;// source
        d[s] = 0;
        prev[0] = 0;

        while (true) {

            for (int i[] : graph.get(s)) {
                if (d[i[0]] > d[s] + i[1]) {
                    d[i[0]] = d[s] + i[1];
                    q.add(new int[]{i[0], d[i[0]]});
                    prev[i[0]] = s;
                }
            }

            if (q.size() != 0) {
                s = q.remove()[0];
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("previous node : " + (prev[i] + 1) + ", distance : " + d[i]);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int n = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int w = sc.nextInt();
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
                graph.get(x).add(new int[]{y, w});
            } else {
                graph.get(x).add(new int[]{y, w});
            }

            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
                graph.get(y).add(new int[]{x, w});
            } else {
                graph.get(y).add(new int[]{x, w});
            }
        }

        spanning_tree(graph, n);

    }
}

