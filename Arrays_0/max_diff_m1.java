/*
Find the maximum difference between two elements, such that larger
element appears after the smaller element.

input:
7
3 2 1 2 3 1 1

output:
2

 */

package Arrays_0;
import java.util.*;

public class max_diff_m1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n;i++)
            a[i] = sc.nextInt();
        int curr_diff=-1, max_diff=-1;

        for(int i=0;i<n-1;i++)
        {
            int x = a[i+1]-a[i];
            if(curr_diff>0)
                curr_diff +=x;
            else
                curr_diff = x;
            if(curr_diff>max_diff)
                max_diff = curr_diff;
        }
        System.out.println(max_diff);
    }

}
