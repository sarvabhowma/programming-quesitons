/*
finding the majority element in the given array
majority element = element occurred more than half

Input:
7
1 2 3 3 3 3 4

Output:
yes : 3

 */
package divide_and_conquer;

import java.util.Scanner;

public class majority_element {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int r;

        if (n % 2 == 0) {
            r = (n / 2) - 1;
        } else {
            r = n / 2;
        }

        int l = 0, k = a[r];


        while (l < r) {
            int mid = (l + r) / 2;

            if (a[mid] == k) {
                if (a[mid - 1] == k) {
                    r = mid - 1;
                } else {
                    l = mid;
                    break;
                }
            } else if (a[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (a[l + n / 2] == k) {
            System.out.println("yes : " + a[l]);
        } else {
            System.out.println("no");
        }

    }
}