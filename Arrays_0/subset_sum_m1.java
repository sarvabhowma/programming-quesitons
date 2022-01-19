/*
Find the subarray with given sum - x.
no - negative numbers.
Input:
9
5 4 6 7 9 8 3 1 2
21

Output:
9 8 3 1

 */

package Arrays_0;
import java.util.*;


public class subset_sum_m1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];

        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();

        int l=0,r=1,sum=0,x;
        x = sc.nextInt();
        sum = a[0];

        while(l<n && r<n){
            if(sum>x)
                sum -= a[l++];
            else if(sum<x)
                sum += a[r++];
            else
                break;
        }
        if(sum==x)
            for(int i=l;i<r;i++)
                System.out.print(a[i]+" ");
        else
            System.out.println("NO");

    }

}

