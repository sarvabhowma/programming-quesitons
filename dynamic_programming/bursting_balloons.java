/*
find the maximum coins we can collect by bursting balloons
we cannot burst the ending balloons

Input:
5
10 1 2 3 5

Output:
0 0 20 80 230
0 0 0 6 40
0 0 0 0 30
0 0 0 0 0
0 0 0 0 0
maximum coins : 230
 */

package dynamic_programming;

import java.util.Scanner;

public class bursting_balloons{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int cost[][] = new int[n][n];

        for(int i=2;i<n;i++){
            int k=0;
            for(int j=i;j<n;j++){

                for(int u=k+1;u<j;u++){
                    cost[k][j] = Math.max(cost[k][j],cost[k][u]+cost[u][j]+a[k]*a[u]*a[j]);
                }

                k++;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("maximum coins : "+cost[0][n-1]);

    }
}


