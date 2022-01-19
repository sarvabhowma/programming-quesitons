/*
shortest path using bellman ford

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
source : 1

Output:
0 1 4 6 5 4

 */

package Graphs;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class bellman_ford{

    static class edge{
        int s,d,w;
        edge(int x,int y, int z){
            s = x;
            d = y;
            w = z;
        }
    }

    static void shortest_path(List<edge> graph, int n, int s){

        int d[] = new int[n+1];
        Arrays.fill(d,99999);
        d[s] = 0;

        for(int i=1;i<n;i++){
            for(edge e: graph){
                if(d[e.d]>d[e.s]+e.w){
                    d[e.d] = d[e.s]+e.w;
                }
                if(d[e.s]>d[e.d]+e.w){
                    d[e.s] = d[e.d]+e.w;
                }
            }
        }

// nth time for checking negative cycles

        for(edge e: graph){
            if(d[e.d]>d[e.s]+e.w){
                System.out.println("negative cycle present");
                return;
            }
            if(d[e.s]>d[e.d]+e.w){
                System.out.println("negative cycle present");
                return;
            }
        }

        for(int i=1;i<=n;i++){
            System.out.print(d[i]+" ");
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<edge> graph = new ArrayList<>();
        int n = sc.nextInt();
        int e = sc.nextInt();

        for(int i=0;i<e;i++){
            graph.add(new edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        System.out.print("source : ");
        int s = sc.nextInt();

        shortest_path(graph,n,s);

    }
}
