/*
connecting n ropes with minimum cost

Input:
6
2 3 5 7 9 13

Output:
39

 */
package Greedy_Algorithms;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

public class n_ropes_min_cost{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        Integer a[] = new Integer[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        q.addAll(Arrays.asList(a));

        while(q.size()!=1){
            int x = q.remove();
            int y = q.remove();
            q.add(x+y);
        }
        System.out.println(q.remove());
    }
}
