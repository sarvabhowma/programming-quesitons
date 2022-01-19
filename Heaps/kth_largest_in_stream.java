/*
displaying the kth largest element in the stream

Input :
enter the number of elements :
7
enter the value of k :
2
enter the values :
12 3 43 34 25 54 9

Output :
kth : 12
kth : 34
kth : 34
kth : 43
kth : 43

 */

package Heaps;

import java.util.Scanner;
import java.util.PriorityQueue;

public class kth_largest_in_stream {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number of elements : ");
        int n = sc.nextInt();

        System.out.println("enter the value of k : ");
        int k = sc.nextInt();

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        System.out.println("enter the values : ");

        for (int i = 0; i < n; i++) {
            if (i < k) {
                min_heap.add(sc.nextInt());
            } else {
                int x = sc.nextInt();
                if (min_heap.peek() > x) {
                    System.out.println("kth : " + min_heap.peek());
                } else {
                    min_heap.remove();
                    min_heap.add(x);
                    System.out.println("kth : " + min_heap.peek());
                }
            }
        }
    }
}
