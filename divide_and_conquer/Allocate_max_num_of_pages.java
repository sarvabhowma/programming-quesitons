/*
google it

Input:
4
12 34 67 90
2

Output:
113

 */

package divide_and_conquer;

import java.util.*;

public class Allocate_max_num_of_pages {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int l=-1;
        int r=0;
        for(int i=0;i<n;i++){
            l = Math.max(l,a[i]);
            r += a[i];
        }

        while(l<=r){
            int mid = (l+r)/2;
            int sum=0;
            int count=1;
            for(int i=0;i<n;i++) {
                if (sum + a[i] <= mid) {
                    sum += a[i];
                } else {
                    sum = a[i];
                    count++;
                }
            }
            if(count<=m){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        System.out.println(l);
    }
}
