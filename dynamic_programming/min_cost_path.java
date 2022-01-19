/*
finding the minimum cost path from (0,0) to (n,n)

Input:
4
1 2 3 4
4 5 8 3
1 5 9 2
6 2 4 3

Output:
1 3 6 10
5 6 11 9
6 10 15 11
12 8 12 14
14

 */

package dynamic_programming;

import java.util.Scanner;

public class min_cost_path{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cost[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<n;i++){
            cost[0][i] += cost[0][i-1];
            cost[i][0] += cost[i-1][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                int p = Math.min(Math.min(cost[i-1][j],cost[i-1][j-1]),cost[i][j-1]);
                cost[i][j] += p;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(cost[n-1][n-1]);

    }
}