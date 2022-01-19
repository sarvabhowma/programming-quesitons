/*
Inversion Count: For an array, inversion count indicates
how far (or close) the array is from being sorted.
If array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

using merge sort.

Input:
5
5 4 3 2 1

Output:
10

 */
package divide_and_conquer;

import java.util.*;

public class merge_sort {

    static int merge(int[] a, int s, int e){
        if(s==e){
            return 0;
        }

        int mid = (s+e)/2;
        int left = merge(a,s,mid);
        int right = merge(a,mid+1,e);

        int l = s;
        int r = mid+1;
        int count = 0;
        List<Integer> ls = new ArrayList<>();

        while(l<=mid && r<=e){
            if(a[l]<=a[r]){
                ls.add(a[l++]);
            }
            else{
                ls.add(a[r++]);
                count += mid-l+1;
            }
        }
        while(l<=mid){
            ls.add(a[l++]);
        }
        while(r<=e){
            ls.add(a[r++]);
        }

        for(int k: ls){
            a[s++] = k;
        }

        return left+count+right;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(merge(a,0,n-1));
    }
}
