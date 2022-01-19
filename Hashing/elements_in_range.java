/*
Given an array and a range[ low, high ], Find the elements that are in the range but not in the array

Input:
9 // size of the list
52 9 5 3 50 15 51 45 32
48 // lower limit
53 // upper limit

output:
48 49 53

 */

package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class elements_in_range {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            if(map.containsKey(a[i])){
                map.replace(a[i],map.get(a[i])+1);
            }
            else{
                map.put(a[i],1);
            }
        }
        int left = sc.nextInt();
        int right = sc.nextInt();

        for(int i=left;i<=right;i++){
            if(!map.containsKey(i)){
                System.out.print(i+" ");
            }
        }

    }
}
