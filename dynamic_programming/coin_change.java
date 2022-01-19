/*
total possible ways of getting the money needed
with the given coins

Input:
3 // no of coins
1 2 3
5 // money needed

Output:
1 1 1 1
0 1 1 1
0 1 2 2
0 1 2 3
0 1 3 4
0 1 3 5
5

 */

package dynamic_programming;

import java.util.Scanner;

public class coin_change{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];

        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int a[][] = new int[k+1][n+1];

        for(int i=0;i<k+1;i++){
            for(int j=0;j<=n;j++){

                if(i==0){
                    a[i][j] = 1;
                }
                else if(j==0){
                    a[i][j] = 0;
                }
                else if(i>=coins[j-1]){
                    a[i][j] = a[i][j-1]+a[i-coins[j-1]][j];
                }
                else{
                    a[i][j] = a[i][j-1];
                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(a[k][n]);

    }
}