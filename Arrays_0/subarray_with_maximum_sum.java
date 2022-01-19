/*
Find the subarray with the maximum sum.

Input:
9
-2 1 -3 4 -1 2 1 -5 4

Output:
start : 4
end : 7
sum : 6
 */

package Arrays_0;
import java.util.*;

public class subarray_with_maximum_sum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int curr_sum = 0, l = 0, max_sum = 0, r = 0;

        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (a[i] + curr_sum > a[i])
                curr_sum = a[i] + curr_sum;
            else {
                l = i+1;
                curr_sum = a[i];
            }
            if (max_sum < curr_sum) {
                max_sum = curr_sum;
                r = i+1;
            }
        }
        System.out.println("start : "+l);
        System.out.println("end : "+r);
        System.out.println("sum : "+max_sum);

    }

}
