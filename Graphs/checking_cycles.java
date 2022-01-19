/*
checking whether there is cycle is present or not
using union-find algorithm
Input:
5
5
1 2
1 3
1 4
2 5
3 4

Output:
{0=[1, 2, 3], 1=[0, 4], 2=[0, 3], 3=[0, 2], 4=[1]}
found cycle : 1, 4

 */

package Graphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class checking_cycles {

    static void cycle(Map<Integer, List<Integer>> graph, int n) {

        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        s.push(0);
        m.put(0, 1);

        while (s.size() != 0) {
            int x = s.peek();
            int count = 0;

            if (!graph.containsKey(x)) {
                continue;
            }

            for (int i : graph.get(x)) {
                if (!m.containsKey(i)) {
                    m.put(i, m.get(x));
                    s.push(i);
                    count++;
                    break;
                } else if (m.get(i) != m.get(x)) {
                    m.put(i, m.get(x));
                    s.push(i);
                    count++;
                    break;
                } else {
                    System.out.println("found cycle : "+(i+1)+", "+(x+1));
                    return;
                }
            }

            if (count == 0) {
                s.pop();
            } else {
                graph.get(x).remove(0);
                graph.get(s.peek()).remove(new Integer(x));
            }
        }
        System.out.println(m);
        System.out.println("no cycle found");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
                graph.get(x).add(y);
            } else {
                graph.get(x).add(y);
            }

            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
                graph.get(y).add(x);
            } else {
                graph.get(y).add(x);
            }
        }

        System.out.println(graph);

        cycle(graph, n);

    }
}