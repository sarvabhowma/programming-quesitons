/*
check whether the two arrays are disjoint or not

Input:
5 // first array
1 2 3 4 5
5 // sec array
6 7 8 9 0

output:
Disjoint

Input:
5
1 2 3 4 5
7
1 232 45 643 6 7 9

Output:
Not Disjoint

 */
package Hashing;

import java.util.*;

public class disjoint_sets {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int a[]= new int[m];
        for(int i = 0;i<m;i++) {
            a[i] = sc.nextInt();
            map.put(a[i],1);
        }
        int n = sc.nextInt();
        int b[] = new int[n];
        int count=0;
        for(int i = 0;i<n;i++) {
            b[i] = sc.nextInt();
            if(map.containsKey(b[i]))
                count+=1;
        }
        if(count!=0)
            System.out.println("Not Disjoint");
        else
            System.out.println("Disjoint");

    }
}
