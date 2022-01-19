/*
maximum sum increasing sub sequence

Input:
7
1 2 3 1 3 4 5

Output:
15

 */

package dynamic_programming;

import java.util.Scanner;

public class max_sum_inc_subsequence {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int s[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            s[i] = a[i];
        }
        int max_sum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(a[j]<a[i] && s[j]+a[i] > s[i]){
                    s[i] = s[j]+a[i];
                }
            }
            if(max_sum<s[i]){
                max_sum = s[i];
            }
        }

        System.out.println(max_sum);
    }
}
