/*
finding the shortest path in directed acyclic graph

Input:
6 // no of nodes
10 // no of edges
1 2 1 // source destination weight
1 3 11
2 3 3
2 4 5
2 5 5
3 4 7
3 5 8
6 1 4
6 2 10
4 5 2

Output: shortest distance from source(1) to all the nodes
0 1 4 6 6 99999

 */

package Graphs;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class shortest_path_in_DAG{

    static void shortest_path(Map<Integer,List<int[]>> graph, int n){

        int d[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(d,99999);
        d[0] = 0;
        q.add(0);

        while(q.size()!=0){
            int x = q.remove();
            if(!graph.containsKey(x)){
                continue;
            }
            for(int []i:graph.get(x)){
                if(d[i[0]]>d[x]+i[1]){
                    d[i[0]] = d[x]+i[1];
                }
                q.add(i[0]);
            }

        }

        for(int i=0;i<n;i++){
            System.out.print(d[i]+" ");
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<Integer,List<int[]>> graph = new HashMap<>();

        int n = sc.nextInt();
        int e = sc.nextInt();

        for(int i=0;i<e;i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int w = sc.nextInt();
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
                graph.get(x).add(new int[]{y,w});
            }
            else{
                graph.get(x).add(new int[]{y,w});
            }
        }

        shortest_path(graph,n);

    }
}