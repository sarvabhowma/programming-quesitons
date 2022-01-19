/*
Next greater number with same set of digits.

Input:
7
1 2 3 7 6 5 1
*here we consider number as -> 1237651

Output:
1251367

 */

package Arrays_0;

import java.util.*;

public class next_greater_number_with_same_numbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        ArrayList<Integer> l = new ArrayList();
        l.add(a[n - 1]);

        int k = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = l.size() - 1;
            while (j >= 0) {
                if (a[i] > l.get(j))
                    break;
                j--;
            }
            if ((j < l.size() - 1)) {
                int x = a[i];
                a[i] = l.get(j + 1);
                l.set(j + 1, x);
                k = i;
                break;
            } else
                l.add(a[i]);
        }
        for (int i = 0, j = 0; i < n; i++) {
            if (i <= k)
                System.out.print(a[i]);
            else
                System.out.print(l.get(j++));
        }

    }

}


