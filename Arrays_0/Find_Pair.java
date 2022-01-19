/*
Given an array, find two elements such that their sum is equal to x.

Input:
6
0 3 44 5 9 7
49

Output:
5 44

 */

package Arrays_0;
import java.util.*;


public class Find_Pair {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=0;
        int[] a=new int[n];
        for(int i=0; i<n;i++){
            a[i] = sc.nextInt();
            if(l<a[i])
                l=a[i];
        }
        int h[]=new int[l+1];
        Arrays.fill(h,0);
        int x = sc.nextInt();
        for(int i=0;i<n;i++){
            int k=x-a[i];
            if(k>=0 && h[k]==1)
                System.out.println(a[i]+" "+k);
            h[a[i]]=1;
        }
    }
}
