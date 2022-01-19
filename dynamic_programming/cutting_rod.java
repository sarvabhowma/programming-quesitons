/*
cutting a rod for getting maximum profit

Input:
8 // length of the rod
1 5 8 9 10 17 17 20 // cost of each length

Output:
1 5 8 10 13 17 18 22 // max cost for each length
maximum cost : 22

 */

package dynamic_programming;

import java.util.Scanner;

public class cutting_rod{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];

        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=1;i<=n;i++){
            int max = 0;

            for(int j=1;j<=i;j++){
                max = Math.max(max,a[j]+a[i-j]);
            }
            a[i] = max;
            System.out.print(a[i]+" ");
        }
        System.out.println("\nmaximum cost : "+a[n]);

    }
}


