/*
Matrix Multiplication

Input:
enter r1 :1
enter c1 :3

enter r2 :3
enter c2 :1

1 2 3 // 1st matrix

3 // 2nd matrix
2
1

Output:
10

 */

package Arrays_0;

import java.util.*;

public class Matrix_Multiplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter r1 :");
        int r1 = sc.nextInt();

        System.out.print("enter c1 :");
        int c1 = sc.nextInt();

        System.out.print("\nenter r2 :");
        int r2 = sc.nextInt();

        System.out.print("enter c2 :");
        int c2 = sc.nextInt();

        int a[][] = new int[r1][c1];
        int b[][] = new int[r2][c2];
        int c[][] = new int[r1][c2];

        System.out.println();

        // matrix 1
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++)
                a[i][j] = sc.nextInt();
        }

        System.out.println();

        // matrix 2
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                b[i][j] = sc.nextInt();
// Matrix Multiplication
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < r2; k++)
                    c[i][j] += a[i][k] * b[k][i];
            }
        }
        System.out.println();

        // result
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++)
                System.out.print(c[i][j] + " ");
            System.out.println();
        }

    }

}
