/*
Find four elements i,j,k,l in an array such that i+j=k+l

Input:
7 // array size
6 2 3 4 5 10 1

output:
( 6, 1 ), ( 2, 5 )

 */

package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class two_pairs_with_equal_sum {

    static class pair{
        int i,j;
        pair next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,pair> map = new HashMap<>();
        int a [] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){

            int flag = 0;
            for(int j=i;j<n;j++){
                int sum = a[i]+a[j];
                if(map.containsKey(sum)){
                    System.out.println("( "+map.get(sum).i+", "+map.get(sum).j+" ), ( "+a[i]+", "+a[j]+" )");
                    flag +=1;
                    break;
                }
                else{
                    pair p = new pair();
                    p.i = a[i];
                    p.j = a[j];
                    p.next = null;
                    map.put(sum,p);
                }
            }
            if(flag==1)
                break;
        }

    }
}
