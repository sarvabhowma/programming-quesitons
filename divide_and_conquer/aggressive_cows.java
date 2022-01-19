/*
google for question

Input:
5
1 2 4 8 9
3
Output:
3

 */

package divide_and_conquer;

import java.util.*;

public class aggressive_cows {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int cows = sc.nextInt();

        Arrays.sort(a);
        int l = 0;
        int r = a[n-1]-a[0];
        int result = 0;

        while(l<=r){
            int mid = (l+r)/2;
            int count = 1;
            int i = 0;
            while(count<cows){
                int j = i+1;
                for(;j<n;j++){
                    if(a[j]-a[i]>=mid){
                        count++;
                        i = j;
                        break;
                    }
                }
                if(j==n){
                    break;
                }
            }

            if(count>=cows){
                result = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        System.out.println(result);
    }
}
