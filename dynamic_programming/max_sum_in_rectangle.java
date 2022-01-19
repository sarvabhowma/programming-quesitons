/*
finding the maximum sum in the 2*n rectangle
cannot include numbers in two adjacent columns

Input:
5
1 2 3 4 6
0 5 2 1 7

Output:
1 5 5 9 12
max sum : 12

 */

package dynamic_programming;

import java.util.Scanner;

public class max_sum_in_rectangle{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[2][n];
        int d[] = new int[n];

        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        d[0] = Math.max(a[0][0],a[1][0]);
        d[1] = Math.max(a[0][1],a[1][1]);
        d[1] = Math.max(d[0],d[1]);

        for(int i=2;i<n;i++){
            int x = Math.max(a[0][i],a[1][i]);
            d[i] = Math.max(d[i-1],x+d[i-2]);
        }

        for(int i=0;i<n;i++){
            System.out.print(d[i]+" ");
        }

        System.out.println("\nmax sum : "+d[n-1]);

    }
}