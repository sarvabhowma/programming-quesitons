/*
no of ways to fill a 2*n board using 2*1 tiles

Input:
5

Output:
no of ways to fill a 2*n board with 2*1 : 8

 */
package dynamic_programming;

import java.util.Scanner;

public class filling_board {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f[] = new int[n];
        f[0] = 1;
        f[1] = 2;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        System.out.println("no of ways to fill a 2*n board with 2*1 : " + f[n - 1]);

    }
}