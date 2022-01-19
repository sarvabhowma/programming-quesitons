/*
checking whether the graph is biparite or not

Input:
4
4
1 2
3 2
1 4
3 4

Output:
biparite

 */
package Graphs;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class biparite{

    static void check(Map<Integer,List<Integer>> graph, int n){

        Map<Integer,Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        s.push(0);
        m.put(0,1);

        while(s.size()!=0){
            int x = s.peek();
            int count =0;
            if(!graph.containsKey(x)){
                continue;
            }
            for(int i:graph.get(x)){
                if(!m.containsKey(i)){
                    m.put(i,(m.get(x)==1?0:1));
                    s.push(i);
                }
                else if(m.get(x)==m.get(i)){
                    System.out.println("not biparite");
                    return;
                }
                else{
                    s.push(i);
                }
                count++;
            }
            if(count==0){
                s.pop();
            }
            else{
                graph.get(x).remove(0);
                graph.get(s.peek()).remove(new Integer(x));
            }
        }
        System.out.println("biparite");

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        Map<Integer,List<Integer>> graph = new HashMap<>();

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

            if(!graph.containsKey(y)){
                graph.put(y,new ArrayList<>());
                graph.get(y).add(x);
            }
            else{
                graph.get(y).add(x);
            }
        }

        check(graph,n);

    }
}