/*
Separate 0's and 1's in an array.

Input:
8
1 0 1 0 1 0 1 1

Output:
0 0 0 1 1 1 1 1

 */

package Arrays_0;
import java.util.Scanner;

public class Seperate_0_and_1_m2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l=0, r=n-1;
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        while(l<r){
            if(a[l]==1 && a[r]==0)
            {
                a[l++]=0;
                a[r--]=1;
            }
            if(a[l]==0)
                l++;
            if(a[r]==1)
                r--;
        }
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }

}
