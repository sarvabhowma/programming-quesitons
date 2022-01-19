/*
even length subarray such that sum of first half
if equal to second half

Input:
7
3 1 2 5 3 0 8

Output:
3 4 6 11 14 14 22
0 1 3 8 11 11 19
0 0 2 7 10 10 18
0 0 0 5 8 8 16
0 0 0 0 3 3 11
0 0 0 0 0 0 8
0 0 0 0 0 0 8
16
5 3 0 8

 */

package dynamic_programming;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class even_length_substring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[][] = new int[n][n];
        Map<Integer, int[]> m = new HashMap<>();
        int p = -1;
        int q = -1;
        int max = -1;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i][i] = a[i];
        }

        for (int i = 1; i < n; i++) {
            int k = 0;
            for (int j = i; j < n; j++) {
                b[k][j] = b[k][j - 1] + b[j][j];

                if ((i % 2 != 0) && (b[k][j] % 2 == 0)) {
                    if (!m.containsKey(b[k][j])) {
                        m.put(b[k][j], new int[]{k, j});
                    } else {
                        int x = m.get(b[k][j])[0];
                        int y = m.get(b[k][j])[1];

                        if (y - x == j - k && y + 1 == k && max < b[k][j]) {
                            p = x;
                            q = j;
                            max = b[k][j];
                        } else {
                            m.replace(b[k][j], new int[]{k, j});
                        }

                    }
                }
                k++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(2 * max);
        for (int i = p; i <= q; i++) {
            System.out.print(a[i] + " ");
        }

    }
}

