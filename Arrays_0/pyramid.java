/*
for any given odd number print pattern given below

Input:
13

Output:
1                       1
1 0                   0 1
1 0 1               1 0 1
1 0 1 0           0 1 0 1
1 0 1 0 1       1 0 1 0 1
1 0 1 0 1 0   0 1 0 1 0 1
1 0 1 0 1 0 1 0 1 0 1 0 1
1 0 1 0 1 0   0 1 0 1 0 1
1 0 1 0 1       1 0 1 0 1
1 0 1 0           0 1 0 1
1 0 1               1 0 1
1 0                   0 1
1                       1

 */

package Arrays_0;

import java.util.*;

public class pyramid {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            if(i%2==0){
                a[i] = 1;
            }
            else{
                a[i] = 0;
            }
        }


        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++) {
                if (j <= i) {
                    System.out.print(a[j] + " ");
                } else if ((j >= (i + 1)) && (j < (n - i - 1))) {
                    System.out.print("  ");
                } else {
                    System.out.print(a[j] + " ");
                }
            }
            System.out.println();
        }

        for(int i =0 ;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        for(int i=n/2-1;i>=0;i--){
            for(int j=0;j<n;j++) {
                if (j <= i) {
                    System.out.print(a[j] + " ");
                } else if ((j >= (i + 1)) && (j < (n - i - 1))) {
                    System.out.print("  ");
                } else {
                    System.out.print(a[j] + " ");
                }
            }
            System.out.println();
        }

    }
}

