/*
Find the subarray with given sum - x.
array can contain negative numbers
Input:
9
5 4 6 7 9 8 3 1 2
21

Output:
9 8 3 1

 */

package Arrays_0;
import java.util.*;

public class subset_sum_m2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        Map<Integer,Integer> m = new HashMap();
        int s=0;

        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        m.put(0,0);
        int x = sc.nextInt();
        int r=0,l=0,count=0;
        s=0;

        while(r<n){
            s += a[r++];
            if(m.containsKey(s-x)) {
                l = m.get(s - x);
                count++;
                break;
            }
            m.put(s,r);
        }

        if(count!=0)
            for(int i=l;i<r;i++)
                System.out.print(a[i] + " ");
        else
            System.out.println("NO");

    }

}

