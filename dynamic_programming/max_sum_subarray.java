/*
maximum sum subarray in the given array

Input:
9
-2 1 -3 4 -1 2 1 -5 4

Output:
max sum : 6
1 2 -1 4 // series in reverse order

 */

package dynamic_programming;

import java.util.Scanner;

public class max_sum_subarray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int e = 0;
        int max_sum = 0;
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {

            if (curr_sum + a[i] > a[i]) {
                curr_sum =curr_sum + a[i];
            } else {
                curr_sum = a[i];
            }

            if (max_sum < curr_sum) {
                max_sum = curr_sum;
                e = i;
            }
        }

        System.out.println("\nmax sum : "+max_sum);

        while(max_sum>0) {
            System.out.print(a[e] + " ");
            max_sum -= a[e--];
        }


    }
}
