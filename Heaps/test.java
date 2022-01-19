/*

The first line contains two integers N & M respectively.

The next M lines contains three integers u, v and w,
denoting that there is an edge of length w between node u and node v.

 */

package Heaps;

import java.util.Scanner;
import java.util.Random;

public class test {

    // function for checking the degree of the node
    public static int[] degree(int[][] graph) {
        int d[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if ((i != j) && (graph[i][j]!=9999)) {
                    d[i] += 1;
                }
            }
        }
        return d;
    }

    // all pair shortest path using floyd warshall algorithm
    public static int[][] floyd_warshall(int[][] dis) {

        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    if ((dis[i][j] > dis[i][k] + dis[k][j]) && (i != j)) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("enter the number of nodes and edges : ");

        int n = sc.nextInt();
        int m = sc.nextInt();

        int graph[][] = new int[n][n];
        int w_graph[][] = new int[n + 2][n + 2];

        int x = 0;
        int y = 0;

        for (int i = 0; i < m; i++) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            int w = sc.nextInt();
            graph[x][y] = w;
            graph[y][x] = w;
        }

        // displaying the graph as adjacency matrix
        System.out.println("\nnormal graph");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0)
                    graph[i][j] = 9999;
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        // creating the wormhole by adding two new nodes
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i < n && j < n)
                    w_graph[i][j] = graph[i][j];
                else
                    w_graph[i][j] = 9999;
            }
        }

        // generating two adjacency nodes randomly for two wormhole end points
        x = r.nextInt(n);
        y = r.nextInt(n);
        while (y == x) {
            y = r.nextInt(n);
        }
        System.out.println("x = " + (x+1));
        System.out.println("y = " + (y+1));

        w_graph[n][x] = 0;
        w_graph[x][n] = 0;

        w_graph[n + 1][x] = 0;
        w_graph[x][n + 1] = 0;

// updating distance of the adjacency nodes of the generated nodes with the wormhole end points
        for (int i = 0; i < n; i++) {
            if (graph[x][i] != 9999) {
                w_graph[n][i] = 0;
                w_graph[i][n] = 0;
            }
            if (graph[y][i] != 9999) {
                w_graph[n + 1][i] = 0;
                w_graph[i][n + 1] = 0;
            }
        }

        // displaying the graph after adding wormhole as adjacency matrix
        System.out.println("\nworm hole graph : ");
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                System.out.print(w_graph[i][j] + " ");
            }
            System.out.println();
        }

        int deg[] = degree(graph);
        int dis[][] = floyd_warshall(graph);

        System.out.println("\ndegree before worm hole : ");
        for (int i = 0; i < deg.length; i++) {
            System.out.print(deg[i] + " ");
        }
        System.out.println();

        System.out.println("\ndistances before worm hole : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }

        deg = degree(w_graph);
        int[][] dis1 = floyd_warshall(w_graph);
        int flag = 0;

        System.out.println("\ndegree after worm hole : ");
        for (int i = 0; i < deg.length; i++) {
            System.out.print(deg[i] + " ");
        }
        System.out.println();

        System.out.println("\ndistances after worm hole : ");
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if ((i < n && j < n) && (graph[i][j] > w_graph[i][j])) {
                    flag += 1;
                }
                System.out.print(w_graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        if (flag != 0) {
            System.out.println("Worm Hole");
        } else {
            System.out.println("NO Worm Hole");
        }

    }
}


