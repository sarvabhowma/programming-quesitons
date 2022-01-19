/*
finding path between the given nodes in a directed graph

Input:
3 // nodes
3 // edges
1 2
2 3
3 1
1 // source
3 // destination

Output:
{1=[2], 2=[3], 3=[1]}
3 2 1 // path in reverse

 */
package Graphs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class finding_path{

    static void path(Map<Integer,List<Integer>> graph, int s, int d, int n){

        int v[] = new int[n];// visited nodes
        int prev[] = new int[n];// previous node
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        v[s-1] = 1;
        Arrays.fill(prev,-1);

        while(q.size()!=0){
            int x = q.remove();
            if(!graph.containsKey(x)){
                continue;
            }
            for(int i: graph.get(x)){
                if(v[i-1]==0){
                    q.add(i);
                    prev[i-1] = x;
                    v[i-1] = 1;
                }
                if(i == d){
                    break;
                }
            }

        }

        if(v[d-1]==1){
            System.out.print(d+" ");
            while(prev[d-1] !=-1){
                System.out.print(prev[d-1]+" ");
                d = prev[d-1];
            }
        }
        else{
            System.out.println("no path between source and destination");
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int n = sc.nextInt();// no of nodes
        int e = sc.nextInt();// no of edges

        for(int i=0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
                graph.get(x).add(y);
            }
            else{
                graph.get(x).add(y);
            }

        }
        int s = sc.nextInt();
        int d = sc.nextInt();

        System.out.println("\n"+graph);
        path(graph,s,d,n);

    }
}


