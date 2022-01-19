/*
Given an array of non-negative integers nums,
you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Input:
5
2 3 1 1 4

Output:
minimum number of jumps is : 2

 */

package dynamic_programming;

import java.util.*;

public class jump_game {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n-1;i++){
            a[i] = sc.nextInt();
        }

        int max_dist = 0;
        int end = 0;
        int jump_count = 0;

        for(int i=0;i<n-1;i++){
            max_dist = Math.max(max_dist,i+a[i]);

            if(i==end){
                jump_count++;
                end = max_dist;
            }
        }

        System.out.println("\nminimum number of jumps is : "+jump_count);
    }
}
