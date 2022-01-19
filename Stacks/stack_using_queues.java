/*
Implement stack using two queues

Input:
7 // array size
1 2 3 4 5 6 7

output:
7 6 5 4 3 2 1

 */

package Stacks;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class stack_using_queues {

    static Queue<Integer> push(Queue<Integer> q, int k) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(k);

        while (q.size() != 0) {
            int x = q.remove();
            q1.add(x);
        }

        return q1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt();
        q.add(sc.nextInt()); // adding first element

        // for push operation in stack
        for (int i = 1; i < n; i++) {
            q = push(q, sc.nextInt());
        }

        // for pop operation in stack
        while(q.size()!=0) {
            System.out.print(q.remove() + " ");
        }

    }
}








