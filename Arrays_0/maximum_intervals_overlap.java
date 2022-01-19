/*
Consider a big party where N guests came to it and
a log register for guest’s entry and exit times was maintained.
Find the minimum time at which there were maximum guests at the party.
Note that entries in the register are not in any order.

Input:
5
1 2 10 5 5
4 5 12 9 12

Output:
3, 5
 */

package Arrays_0;

import java.util.*;

public class maximum_intervals_overlap {

    public static int[] findMaxGuests(int[] Entry,int Exit[], int N){
        // add code here.
        int maxs = 0;
        for(int i=0;i<N;i++){
            maxs = Math.max(maxs,Math.max(Entry[i],Exit[i]));
        }
        int a[] = new int[maxs+2];

        for(int i=0;i<N;i++){
            a[Entry[i]]++;
            a[Exit[i]+1]--;
        }

        int max_overlap = 0;
        int idx = 0;
        int count = 0;

        for(int i=0;i<=maxs+1;i++){
            count += a[i];
            if(count>max_overlap){
                max_overlap = count;
                idx = i;
            }
        }
        return new int[]{max_overlap,idx};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int entry[] = new int[n];
        int exit[] = new int[n];
        for(int i=0;i<n;i++){
            entry[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            exit[i] = sc.nextInt();
        }
        int out[] = findMaxGuests(entry,exit,n);
        System.out.println(out[0]+", "+out[1]);
    }
}
