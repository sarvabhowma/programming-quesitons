/*
longest decreasing subsequence in an array

Input:
8
2 10 11 5 3 4 12 1

Output:
maximum length is : 4
11 5 4 1 // sequence
 */

package dynamic_programming;

import java.util.Scanner;

public class longest_decreasing_subsequence {

    static class pair {
        int x, y;

        pair(int i, int j) {
            x = i;
            y = j;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        pair p[] = new pair[n];
        p[n - 1] = new pair(1, -1);
        int max = 0;
        int index = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = n - 2; i >= 0; i--) {
            p[i] = new pair(0, -1);
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i] && p[i].x < p[j].x + 1) {
                    p[i].x = p[j].x + 1;
                    p[i].y = j;
                }
            }
            if (max < p[i].x) {
                max = p[i].x;
                index = i;
            }
        }
        System.out.println("maximum length is : " + max);

        while (index != -1) {
            System.out.print(a[index] + " ");
            index = p[index].y;
        }

    }
}