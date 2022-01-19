/*
Find the largest sub array with equal number of 0’s and 1’s.

Input:
16
1 1 1 0 1 0 0 1 1 0 1 0 0 1 0 1

Output:
14
1 1 0 1 0 0 1 1 0 1 0 0 1 0

 */

package Arrays_0;
import java.util.*;

public class subarray_with_equal_0_and_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> m = new HashMap();
        int s = 0;

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        m.put(0, 0);
        int r = 0, l = 0, count = 0, max = 0, l1 = 0, r1 = 0;
        s = 0;

        while (r1 < n) {
            int x = a[r1++];
            if (x == 0)
                s += -1;
            else
                s += 1;
            if (m.containsKey(s)) {
                l1 = m.get(s);
                count++;
                if (max < r1 - l1) {
                    max = r1 - l1;
                    l = l1;
                    r = r1;
                }
            } else
                m.put(s, r1);
        }

        if (count != 0) {
            System.out.println(max);
            for (int i = l; i < r; i++)
                System.out.print(a[i] + " ");
        } else
            System.out.println("NO");

    }

}
