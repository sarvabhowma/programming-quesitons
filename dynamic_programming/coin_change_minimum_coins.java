/*
minimum number of coins required for getting the money needed
with the given coins

Input:
3 // no of coins
1 2 3
5 // money needed

Output:
1 1 1 2 2
minimum number of coins required : 2

 */
package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class coin_change_minimum_coins {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];

        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }

        int sum = sc.nextInt();
        int dp[] = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<sum+1;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    int x = dp[i-coins[j]]+1;
                    if(x<dp[i]){
                        dp[i] = x;
                    }
                }
            }
            System.out.print(dp[i]+" ");
        }
        System.out.println("\nminimum number of coins required : " + dp[sum]);
    }
}
