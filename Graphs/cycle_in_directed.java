/*
checking cycle in directed graph

Input:
6
7
1 2
1 3
2 4
4 3
3 5
5 6
6 3

Output:
found cycle : 3, 6

 */
package Graphs;

import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class cycle_in_directed{

    static void checking_cycle(Map<Integer,List<Integer>> graph,int n){

        int v[] = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        v[0] = 1;

        while(s.size()!=0){
            int x = s.peek();
            int count = 0;

            if(!graph.containsKey(x)){
                s.pop();
                continue;
            }

            for(int i:graph.get(x)){
                if(v[i]==0){
                    s.push(i);
                    v[i] = 1;
                    count++;
                }
                else{
                    System.out.println("found cycle : "+(i+1)+", "+(x+1));
                    return;
                }
            }
            if(count==0){
                s.pop();
            }
            else{
                graph.get(x).remove(0);
            }

        }

        System.out.println("no cycle found");

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int n = sc.nextInt();
        int e = sc.nextInt();

        for(int i=0;i<e;i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
                graph.get(x).add(y);
            }
            else{
                graph.get(x).add(y);
            }
        }

        checking_cycle(graph,n);

    }
}
