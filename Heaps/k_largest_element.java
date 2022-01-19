/*
k largest elements in the given array

Input:
no of elements : 7
enter the values : 12 3 43 34 25 54 9
[54, 34, 43, 3, 25, 12, 9]
enter the k value : 2

Output:
54 43

 */

package Heaps;

import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class k_largest_element {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        System.out.print("no of elements : ");
        int n = sc.nextInt();

        System.out.print("enter the values : ");
        for (int i = 0; i < n; i++) {
            max_heap.add(sc.nextInt());
        }

        System.out.println(max_heap);

        System.out.print("enter the k value : ");
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            System.out.print(max_heap.remove() + " ");
        }

    }
}


