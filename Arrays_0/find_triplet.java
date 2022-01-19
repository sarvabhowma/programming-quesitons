/*
Given an array, find three elements such that their sum is equal to x.

Input:
6
0 3 44 5 9 7
19

Output:
3 7 9

 */

package Arrays_0;
import java.util.*;

public class find_triplet {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        int x = sc.nextInt();
        Arrays.sort(a);
        int sum=0;
        for(int i=0;i<n;i++)
        {
            int l=i+1;
            int r=n-1;
            int count= 0;
            while(l<r){
                sum = a[i]+a[l]+a[r];
                if(sum==x)
                {
                    System.out.println(a[i]+" "+a[l]+" "+a[r]);
                    count++;
                    break;
                }
                else if(sum<x)
                    l++;
                else
                    r--;
            }
            if(count!=0)
                break;
        }
        if(sum!=x)
            System.out.println("NO");
    }

}



