/*
sorting a k-sorted array
k-sorted means the position of a element in a sorted array is max k cells away from
the current position

Input :
6
enter the value of k :
3
2 3 6 12 56 8 // here the position of 8 is 2 cells amd 12 is 1 cell likewise

Output :
2 3 6 8 12 56

 */


package Heaps;

import java.util.Scanner;
import java.util.PriorityQueue;

public class k_sorted_array {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        System.out.println("enter the value of k : " );
        int k = sc.nextInt();

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i = 0;i<=k;i++){
            min_heap.add(a[i]);
        }
        int c = 0;
        a[c++] = min_heap.remove();

        for(int i=k+1;c<n;c++,i++){
            if(i<n){
                min_heap.add(a[i]);
                a[c]=min_heap.remove();
            }
            else{
                a[c] = min_heap.remove();
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }

    }
}
