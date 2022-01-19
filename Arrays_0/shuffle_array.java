/*
shuffling the given array
the array size should be even for this

Input:
8
1 2 3 4 5 6 7 8

Output:
1 5 2 6 3 7 4 8

 */
package Arrays_0;

import java.util.Scanner;

public class shuffle_array {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int mid = (0 + n - 1) / 2;
        int temp = mid + 1;

        for (int i = 1; i <= mid; i++) {
            temp = mid + 1;
            for (int j = i; j <= mid; j++) {
                int k = a[j];
                a[j] = a[temp];
                a[temp] = k;
                temp++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
