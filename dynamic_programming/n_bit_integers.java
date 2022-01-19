/*
finding the number of n-bit integers which do
not have any two consequent zeros
ex:
2 // n-value;
-> 10
-> 01
-> 11

Input:
4 // n-value

Output:
8 // total possibilities
 */

package dynamic_programming;

import java.util.Scanner;

public class n_bit_integers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f[] = new int[n + 1];

        f[0] = 0;
        f[1] = 2;
        f[2] = 3;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        System.out.println(f[n]);

    }
}