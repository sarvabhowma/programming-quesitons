/*
next largest element for the current element in the given array

Input:
5
10 20 1 5 25

output:
20 25 5 25 -1

 */

package Stacks;

import java.util.Scanner;
import java.util.Stack;


public class next_large_number {

    static class pair{
        int value, index;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Stack<pair> s = new Stack<>();
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            while(s.size()!=0 && s.peek().value<a[i]){
                int x = s.pop().index;
                a[x] = a[i];
            }
            pair p = new pair();
            p.value = a[i];
            p.index = i;
            s.push(p);
        }

        while(s.size()!=0){
            int x = s.pop().index;
            a[x] = -1;
        }

        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
