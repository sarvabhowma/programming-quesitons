/*
sum of two elements closest to zero.

Input:
6
0 59 -9 69 -79 84

output:
5

 */
package Arrays_0;
import java.util.Arrays;
import java.util.Scanner;

public class sum_close_to_zero {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int l=0,r=n-1,sum=999999;
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        while(l<r){
            int x = a[l]+a[r];
            if(Math.abs(sum)>Math.abs(x))
                sum=x;
            if(x<0)
                l++;
            else if(x>0)
                r--;
            else
                break;

        }
        System.out.println(sum);

    }

}

