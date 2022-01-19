/*
sorting the given array in wave form.

Input:
9
2 3 4 5 6 7 8 9 1

Output:
2 1 4 3 6 5 8 7 9
 */

package Arrays_0;

import java.util.*;

public class sort_array_in_wave_form_m2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 1; i < n; i += 2) {
            if (a[i] > a[i - 1]) {
                int x = a[i];
                a[i] = a[i - 1];
                a[i - 1] = x;
            }
            if ((i + 1 < n) && (a[i + 1] < a[i])) {
                int x = a[i];
                a[i] = a[i + 1];
                a[i + 1] = x;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

    }

}
