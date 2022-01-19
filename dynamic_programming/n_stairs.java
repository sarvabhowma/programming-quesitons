/*
no of ways we can reach nth stair given,
we can go 1 or 2 steps at a time

Input:
28

Output:
514229

 */
package dynamic_programming;

import java.util.Scanner;

public class n_stairs{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f[] = new int[n];
        f[0] = 1;
        f[1] = 2;

        for(int i=2;i<n;i++){
            f[i] = f[i-1]+f[i-2];
        }

        System.out.println(f[n-1]);
    }
}