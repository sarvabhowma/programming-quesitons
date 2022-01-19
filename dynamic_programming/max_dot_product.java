/*
finding the max dot product possible for the
given two arrays

Input:
enter the first array size : 5
enter the second array size : 3
2 3 1 7 8
7 3 6

Output:
14 21 21 49 56
0 9 24 42 73
0 0 6 66 90
max profit : 90

 */

package dynamic_programming;

import java.util.Scanner;

public class max_dot_product{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the first array size : ");
        int n = sc.nextInt();
        System.out.print("enter the second array size : ");
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int j=0;j<m;j++){
            b[j] = sc.nextInt();
        }

        int dp[][] = new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][i] = a[i]*b[i];
        }

        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){

                if(i==0){
                    dp[i][j] = Math.max(dp[i][j-1],b[i]*a[j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],b[i]*a[j]+dp[i-1][j-1]);
                }

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("max profit : "+dp[m-1][n-1]);

    }
}

