/*
display the maximum element in the min heap

Input:
7
enter the elements into the heap :
12 3 5 86 23 6 34

Output:
3 5 6 12 23 34 86
86

 */
package Heaps;

import java.util.Scanner;
import java.util.PriorityQueue;

public class max_element {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        System.out.println("enter the size of the heap : ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("enter the elements into the heap : ");
        for (int i = 0; i < n; i++) {
            min_heap.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            a[i] = min_heap.remove();
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int max = 0;

        for (int i = (int) Math.ceil(n / 2); i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        System.out.println(max);

    }
}
