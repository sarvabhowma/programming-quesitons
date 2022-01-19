/*
Given a sorted array of non repeating integer check there
is an index i, for which a[i] = i;

Input:
7
-2 -1 0 2 3 5 67 98

Output:
5

 */
package divide_and_conquer;

import java.util.Scanner;

public class index_i {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] ==mid) {
                l = mid;
                break;
            } else if (a[mid] < mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
}
