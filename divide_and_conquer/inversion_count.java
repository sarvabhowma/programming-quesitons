/*
inversion count of an array

Input:
6
7 5 1 3 4 6

Output:
8

 */

package divide_and_conquer;

import java.util.Scanner;

public class inversion_count{

    static int merge_sort(int[] a,int s,int e){

        if(s>=e){
            return 0;
        }
        int mid = (s+e)/2;

        int left = merge_sort(a,s,mid);
        int right = merge_sort(a,mid+1,e);

        int curr = 0,l=s,r=mid+1,k=0;
        int b[] = new int[e-s+1];

        while((l<=mid) && (r<=e)){
            if(a[l]<=a[r]){
                b[k++]=a[l++];
            }
            else{
                curr += mid-l+1;
                b[k++] = a[r++];
            }
        }
        while(l<=mid){
            b[k++] = a[l++];
        }
        while(r<=e){
            b[k++] = a[r++];
        }

        for(int i=s;i<=e;i++){
            a[i] = b[i-s];
        }
        return left+right+curr;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        System.out.println(merge_sort(a,0,n-1));
    }
}