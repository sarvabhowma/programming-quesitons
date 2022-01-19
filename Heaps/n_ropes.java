/*
joining n-ropes to form a single rope, with minimum cost

Input :
7
12 3 43 34 25 54 9

Output :
12 3 9 // cost, first min, sec min at every merge
36 12 12
85 24 25
162 34 43
265 49 54
445 77 103
the total cost of joining the ropes is : 445

 */


package Heaps;

import java.util.Scanner;
import java.util.PriorityQueue;

public class n_ropes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            min_heap.add(a[i]);
        }

        int cost = 0;
        while (min_heap.size() > 1) {
            int x = min_heap.remove();
            int y = min_heap.remove();
            cost += x + y;
            min_heap.add(x + y);
            System.out.println(cost + " " + x + " " + y);
        }

        System.out.println("the total cost of joining the ropes is : " + cost);

    }
}
