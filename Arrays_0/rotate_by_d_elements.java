/*
Rotate an array of size-n by d-elements.

Input:
9
1 2 3 4 5 6 7 8 9
4

Output:
5 6 7 8 9 1 2 3 4

 */

package Arrays_0;
import java.util.*;

public class rotate_by_d_elements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int d = sc.nextInt();
        for (int i = 0; i < d / 2; i++) {
            int x = a[i];
            a[i] = a[d - 1 - i];
            a[d - 1 - i] = x;
        }
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        for (int i = d; i < d + (n - d) / 2; i++) {
            int x = a[i];
            a[i] = a[n - 1 - i+d];
            a[n - 1 - i+d] = x;
        }
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        for (int i = 0; i < n / 2; i++) {
            int x = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = x;
        }
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

    }

}
