/*
check whether the array has duplicates in k-distance or not

Input:
5 // array size
1 2 3 2 5
2 // k value

output:
Duplicates

Input:
6
1 2 3 4 2 5
2

Output:
No Duplicates

 */

package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class duplicates_in_k_distance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> m = new HashMap<>();
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt()+1;
        int count = 0;

        for (int i = 0; i < k; i++) {

            if (m.containsKey(a[i])) {
                count++;
                break;
            }
            m.put(a[i], i);
        }

        if (count != 1) {
            for (int i = k; i < n; i++) {
                m.remove(a[i - k]);
                if (m.containsKey(a[i])) {
                    count++;
                    break;
                }
                m.put(a[i], i);
            }
        }

        if (count == 1)
            System.out.println("Duplicates");
        else
            System.out.println("No Duplicates");

    }
}
