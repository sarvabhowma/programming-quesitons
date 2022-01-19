/*
finding a subset whose sum is equal to the given number

Input:
4 // size of array
1 4 5 6
6 // number

Output:
1 5
6

 */
package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class subset_sum {

    static void subset_sum(int[] a, int index, int sum, List<Integer> l, int k){

        if(sum==k){
            for(int i:l){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        else if(sum>k || index>=a.length) {
            return;
        }

        for(int i=index;i<a.length;i++){
            l.add(a[i]);
            sum+=a[i];
            subset_sum(a,i+1,sum,l,k);
            l.remove(l.size()-1);
            sum-=a[i];
        }

        return;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        List<Integer> l = new ArrayList<>();

        subset_sum(a,0,0,l,k);
    }

}
