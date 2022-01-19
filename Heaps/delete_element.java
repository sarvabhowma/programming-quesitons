/*
deleting an element from the min heap

Input:
enter the size of heap : 5
enter the elements : 12 3 34 23 45
3 12 23 34 45
enter the element to delete : 23

Output:
3 12 45 34

 */

package Heaps;

import java.util.Scanner;
import java.util.PriorityQueue;

public class delete_element {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        System.out.print("enter the size of heap : ");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.print("enter the elements : ");
        for (int i = 0; i < n; i++) {
            min_heap.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            a[i] = min_heap.remove();
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.print("enter the element to delete : ");
        int k = sc.nextInt();
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                index = i;
            }
        }

        a[index] = a[n - 1];

        while (index < n) {
            int x = 2 * index;
            if (x + 1 < n) {
                if (a[x + 1] < a[index]) {
                    a[index] = a[index] + a[x + 1];
                    a[x + 1] = a[index] - a[x + 1];
                    a[index] = a[index] - a[x + 1];
                    index = x + 1;
                }
            } else {
                index = x + 1;
            }
            if (x + 2 < n) {
                if (a[x + 2] < a[index]) {
                    a[index] = a[index] + a[x + 2];
                    a[x + 2] = a[index] - a[x + 2];
                    a[index] = a[index] - a[x + 2];
                    index = x + 2;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }
}
