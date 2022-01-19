/*
find the sub-arrays in the given array with sum equals to zero

Input:
18
11 21 16 13 2 -12 -15 25 -11 11 10 -5 -3 -2 10 5 -1 -5

Output:
2 -12 -15 25
-11 11
-12 -15 25 -11 11 10 -5 -3
10 -5 -3 -2
-5 -3 -2 10

 */

package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class sub_arrays_with_0_sum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum +=a[i];
            if(map.containsKey(sum)){
                for(int j=map.get(sum)+1;j<=i;j++){
                    System.out.print(a[j]+" ");
                }
                map.replace(sum,i);
                System.out.println();
            }
            else {
                map.put(sum, i);
            }
        }
    }
}
