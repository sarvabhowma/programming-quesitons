/*
rotating the array k-times in anti-clock wise

Input:
5 // array size
1 2 3 4 5
2 // no-of-rotations

output:
4 5 1 2 3

 */

package Arrays_0;

import java.util.*;

public class k_rotations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int c = 1;
        int x = a[0];
        int j , i = 0;

        int k = sc.nextInt();

        while (c <= n+1) {
            j = i + k;
            if(j>=n)
                j = j-n;
            x = x+a[j];
            a[j] = x-a[j];
            x = x-a[j];
            i=j;
            if((k%2==0)&&(n%2==0)&&(c==n/2)){
                i =1;
                x = a[i];
            }
            c++;
        }

        for(i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }

    }
}
