/*
finding median for every new element entered

Input :
enter the number of elements :
5
enter the elements :
1 2 3 4 5

Output :
1st median : 1
2nd median : 1, 2
3 median : 2
4 median : 2, 3
5 median : 3

 */

package Heaps;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;


public class median_in_stream {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("enter the number of elements : ");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("enter the elements : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        max_heap.add(a[0]);

        System.out.println("1st median : "+a[0]);

        if(max_heap.peek()>a[1]){
            min_heap.add(max_heap.remove());
            max_heap.add(a[1]);
            System.out.println("2nd median : "+max_heap.peek()+", "+min_heap.peek());
        }
        else{
            min_heap.add(a[1]);
            System.out.println("2nd median : "+max_heap.peek()+", "+min_heap.peek());
        }

        for (int i = 2; i < n; i++) {
            if (a[i]<max_heap.peek()){
                if(max_heap.size()>min_heap.size()){
                    min_heap.add(max_heap.remove());
                    max_heap.add(a[i]);
                    System.out.println(i+1+" median : "+max_heap.peek()+", "+min_heap.peek());
                }
                else{
                    max_heap.add(a[i]);
                    System.out.println(i+1+" median : "+max_heap.peek());
                }
            }
            else{
                if(min_heap.size()>max_heap.size()){
                    max_heap.add(min_heap.remove());
                    min_heap.add(a[i]);
                    System.out.println(i+1+" median : "+max_heap.peek()+", "+min_heap.peek());
                }
                else{
                    min_heap.add(a[i]);
                    System.out.println(i+1+" median : "+min_heap.peek());
                }
            }
        }
    }
}
